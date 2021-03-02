package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class HzwSkuPO {
    private Long Fskuid;
    private Long Fcooperatorsubaccountid;
    private Long Fcooperatorid;
    @ColumnAnnotation
    private Integer Fcategoryid;
    @ColumnAnnotation
    private Integer Fskutype;
    @ColumnAnnotation
    private Integer Fskuoperationmodel;
    private String Fbarcode;
    @ColumnAnnotation
    private String Fskulocalcode;
    private String Fskudimensionalbarcode;
    @ColumnAnnotation
    private String Fskutitle;
    @ColumnAnnotation
    private String Fskusubtitle;
    private String Fskupromotdesc;
    @ColumnAnnotation
    private String Fskushortname;
    @ColumnAnnotation
    private String Fskusaleattr;
    private String Fskusaleattrdesc;
    @ColumnAnnotation
    private String Fskukeyattr;
    private String Fskukeyattrdesc;
    @ColumnAnnotation
    private Integer Fskureferprice;
    private Long Fskuproperty;
    private Long Fskuproperty1;
    private Integer Fskustate;
    @ColumnAnnotation
    private Long Fskuweight;
    @ColumnAnnotation
    private Integer Fskunetweight;
    @ColumnAnnotation
    private Long Fskuvolume;
    @ColumnAnnotation
    private Integer Fskusizex;
    @ColumnAnnotation
    private Integer Fskusizey;
    @ColumnAnnotation
    private Integer Fskusizez;
    @ColumnAnnotation
    private String Fskucategoryattr;
    private String Fskukeyword;
    @ColumnAnnotation
    private Integer Fskuvatrate;
    @ColumnAnnotation
    private Integer Fskupurchtaxrate;
    private Integer FskusnapversionFspushortname;
    private Integer Fskubuylimit;
    @ColumnAnnotation
    private Integer Fskubrand;
    private Integer Fskuexchangepoint;
    private Long Fmainskuid;
    @ColumnAnnotation
    private Date Fskulastuptime;
    @ColumnAnnotation
    private Date Fskulastdowntime;
    @ColumnAnnotation
    private Date Fskuaddtime;
    @ColumnAnnotation
    private Date Fskulastupdatetime;
    private Date Flastupdatetime;
    private Integer Fskudurability;
    private String Fskutag;
    @ColumnAnnotation
    private Integer Fskusort;
    private String Fskuexpertscomments;
    @ColumnAnnotation
    private Integer Fskupurchprice;
    @ColumnAnnotation
    private String Fskuunit;
    @ColumnAnnotation
    private String Fpopskucode;
    private Date Fskueffectivetime;
    private Date Fskuexpiretime;
    private String Fskutwodimcodelastprintperson;
    @ColumnAnnotation
    private Date Fskustockexpiretime;
    private String Fskunameindex;
    @ColumnAnnotation
    private String Fskuspecmodel;
    @ColumnAnnotation
    private String Fskuproducingarea;
    private Integer Fskupackrate;
    @ColumnAnnotation
    private String Fskupacklist;
    @ColumnAnnotation
    private Integer Fskuceilprice;
    @ColumnAnnotation
    private Integer Fskufloorprice;
    @ColumnAnnotation
    private Integer Fskuunitcost;
    @ColumnAnnotation
    private Integer Fskucontacternum;
    private Integer Fskutravellernum;
    private String Fskusalearea;
    private Integer Fplatformid;
    private String Fcontractid;
    @ColumnAnnotation
    private Integer Fflagshipstoreid;
    private String Fmainurl;
    private Long Fspuid;
    private Integer Fcustomserviceid;
    private String Fcertifyurl;
    private String Fcertifyurlid;
    private String Fadpicurl;
    private String Fadlink;
    private Date Fadbegintime;
    private Date Fadendtime;
    private Integer Fskuservicenum;
    private String Fskuappage;
    private Integer Fsexid;
    private Integer Fisforce;
    private String Fcurrency;
    private Integer Fsource;
    @ColumnAnnotation
    private Long Ftoptempid;
    @ColumnAnnotation
    private Long Fbottomtempid;
    @ColumnAnnotation
    private Long Ftempid;
    private String Fsocialsofttxt;

}