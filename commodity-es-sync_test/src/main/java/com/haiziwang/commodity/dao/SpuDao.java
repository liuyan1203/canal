package com.haiziwang.commodity.dao;

import com.haiziwang.commodity.mapper.ConversionSpuMapper;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSpuPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.EntityTool;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class SpuDao {
    private static final Logger logger = LoggerFactory.getLogger(SpuDao.class);
    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    public EsCommodityDTO getSpu(EsCommodityDTO esCommodityDTO, String spuId) {
        Integer index = TableUtil.getTableIndex(spuId);
        ConversionSpuMapper spuMapper = context.getBean(ConversionSpuMapper.class);
        PerformanceUtil performanceUtil = new PerformanceUtil();
        ConversionSpuPO spuPO;
        try {
            spuPO = spuMapper.selectBySpuId(index, spuId);
            logger.debug("SpuDao查询spu耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("SpuDao getSpu查询Spu异常，spuId[{}] ex[{}]", spuId, ex.getMessage());
            return esCommodityDTO;
        }
        PerformanceUtil invokePer = new PerformanceUtil();
        EntityTool.cpySamePropertyVale(spuPO, esCommodityDTO);
        //处理特殊字段
        CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
        commonStrategy.specialHandler(esCommodityDTO, "Fbrandid", spuPO.getFbrandid());
        commonStrategy.specialHandler(esCommodityDTO, "Ferpbrandid", spuPO.getFerpbrandid());
        commonStrategy.specialHandler(esCommodityDTO, "Fcategoryid", spuPO.getFcategoryid());
        commonStrategy.specialHandler(esCommodityDTO, "Ferppubnavid", spuPO.getFerppubnavid());
        commonStrategy.specialHandler(esCommodityDTO, "Fspuproperty", spuPO.getFspuproperty());
        //特殊处理Date字段
        commonStrategy.handlerDateTime(esCommodityDTO, "Fspuaddtime", spuPO.getFspuaddtime());
        commonStrategy.handlerDateTime(esCommodityDTO, "Fspulastupdatetime", spuPO.getFspulastupdatetime());
        logger.debug("SpuDao反射耗时：[{}]", invokePer.PERFORM_TIME());
        return esCommodityDTO;
    }

}