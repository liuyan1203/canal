package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@DataSourceTypeAnnotation
@Repository
public interface HzwSkuMapper {

    // @Select("select * from t_sku where Fskuid = {#id}")
    HzwSkuPO getSkuById(Long Fskuid);

    HzwSkuPO getSimpleSkuById(Long Fskuid);

    List<HzwSkuPO> getAllSku();

    HzwSkuPO getSpuIdById(Long Fskuid);
}
