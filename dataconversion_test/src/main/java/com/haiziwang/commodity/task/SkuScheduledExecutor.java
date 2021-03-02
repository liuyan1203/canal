package com.haiziwang.commodity.task;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.ConversionSkuMapper;
import com.haiziwang.commodity.mapper.HzwSkuMapper;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import com.haiziwang.commodity.utils.SpringUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 主要用来解决个别数据缺失以及不一直的问题(主要是sku)，只考虑中间表数据已存在的情况。
 * 文件中配置（spuId,skuId）
 */
@Component
public class SkuScheduledExecutor {

    protected final static Logger logger = LoggerFactory.getLogger(SkuScheduledExecutor.class);

    protected static ApplicationContext context = SpringUtil.getApplicationContext();

    private List<String> skuIds = new ArrayList<>();

    //是否执行过标识
    private static AtomicBoolean execFlag = new AtomicBoolean(false);

    public void executeJob() {
        //防止重复执行
        synchronized (SkuScheduledExecutor.class) {
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
            logger.info("SkuScheduledExecutor定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
            skuIds.clear();
            inputStream = SkuScheduledExecutor.class.getClassLoader().getResourceAsStream("file/sku.txt");
        } else {
            return;
        }
        readFileByLinesV2(inputStream);
        parsePushEs();
        logger.info("SkuScheduledExecutor定时任务执行结束ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
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
                logger.info("line " + line + ": " + tempString);
                //内容处理逻辑、
                String spuId = parseLine(tempString);
                if (StringUtils.isNotEmpty(spuId)) {
                    skuIds.add(spuId);
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
        for (String spuIdAndSkuId : skuIds) {
            if (StringUtils.isNotEmpty(spuIdAndSkuId)) {
                String[] arr = spuIdAndSkuId.split(",");
                String spuId = arr[0];
                String skuIdStr = arr[1];
                Long skuId = null;
                if (StringUtils.isNotEmpty(skuIdStr)) {
                    skuId = Long.valueOf(skuIdStr);
                }
                if (skuId != null && StringUtils.isNotEmpty(spuId)) {
                    //查询sku信息
                    Integer index = TableUtil.getTableIndex(spuId);
                    // 查询中间库是否存在sku
                    ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
                    ConversionSkuPO existConversionSku = conversionSkuMapper.selectBySkuId(index, skuId);
                    // 查询源库是否存在sku
                    HzwSkuMapper hzwSkuMapper = context.getBean(HzwSkuMapper.class);
                    HzwSkuPO existHzwSku = hzwSkuMapper.getSkuById(skuId);
                    if (existConversionSku != null && existHzwSku != null) {
                        ConversionSkuPO conversionSkuPO = new ConversionSkuPO();
//                    conversionSkuPO.setFskuextcode(existHzwSku.getFpopskucode());
                        conversionSkuPO.setFskulocalcode(existHzwSku.getFskulocalcode());
//                    conversionSkuPO.setFcategoryattr(existHzwSku.getFskucategoryattr());
//                    conversionSkuPO.setFskusaleattr(existHzwSku.getFskusaleattr());
//                    conversionSkuPO.setFskukeyattr(existHzwSku.getFskukeyattr());
//                    conversionSkuPO.setFskupacklist(existHzwSku.getFskupacklist());
//                    conversionSkuPO.setFskuunitcost(existHzwSku.getFskuunitcost());
//                    conversionSkuPO.setFskuerpceilingprice(existHzwSku.getFskuceilprice());
//                    conversionSkuPO.setFskuerpfloorprice(existHzwSku.getFskufloorprice());
//                    conversionSkuPO.setFskuunit(existHzwSku.getFskuunit());
//                    conversionSkuPO.setFskustockexpiretime(existHzwSku.getFskustockexpiretime());
//                    conversionSkuPO.setFskuaddtime(existHzwSku.getFskuaddtime());
//                    conversionSkuPO.setFskulastupdatetime(existHzwSku.getFskulastupdatetime());
//                    conversionSkuPO.setFskulastupstatetime(existHzwSku.getFskulastuptime());
//                    conversionSkuPO.setFskulastdowntime(existHzwSku.getFskulastdowntime());
                        //更新sku相关字段
                        conversionSkuPO.setFid(existConversionSku.getFid());
                        conversionSkuMapper.updateByPrimaryKeySelective(index, conversionSkuPO);
                        logger.info("spuId[{}] skuId[{}] 更新成功", spuId, skuId);
                    }
                }
            }
        }

    }

}