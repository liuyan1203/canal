package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class HzwSpuErpPO {
    private Long Fskuerpid;
    private Long Fspuid;
    private Date Fskuerpaddtime;
    private Date Fskuerplastupdatetime;
    private String Fbrandid;
    private Integer Fcategoryid;
    private String Fcooperatorid;
    private String Fskulocalcode;
    private String Fgoodsno;
    @ColumnAnnotation
    private String Fskutitle;
    private String Fskuproducingarea;
    private String Fskuspecmodel;
    private String Fbarcode;
    private String Fskuunit;
    private Integer Fskupackrate;
    private Long Fproperty;
    private Integer Fskuvatrate;
    private Integer Fskupurchtaxrate;
    private Integer Fskureferprice;
    private Integer Fskupurchprice;
    private Integer Fskuexchangepoint;
    private Integer Fskuceilingprice;
    private Integer Fskufloorprice;
    private Integer Fskudurability;
    private Integer Fdaysbefcheckin;
    private Integer Fisdecimalcontrol;
    private Integer Fiscategorycode;
    private Integer Fmesureproperty;
    @ColumnAnnotation
    private String Fremark;
    private String Fcategoryitemcode;
    private Integer Fskutype;
    private Integer Fskuvirtualtype;
    private Integer Fskuoperationmodel;
    private Integer Fmanagermode;
    private Integer Fgrossmargin;
    private String Flevel;
    private Integer Fskusizex;
    private Integer Fskusizey;
    private Integer Fskusizez;
    private Integer Fskunetweight;
    private Integer Fskuweight;
    private Integer Fspecimenmoney;
    private Integer Fspecimendays;
    private Integer Fsynerpflag;
    private Date Fsynerptime;
    @ColumnAnnotation
    private String Fcreateuser;
    private String Fseasonalcode;
    private String Ftaxcode;
    private String Fsynerpreason;
    private Integer Fskupurchpricev2;
    private Integer Fboxsizex;
    private Integer Fboxsizey;
    private Integer Fboxsizez;
    private String Fskupacklist;
    private String Fskuappage;
    private Integer Fsexid;
    private Long Fsupplierid;
}