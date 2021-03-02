package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.model.po.HzwSkuPackInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@DataSourceTypeAnnotation
@Repository
public interface HzwSkuPackInfoMapper {

    HzwSkuPackInfoPO selectByPrimaryKey(Long fskupackid);

    List<HzwSkuPackInfoPO> selectBySKuId(Long skuId);

    List<HzwSkuPackInfoPO> selectAll();

}