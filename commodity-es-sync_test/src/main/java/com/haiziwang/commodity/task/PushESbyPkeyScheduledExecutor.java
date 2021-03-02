package com.haiziwang.commodity.task;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.ConversionSpuMapper;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSpuPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TMQMessageUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ES -> spu：主要用来解决个别spu数据缺失以及不一致的问题（例如获取名牌超时）
 * 文件中配置（spuId）
 */
@Component
public class PushESbyPkeyScheduledExecutor {
    //读取配置文件
    protected final static Logger logger = LoggerFactory.getLogger(PushESbyPkeyScheduledExecutor.class);

    protected static ApplicationContext context = SpringUtil.getApplicationContext();

    private static AtomicLong printCnt = new AtomicLong(0);

    private Set<String> pkeys = new HashSet<>();

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
            logger.info("ES -> spu更新定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
            inputStream = PushESbyPkeyScheduledExecutor.class.getClassLoader().getResourceAsStream("file/pkey.txt");
            readFileByLinesV2(inputStream);
        } else {
            return;
        }
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
                String pkey = parseLine(tempString);
                if (StringUtils.isNotEmpty(pkey)) {
                    pkeys.add(pkey);
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
        ConversionSpuMapper spuMapper = context.getBean(ConversionSpuMapper.class);
        CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
        for (String pkey : pkeys) {
            if (StringUtils.isNotEmpty(pkey)) {
                String spuId = pkey.substring(0, 12);
                EsCommodityDTO esCommodityDTO = new EsCommodityDTO();
                esCommodityDTO.setEagleType("update");
                esCommodityDTO.setPkey(pkey);

                Integer index = TableUtil.getTableIndex(spuId);
                ConversionSpuPO spuPO = spuMapper.selectBySpuId(index, spuId);
                //处理类目
                commonStrategy.specialHandler(esCommodityDTO, "Fcategoryid", spuPO.getFcategoryid());
                commonStrategy.specialHandler(esCommodityDTO, "Ferppubnavid", spuPO.getFerppubnavid());

                pushToEs(esCommodityDTO);

            }
        }
        logger.info("PushESbyPkeyScheduledExecutor执行结束，共推送[{}]条数据", printCnt);
    }

    private void pushToEs(EsCommodityDTO esBo) {
        if (esBo != null && StringUtils.isNotEmpty(esBo.getPkey())) {
            // 发送给Es
            PerformanceUtil performanceUtil = new PerformanceUtil();
            int ret = TMQMessageUtil.SendTMQ(esBo);
            logger.debug("TMQMessageUtil耗时：[{}]", performanceUtil.PERFORM_TIME());
            if (ret != 0) {
                logger.error("push es failed. operator[{SpuScheduledExecutor}] spu[{}] sku[{}] entity[{}] code[{}], info:",
                        esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), ret, esBo.toString());
            } else {
                // key log
                logger.debug("push es success. operator[{SpuScheduledExecutor}] spu[{}] sku[{}] entity[{}]",
                        esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid());
            }
            // 日志标识
            if (printCnt.get() % 200 == 0) {
                logger.info("push es success. >>>printCnt=[{}] eventType=[{SpuScheduledExecutor}] spuid=[{}] skuid=[{}] entityid=[{}] {}", printCnt, esBo.getFspuid(), esBo.getFskuid(), esBo.getFentityid(), esBo.toString());
            }

            if (printCnt.get() >= 90000000000L) {
                printCnt.getAndSet(0);
            }
            printCnt.getAndIncrement();
        }
    }

}