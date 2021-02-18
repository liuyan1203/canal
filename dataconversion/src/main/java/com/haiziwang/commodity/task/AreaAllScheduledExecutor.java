package com.haiziwang.commodity.task;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.*;
import com.haiziwang.commodity.model.po.*;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 主要用来解决个别数据缺失以及不一直的问题(主要是sku)，只考虑中间表数据已存在的情况。
 * 文件中配置（skuId）
 */
@Component
public class AreaAllScheduledExecutor {

    protected final static Logger logger = LoggerFactory.getLogger(AreaAllScheduledExecutor.class);

    protected static ApplicationContext context = SpringUtil.getApplicationContext();

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
            logger.info("AreaAllScheduledExecutor定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
            //全表扫描
            if (1 == Constant.SCHEDULE_FULL_MODE) {
                handlerAllArea();
            } else {

            }
        } else {
            return;
        }

        logger.info("AreaAllScheduledExecutor定时任务执行结束ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
    }

    private void handlerAllArea() {
//        PerformanceUtil per = new PerformanceUtil();
        int count = 0;
        HzwSkuMapper hzwSkuMapper = context.getBean(HzwSkuMapper.class);
        HzwSkuAreaMapper hzwSkuAreaMapper = context.getBean(HzwSkuAreaMapper.class);
        ConversionSkuMapper conversionSkuMapper = context.getBean(ConversionSkuMapper.class);
        ConversionSkuAreaMapper conversionSkuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);

        //遍历所有的area
        List<HzwSkuAreaPO> areaPOS = hzwSkuAreaMapper.selectAll();
        for (HzwSkuAreaPO area : areaPOS) {
            Long skuId = area.getFskuid();
            Integer entityId = area.getFentityid();
            HzwSkuPO skuPO = hzwSkuMapper.getSkuById(skuId);
            if (skuPO != null) {
                String spuId;
                if (skuPO.getFspuid() == 0) {
                    spuId = CommonStrategyImpl.createSpuId(skuPO.getFskuid(), Constant.NEW_SPU_ID_PREFIX);
                } else {
                    spuId = CommonStrategyImpl.createSpuId(skuPO.getFspuid(), Constant.SPU_ID_PREFIX);
                }
                int skuIndex = TableUtil.getTableIndex(spuId);
                int areaIndex = TableUtil.getTableAreaIndex(spuId);

                try {
                    ConversionSkuAreaPO exitAreaPO = conversionSkuAreaMapper.selectBySpuIdAndSkuId(areaIndex, spuId, skuId, entityId);
                    if (exitAreaPO == null) {
                        count++;
                        if (count % 200 == 0) {
                            logger.info("处理area信息 count[{}]", count);
                        }
                        ConversionSkuAreaPO conversionSkuAreaPO = new ConversionSkuAreaPO();
                        conversionSkuAreaPO.setFplatformid(1);
                        conversionSkuAreaPO.setFspuid(spuId);
                        conversionSkuAreaPO.setFskuid(skuId);
                        conversionSkuAreaPO.setFentityid(entityId);
                        conversionSkuAreaPO.setFchannelid(area.getFchannelid());
                        conversionSkuAreaPO.setFstoreid(area.getFstoreid());
                        conversionSkuAreaPO.setFworkstatecode(area.getFworkstatecode());
                        conversionSkuAreaPO.setFcirculationmodecode(area.getFcirculationmodecode());
                        conversionSkuAreaPO.setFskuareapostprice(area.getFskuareapostprice());
                        conversionSkuAreaPO.setFskuareaprice(area.getFskuareaprice());
                        conversionSkuAreaPO.setFskuareapreprice(area.getFskuareapreprice());
                        conversionSkuAreaPO.setFsaleslabelid(area.getFsaleslabelid());
                        conversionSkuAreaPO = handlerSpecialColumn(conversionSkuAreaPO, area);
                        conversionSkuAreaPO.setFskuareaproperty(area.getFskuareaproperty());
                        conversionSkuAreaPO.setFskuareabuyer(area.getFskuareabuyer());
                        conversionSkuAreaPO.setFskuareaaddtime(area.getFskuareaaddtime());
                        conversionSkuAreaPO.setFskuarealastupdatetime(area.getFskuarealastupdatetime());
                        conversionSkuAreaPO.setFskuareafirstpublishtime(area.getFskuareafirstpublishtime());
                        //赋值给sku
                        if (entityId == 8000 && area.getFchannelid() == 1) {
                            ConversionSkuPO conversionSkuPO = conversionSkuMapper.selectBySkuId(skuIndex, skuId);
                            if (conversionSkuPO != null) {
                                conversionSkuPO.setFskuminbuycount(area.getFskuareaminbuycount());
                                conversionSkuPO.setFskumaxbuycount(area.getFskuareamaxbuycount());
                                conversionSkuPO.setFskubuymultiple(area.getFskuareabuymultiple());
                                conversionSkuMapper.updateByPrimaryKeySelective(skuIndex, conversionSkuPO);
                            }
                        }
                        conversionSkuAreaMapper.insertSelective(areaIndex, conversionSkuAreaPO);
                    }
                } catch (Exception e) {
                    logger.info("area同步失败spuId[{}] skuId[{}] entityId[{}]", spuId, skuId, entityId);
                }
            }

        }

    }

    private ConversionSkuAreaPO handlerSpecialColumn(ConversionSkuAreaPO conversionSkuAreaPO, HzwSkuAreaPO hzwSkuAreaPO) {
        if (conversionSkuAreaPO != null && hzwSkuAreaPO != null && hzwSkuAreaPO.getFskuareaproperty() != null) {
            Long skuareaproperty = hzwSkuAreaPO.getFskuareaproperty();
            StringBuffer sb = new StringBuffer();
            for (int i = 63; i >= 0; i--) {
                long bitVal = new Double(Math.pow(2, i)).longValue();
                if ((skuareaproperty & bitVal) == bitVal) {
                    if (i == 0 || i == 1) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                } else {
                    sb.append("0");
                }
            }
            conversionSkuAreaPO.setFskuareaproperty(Long.parseLong(sb.toString(), 2));
        }

        return conversionSkuAreaPO;
    }

}