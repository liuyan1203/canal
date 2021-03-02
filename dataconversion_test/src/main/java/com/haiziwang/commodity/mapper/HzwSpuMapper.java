package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.model.po.HzwSpuPO;
import org.springframework.stereotype.Repository;

@DataSourceTypeAnnotation
@Repository
public interface HzwSpuMapper {

    HzwSpuPO getSpuById(Long Fspuid);
}
