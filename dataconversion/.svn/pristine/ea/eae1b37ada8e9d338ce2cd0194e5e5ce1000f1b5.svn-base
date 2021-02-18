package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.model.po.ConversionSkuAreaPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DataSourceTypeAnnotation(value = Constant.DATASOURCE_CONVERSION)
public interface ConversionSkuAreaMapper {

    int deleteByPrimaryKey(@Param("index") Integer index, @Param("fid") Long fid);

    int insertSelective(@Param("index") Integer index, @Param("record") ConversionSkuAreaPO record);

    int updateByPrimaryKeySelective(@Param("index") Integer index, @Param("record") ConversionSkuAreaPO record);

    ConversionSkuAreaPO selectBySpuIdAndSkuId(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid, @Param("Fentityid") Integer Fentityid);

}