package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class ConversionSkuPO {
    private Long Fid;
    private Integer Fplatformid;
    private String Fspuid;
    private Long Fskuid;
    @ColumnAnnotation
    private String Fskuextcode;
    @ColumnAnnotation
    private String Fskulocalcode;
    @ColumnAnnotation
    private String Fgoodsno;
    @ColumnAnnotation
    private Integer Fskustate;
    private String Fcategoryattr;
    @ColumnAnnotation
    private String Fskusaleattr;
    private String Fskukeyattr;
    private String Fskupacklist;
    @ColumnAnnotation
    private String Fskumainurl;
    private Integer Fskuminbuycount;
    private Integer Fskubuymultiple;
    private Integer Fskumaxbuycount;
    @ColumnAnnotation
    private Integer Fskuunitcost;
    @ColumnAnnotation
    private Integer Fskuerpreferprice;
    private Integer Fskuerppurchprice;
    private Integer Fskuerpceilingprice;
    private Integer Fskuerpfloorprice;
    private Integer Fgrossmargin;
    @ColumnAnnotation
    private Long Fskuproperty;
    @ColumnAnnotation
    private String Fskuunit;
    private String Fskulevel;
    private Date Fskustockexpiretime;
    @ColumnAnnotation
    private Date Fskuaddtime;
    @ColumnAnnotation
    private Date Fskulastupdatetime;
    private Date Fskulastupstatetime;
    private Date Fskulastdowntime;
    private Date Fskufirstpublishtime;

}