package com.haiziwang.commodity.dao;

import com.google.common.collect.Lists;
import com.haiziwang.commodity.mapper.ConversionSkuAreaMapper;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.po.ConversionSkuAreaPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.EntityTool;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class SkuAreaDao {
    private static final Logger logger = LoggerFactory.getLogger(SkuAreaDao.class);
    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    public List<EsCommodityDTO> getSkuAreasBySkuId(EsCommodityDTO esCommodityDTO, String spuId, Long skuId) {

        int index = TableUtil.getTableAreaIndex(spuId);
        List<EsCommodityDTO> esCommodityDTOList = Lists.newArrayList();
        ConversionSkuAreaMapper skuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);
        PerformanceUtil performanceUtil = new PerformanceUtil();
        List<ConversionSkuAreaPO> skuAreaPOs;
        try {
            skuAreaPOs = skuAreaMapper.selectBySpuIdAndSkuId(index, spuId, skuId);
            logger.debug("SkuAreaDao.getSkuAreasBySkuId查询area耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("SkuAreaDao getSkuAreasBySkuId查询SkuArea异常，spuId[{}] skuId[{}] ex[{}]", spuId, skuId, ex.getMessage());
            return esCommodityDTOList;
        }
        PerformanceUtil invokePer= new PerformanceUtil();
        for (ConversionSkuAreaPO areaPO : skuAreaPOs) {
            EsCommodityDTO resultDTO = new EsCommodityDTO();
            EntityTool.cpySamePropertyVale(esCommodityDTO, resultDTO);
            EntityTool.cpySamePropertyVale(areaPO, resultDTO);
            //字段特殊处理
            CommonStrategyImpl commonStrategy = new CommonStrategyImpl();
            commonStrategy.specialHandler(resultDTO, "Fskuareaproperty", areaPO.getFskuareaproperty());

            commonStrategy.handlerDateTime(resultDTO, "Fskuareaaddtime", areaPO.getFskuareaaddtime());
            commonStrategy.handlerDateTime(resultDTO, "Fskuarealastupdatetime", areaPO.getFskuarealastupdatetime());
            commonStrategy.handlerDateTime(resultDTO, "Fskuareafirstpublishtime", areaPO.getFskuareafirstpublishtime());
            esCommodityDTOList.add(resultDTO);
        }
        logger.debug("SkuAreaDao.getSkuAreasBySkuId反射耗时：[{}]", invokePer.PERFORM_TIME());
        return esCommodityDTOList;
    }

    public List<EsCommodityDTO> getEntityIdsBySkuId(EsCommodityDTO esCommodityDTO, String spuId, Long skuId) {

        int index = TableUtil.getTableAreaIndex(spuId);
        List<EsCommodityDTO> esCommodityDTOList = Lists.newArrayList();
        ConversionSkuAreaMapper skuAreaMapper = context.getBean(ConversionSkuAreaMapper.class);
        PerformanceUtil performanceUtil = new PerformanceUtil();
        List<ConversionSkuAreaPO> skuAreaPOS = skuAreaMapper.selectEntityIdBySkuId(index, spuId, skuId);
        logger.debug("SkuAreaDao.getSkuAreasBySkuId查询area耗时：[{}]", performanceUtil.PERFORM_TIME());
        PerformanceUtil invokePer= new PerformanceUtil();
        for (ConversionSkuAreaPO areaPO : skuAreaPOS) {
            EsCommodityDTO resultDTO = new EsCommodityDTO();
            EntityTool.cpySamePropertyVale(esCommodityDTO, resultDTO);
            resultDTO.setFentityid(areaPO.getFentityid());
            esCommodityDTOList.add(resultDTO);
        }
        logger.debug("SkuAreaDao.getEntityIdsBySkuId反射耗时：[{}]", invokePer.PERFORM_TIME());
        return esCommodityDTOList;
    }
}