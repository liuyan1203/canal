package com.haiziwang.commodity.task;

import com.google.common.collect.Lists;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.dao.PackInfoDao;
import com.haiziwang.commodity.dao.SkuAreaDao;
import com.haiziwang.commodity.dao.SkuDao;
import com.haiziwang.commodity.dao.SpuDao;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.TMQMessageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 全量ES：主要用来解决个别数据缺失以及不一直的问题（例如获取名牌超时，消息丢失，消息推送失败等）
 * 文件中配置（spuId）
 */
@Component
public class ScheduledExecutor {
    //读取配置文件
    protected final static Logger logger = LoggerFactory.getLogger(ScheduledExecutor.class);

    private static AtomicLong printCnt = new AtomicLong(0);

    private List<String> spuIds = new ArrayList<>();

    //是否执行过标识
    private static AtomicBoolean execFlag = new AtomicBoolean(false);

    public void executeJob() {
        //防止重复执行
        synchronized (PackInfoScheduledExecutor.class) {
            if (execFlag.get() == false) {
                execFlag.set(true);
            } else {
                logger.info("重复执行了..");
                return;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InputStream inputStream = null;
        //是否开启定时任务
        if (1 == Constant.OPEN_SCHEDULE) {
            logger.info("定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
            spuIds.clear();
            inputStream = ScheduledExecutor.class.getClassLoader().getResourceAsStream("file/execSql1.txt");
        } else {
            return;
        }
        readFileByLinesV2(inputStream);
        parsePushEs();
    }

    public List<String> readFileByLinesV2(InputStream inputStream) {
        List<String> pushSpus = new ArrayList<>();
//        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            logger.info("开始读取文件流...");
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                logger.debug("line " + line + ": " + tempString);
                //内容处理逻辑、
                String spuId = parseLine(tempString);
                if (StringUtils.isNotEmpty(spuId)) {
                    spuIds.add(spuId);
                }
                line++;
            }
            logger.info("line " + line + ": 读到最后一行结束！！！");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return pushSpus;
    }

    private String parseLine(String line) {
        if (StringUtils.isEmpty(line)) {
            return null;
        }
        return line.trim();
    }

    private void parsePushEs() {

        CommonStrategyImpl commonStrategy = new CommonStrategyImpl();

        SpuDao spuDao = new SpuDao();
        SkuDao skuDao = new SkuDao();
        PackInfoDao packInfoDao = new PackInfoDao();
        SkuAreaDao skuAreaDao = new SkuAreaDao();
        int massPerLength = 100;
        int spuIdLength = spuIds.size();
        BigDecimal a = new BigDecimal(massPerLength);
        BigDecimal b = new BigDecimal(spuIdLength);
//        System.out.println(b.divide(a));
        long times = b.divide(a).setScale(0, BigDecimal.ROUND_UP).longValue(); // 向上取整
        int startIndex = 0;
        for (int i = 0; i < times; i++) {
//            System.out.println("第" + i + "段开始");
            //最后一次
            if (i == times - 1) {
                massPerLength = spuIdLength - i * massPerLength;
            }
            List<String> subSpus = spuIds.subList(startIndex, startIndex + massPerLength);
            //ES数据集合
            List<EsCommodityDTO> resultEsList = Lists.newArrayList();
            for (String spuId : subSpus) {
                //全量更新，upsert所有字段
                EsCommodityDTO spuEs = new EsCommodityDTO();
                spuEs.setFspuid(spuId);
                spuDao.getSpu(spuEs, spuId);
                //todo 这里后续加入children表... 需要加入对应的查询Dao
                spuEs.setFspuchildrenids(new ArrayList<>());
                //查询sku全字段
                List<EsCommodityDTO> skuEsDTOs = skuDao.getSkusBySpuId(spuEs, spuId);
                for (EsCommodityDTO skuEs : skuEsDTOs) {
                    //todo 这里后续加入children表... 需要加入对应的查询Dao，暂时只加入packinfo
                    commonStrategy.initAllArea(skuEs, false, true);

                    packInfoDao.getPackInfosBySkuId(skuEs, spuId, skuEs.getFskuid());
                    resultEsList.add(skuEs);

                    List<EsCommodityDTO> areaEs = skuAreaDao.getSkuAreasBySkuId(skuEs, spuId, skuEs.getFskuid());
                    resultEsList.addAll(areaEs);
                }
                commonStrategy.initAllArea(spuEs, true, true);
                resultEsList.add(spuEs);

            }
            //设置Key
            for (EsCommodityDTO resultEs : resultEsList) {
                setESKey(resultEs);
            }
            pushToEs(resultEsList);

            startIndex += massPerLength;
        }
        logger.info("ScheduledExecutor执行结束，共推送[{}]条数据", printCnt);

    }

    private EsCommodityDTO setESKey(EsCommodityDTO esDTO) {
        esDTO.setEagleType("upsert");
        // ES主键校验
        if (esDTO.getFspuid() == null || "".equals(esDTO.getFspuid())) {
            logger.warn("Fspuid:{} invalid.", esDTO.getFspuid());
            return null;
        }
        if (esDTO.getFskuid() == null || esDTO.getFskuid() < -1) {
            logger.warn("Fskuid:{} invalid.", esDTO.getFskuid());
            return null;
        }
        if (esDTO.getFentityid() == null || esDTO.getFentityid() < -1) {
            logger.warn("Fentityid:{} invalid.", esDTO.getFentityid());
            return null;
        }

        esDTO.setEagleTenantId(String.valueOf(esDTO.getFplatformid()));
        esDTO.setPkey(esDTO.getFspuid() + "_" + esDTO.getFskuid() + "_" + esDTO.getFentityid());
        return esDTO;
    }

    private void pushToEs(List<EsCommodityDTO> gEsBoList) {
        if (gEsBoList.size() > 0) {
            Iterator it = gEsBoList.iterator();
            while (it.hasNext()) {
                EsCommodityDTO esBo = (EsCommodityDTO) it.next();
                // 发送给Es
                PerformanceUtil performanceUtil = new PerformanceUtil();
                int ret = TMQMessageUtil.SendTMQ(esBo);
                logger.debug("TMQMessageUtil耗时：[{}]", performanceUtil.PERFORM_TIME());
                if (ret != 0) {
                    logger.error("push es failed. operator[{ScheduledExecutor}] spu[{}] sku[{}] entity[{}] code[{}], info:",
                            esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), ret, esBo.toString());
                } else {
                    // key log
                    logger.debug("push es success. operator[{ScheduledExecutor}] spu[{}] sku[{}] entity[{}]",
                            esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid());
                }
                // 日志标识
                if (printCnt.get() % 200 == 0) {
                    logger.info("push es success. >>>printCnt=[{}] eventType=[{ScheduledExecutor}] spuid=[{}] skuid=[{}] entityid=[{}] {}", printCnt, esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), esBo.toString());
                }
                if (printCnt.get() >= 90000000000L) {
                    printCnt.getAndSet(0);
                }
                printCnt.getAndIncrement();
            }
        }
    }

//    public static void main(String[] args) {
//        spuIds.add("1");
//        spuIds.add("2");
//        spuIds.add("3");
//        spuIds.add("4");
//        spuIds.add("5");
//        spuIds.add("6");
//        spuIds.add("7");
//        spuIds.add("8");
//        spuIds.add("9");
//
//        int massPerLength = 2;
//        int spuIdLength = spuIds.size();
//        BigDecimal a = new BigDecimal(massPerLength);
//        BigDecimal b = new BigDecimal(spuIdLength);
//        System.out.println(b.divide(a));
//        long times = b.divide(a).setScale( 0, BigDecimal.ROUND_UP ).longValue(); // 向上取整
//        int startIndex = 0;
//        for (int i = 0; i < times; i++) {
//            System.out.println("第" + i + "段开始");
//            //最后一次
//            if (i == times - 1) {
//                massPerLength = spuIdLength - i * massPerLength;
//            }
//            List<String> ss = spuIds.subList(startIndex, startIndex + massPerLength);
//            for (String s : ss) {
//                System.out.println(s);
//            }
//            startIndex += massPerLength;
//        }
//    }


}