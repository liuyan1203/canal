package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.model.po.ConversionSkuPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@DataSourceTypeAnnotation
@Repository
public interface ConversionSkuMapper {

    int insertSelective(@Param("index") Integer index, @Param("record") ConversionSkuPO record);

    int updateByPrimaryKeySelective(@Param("index") Integer index, @Param("record") ConversionSkuPO record);

    ConversionSkuPO selectBySkuId(@Param("index") Integer index, @Param("Fskuid") Long skuId);

    List<ConversionSkuPO> selectBySpuId(@Param("index") Integer index, @Param("Fspuid") String spuId);

    List<ConversionSkuPO> selectSkuIdsBySpuId(@Param("index") Integer index, @Param("Fspuid") String spuId);
}
