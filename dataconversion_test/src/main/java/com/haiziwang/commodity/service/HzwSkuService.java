package com.haiziwang.commodity.service;

import com.haiziwang.commodity.model.po.ConversionSkuPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;

public interface HzwSkuService {

    HzwSkuPO getSkuById(Long Fskuid);

    int insertConversionSku(int  index, ConversionSkuPO sku);

}
