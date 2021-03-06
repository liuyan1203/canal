package com.haiziwang.commodity.task;

import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.mapper.ConversionSpuMapper;
import com.haiziwang.commodity.mapper.HzwSkuErpMapper;
import com.haiziwang.commodity.model.po.ConversionSpuPO;
import com.haiziwang.commodity.model.po.HzwSkuErpPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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
public class SkuErpScheduledExecutor {

    protected final static Logger logger = LoggerFactory.getLogger(SkuErpScheduledExecutor.class);

    protected static ApplicationContext context = SpringUtil.getApplicationContext();

    private List<String> skuIds = new ArrayList<>();

    private int count = 0;

    //是否执行过标识
    private static AtomicBoolean execFlag = new AtomicBoolean(false);

    public void executeJob() {
        //防止重复执行
        synchronized (SkuErpScheduledExecutor.class) {
            if (execFlag.get() == false) {
                execFlag.set(true);
            } else {
                logger.info("重复执行了..");
                return;
            }
        }
        //是否开启定时任务
        if (1 == Constant.OPEN_SCHEDULE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("SkuErpScheduledExecutor定时任务开始执行ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
            skuIds.clear();
            count = 0;
            //获取所有spuid=0的sku_erp.title(27w)
            HzwSkuErpMapper hzwSkuErpMapper = context.getBean(HzwSkuErpMapper.class);
            ConversionSpuMapper conversionSpuMapper = context.getBean(ConversionSpuMapper.class);
            try {
                List<HzwSkuErpPO> skuErps = hzwSkuErpMapper.getSkuTitles();
                for (HzwSkuErpPO erpPO : skuErps) {
                    Long skuId = erpPO.getFskuid();
                    String spuTitle = erpPO.getFskutitle();
                    String spuId = CommonStrategyImpl.createSpuId(skuId, Constant.NEW_SPU_ID_PREFIX);
                    int index = TableUtil.getTableIndex(spuId);

                    ConversionSpuPO spuPO = conversionSpuMapper.selectBySpuId(index, spuId, null);
                    if (spuPO != null) {
                        spuPO.setFsputitle(spuTitle);
                        conversionSpuMapper.updateByPrimaryKeySelective(index, spuPO);
                        count++;
                        if (count % 200 == 0) {
                            try {
                                logger.info("count[{}] spuId[{}] skuId[{}] skuTitle[{}] 更新title成功", count, spuId, skuId, spuTitle);
                                Thread.sleep(10000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("更新title错误 error[{}]", e.getMessage());
            }
            logger.info("SkuErpScheduledExecutor定时任务执行结束ThreadName[{}] DateTime[{}] ", Thread.currentThread().getName(), sdf.format(new Date()));
        }
    }
}