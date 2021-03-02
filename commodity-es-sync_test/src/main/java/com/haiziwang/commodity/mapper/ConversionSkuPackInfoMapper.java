package com.haiziwang.commodity.mapper;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.model.po.ConversionSkuPackInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DataSourceTypeAnnotation
public interface ConversionSkuPackInfoMapper {

    int deleteByPrimaryKey(Long fid);

    int insertSelective(@Param("index") Integer index, @Param("record") ConversionSkuPackInfoPO record);

    ConversionSkuPackInfoPO selectByPrimaryKey(@Param("index") Integer index, @Param("fid") Long fid);

    int updateByPrimaryKeySelective(@Param("index") Integer index, @Param("record") ConversionSkuPackInfoPO record);

    ConversionSkuPackInfoPO selectBySpuIdAndSkuId(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid, @Param("Fpackindex") Integer Fpackindex);

    List<ConversionSkuPackInfoPO> selectListBySkuId(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid);

    void deleteByFskuid(@Param("index") Integer index, @Param("Fspuid") String Fspuid, @Param("Fskuid") Long Fskuid, @Param("Fpackindex") Integer Fpackindex);


}