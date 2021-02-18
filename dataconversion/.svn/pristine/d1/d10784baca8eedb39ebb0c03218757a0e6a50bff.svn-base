package com.haiziwang.commodity.service.impl;

import com.haiziwang.commodity.mapper.ConversionSkuMapper;
import com.haiziwang.commodity.mapper.HzwSkuMapper;
import com.haiziwang.commodity.mapper.HzwSpuMapper;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import com.haiziwang.commodity.service.HzwSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HzwSkuServiceImpl implements HzwSkuService {

    @Autowired
    private HzwSkuMapper skuMapper;

    @Autowired
    private ConversionSkuMapper conversionSkuMapper;

    @Override
    public HzwSkuPO getSkuById(Long id) {
        HzwSkuPO skuPO = skuMapper.getSkuById(id);
        return skuPO;
    }

    @Override
    public int insertConversionSku(int  index, ConversionSkuPO sku) {
        return conversionSkuMapper.insertSelective(index, sku);
    }



}