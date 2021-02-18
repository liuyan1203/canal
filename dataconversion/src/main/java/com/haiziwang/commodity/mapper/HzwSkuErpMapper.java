package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.model.po.HzwSkuErpPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@DataSourceTypeAnnotation
@Repository
public interface HzwSkuErpMapper {

    // @Select("select * from t_sku where Fskuid = {#id}")
    HzwSkuErpPO getSkuById(Long Fskuid);

    List<HzwSkuErpPO> getSkuTitles();
}
