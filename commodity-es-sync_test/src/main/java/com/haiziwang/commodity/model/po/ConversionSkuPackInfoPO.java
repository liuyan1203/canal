package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class ConversionSkuPackInfoPO {
    private Long Fid;

    private Integer Fplatformid;

    private String Fspuid;

    private Long Fskuid;

    private Integer Fpackindex;

    @ColumnAnnotation
    private String Fbarcode;

    @ColumnAnnotation
    private Integer Fiswholepack;

    @ColumnAnnotation
    private String Fpackrate;

    @ColumnAnnotation
    private String Fmeasureunit;

    private Long Fskuweight;

    private Integer Fskunetweight;

    private Integer Fskuvolume;

    private Integer Fskusizex;

    private Integer Fskusizey;

    private Integer Fskusizez;

    private Date Faddtime;

    @ColumnAnnotation
    private Date Flastupdatetime;

}