package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.model.po.HzwSkuAreaPO;
import com.haiziwang.commodity.model.po.HzwSkuPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@DataSourceTypeAnnotation
@Repository
public interface HzwSkuAreaMapper {

    HzwSkuAreaPO selectByPrimaryKey(Long fskuareaid);

    List<HzwSkuAreaPO> selectBySkuid(Long fskuid);

    List<HzwSkuAreaPO> selectAll();

}