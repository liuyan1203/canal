package com.haiziwang.commodity.dao;

import com.google.common.collect.Lists;
import com.haiziwang.commodity.mapper.ConversionSkuMapper;
import com.haiziwang.commodity.mapper.ConversionSkuPackInfoMapper;
import com.haiziwang.commodity.model.dto.EsCommodityDTO;
import com.haiziwang.commodity.model.dto.PackInfoDTO;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.model.po.ConversionSkuPackInfoPO;
import com.haiziwang.commodity.strategy.table.CommonStrategyImpl;
import com.haiziwang.commodity.utils.EntityTool;
import com.haiziwang.commodity.utils.PerformanceUtil;
import com.haiziwang.commodity.utils.SpringUtil;
import com.haiziwang.commodity.utils.TableUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class PackInfoDao {
    private static final Logger logger = LoggerFactory.getLogger(PackInfoDao.class);
    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    public EsCommodityDTO getPackInfosBySkuId(EsCommodityDTO esCommodityDTO, String spuId, Long skuId) {

        Integer index = TableUtil.getTableIndex(spuId);
        ConversionSkuPackInfoMapper packInfoMapper = context.getBean(ConversionSkuPackInfoMapper.class);
        PerformanceUtil performanceUtil = new PerformanceUtil();
        List<ConversionSkuPackInfoPO> packInfoPOs;
        try {
            packInfoPOs = packInfoMapper.selectListBySkuId(index, spuId, skuId);
            logger.debug("PackInfoDao.getPackInfosBySkuId查询packinfo耗时：[{}]", performanceUtil.PERFORM_TIME());
        } catch (Exception ex) {
            logger.error("PackInfoDao getPackInfosBySkuId查询PackInfo异常，spuId[{}] skuId[{}] ex[{}]", spuId, skuId, ex.getMessage());
            return esCommodityDTO;
        }
        PerformanceUtil invokePer= new PerformanceUtil();
        List<PackInfoDTO> packInfoDTOs = Lists.newArrayList();
        for (ConversionSkuPackInfoPO packInfoPO : packInfoPOs) {
            PackInfoDTO resultDTO = new PackInfoDTO();
            EntityTool.cpySamePropertyVale(packInfoPO, resultDTO);
            packInfoDTOs.add(resultDTO);
        }
        esCommodityDTO.setFpackinfolist(packInfoDTOs);
        logger.debug("PackInfoDao.getPackInfosBySkuId反射耗时：[{}]", invokePer.PERFORM_TIME());
        return esCommodityDTO;
    }

}