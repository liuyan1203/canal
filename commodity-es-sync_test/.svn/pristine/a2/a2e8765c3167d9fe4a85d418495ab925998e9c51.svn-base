package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.model.po.ConversionSkuAreaPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceTypeAnnotation
public interface ConversionSkuAreaMapper {

    int deleteByPrimaryKey(@Param("index") Integer index, @Param("fid") Long fid);

    int insertSelective(@Param("index") Integer index, @Param("record") ConversionSkuAreaPO record);

    int updateByPrimaryKeySelective(@Param("index") Integer index, @Param("record") ConversionSkuAreaPO record);

    List<ConversionSkuAreaPO> selectBySpuIdAndSkuId(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid);

    List<ConversionSkuAreaPO> selectEntityIdBySkuId(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid);

}