package com.haiziwang.commodity.dao;

import com.google.common.collect.Lists;
import com.haiziwang.commodity.mapper.ConversionSkuMapper;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.EntityTool;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class SkuDao {
    private static final Logger logger = LoggerFactory.getLogger(SkuAreaDao.class);
    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    public EsCommodityDTO getSku(EsCommodityDTO esCommodityDTO, String spuId, Long skuId) {
        Integer index = TableUtil.getTableIndex(spuId);
        ConversionSkuMapper skuMapper = context.getBean(ConversionSkuMapper.class);
        PerformanceUtil performanceUtil = new PerformanceUtil();
        ConversionSkuPO skuPO = null;
        try {
            skuPO = skuMapper.selectBySkuId(index, skuId);
            logger.debug("SkuDao.getSku查询sku耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("SkuDao getSku查询Sku异常，spuId[{}] skuId[{}] ex[{}]", spuId, skuId, ex.getMessage());
            return esCommodityDTO;
        }
        PerformanceUtil invokePer= new PerformanceUtil();
        EntityTool.cpySamePropertyVale(skuPO, esCommodityDTO);
        //特殊处理字段
        CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
        commonStrategy.specialHandler(esCommodityDTO, "Fskuproperty", skuPO.getFskuproperty());
        //特殊处理Date字段
        commonStrategy.handlerDateTime(esCommodityDTO, "Fskuaddtime", skuPO.getFskuaddtime());
        commonStrategy.handlerDateTime(esCommodityDTO, "Fskulastupdatetime", skuPO.getFskulastupdatetime());
        logger.debug("SkuDao.getSku反射耗时：[{}]", invokePer.PERFORM_TIME());
        return esCommodityDTO;
    }

    public List<EsCommodityDTO> getSkuIdsBySpuId(EsCommodityDTO esCommodityDTO, String spuId) {
        PerformanceUtil performanceUtil = new PerformanceUtil();
        List<EsCommodityDTO> resultList = Lists.newArrayList();
        Integer index = TableUtil.getTableIndex(spuId);
        ConversionSkuMapper skuMapper = context.getBean(ConversionSkuMapper.class);
        List<ConversionSkuPO> skuPOs;
        try {
            skuPOs = skuMapper.selectSkuIdsBySpuId(index, spuId);
            logger.debug("SkuDao.getSkuIdsBySpuId查询sku耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("SkuDao getSkuIdsBySpuId查询Sku异常，spuId[{}] ex[{}]", spuId, ex.getMessage());
            return resultList;
        }
        PerformanceUtil invokePer= new PerformanceUtil();
        for (ConversionSkuPO skuPO : skuPOs) {
            EsCommodityDTO resultDTO = new EsCommodityDTO();
            EntityTool.cpySamePropertyVale(esCommodityDTO, resultDTO);
            resultDTO.setFskuid(skuPO.getFskuid());
            resultList.add(resultDTO);
        }
        logger.debug("SkuDao.getSkuIdsBySpuId反射耗时：[{}]", invokePer.PERFORM_TIME());

        return resultList;
    }

    public List<EsCommodityDTO> getSkusBySpuId(EsCommodityDTO esCommodityDTO, String spuId) {
        PerformanceUtil performanceUtil = new PerformanceUtil();
        List<EsCommodityDTO> resultList = Lists.newArrayList();
        Integer index = TableUtil.getTableIndex(spuId);
        ConversionSkuMapper skuMapper = context.getBean(ConversionSkuMapper.class);
        List<ConversionSkuPO> skuPOs;
        try {
            skuPOs = skuMapper.selectBySpuId(index, spuId);
            logger.debug("SkuDao.getSkusBySpuId查询sku耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("SkuDao getSkusBySpuId查询Sku异常，spuId[{}] ex[{}]", spuId, ex.getMessage());
            return resultList;
        }
        PerformanceUtil invokePer= new PerformanceUtil();
        for (ConversionSkuPO skuPO : skuPOs) {
            EsCommodityDTO resultDTO = new EsCommodityDTO();
            EntityTool.cpySamePropertyVale(esCommodityDTO, resultDTO);
            EntityTool.cpySamePropertyVale(skuPO, resultDTO);
            //特殊处理字段
            CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
            commonStrategy.specialHandler(resultDTO, "Fskuproperty", skuPO.getFskuproperty());
            //特殊处理Date字段
            commonStrategy.handlerDateTime(resultDTO, "Fskuaddtime", skuPO.getFskuaddtime());
            commonStrategy.handlerDateTime(resultDTO, "Fskulastupdatetime", skuPO.getFskulastupdatetime());
            resultList.add(resultDTO);
        }
        logger.debug("SkuDao.getSkusBySpuId反射耗时：[{}]", invokePer.PERFORM_TIME());

        return resultList;
    }

}