package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class HzwSkuAreaPO {

    private Long Fskuareaid;

    private Long Fskuid;

    private Integer Fareaid;

    private Long Fcooperatorsubaccountid;

    private String Fcooperatorskuareacode;

    private String Fcooperatorbarcode;

    private Integer Fpromotiontype;

    private String Fskuareapromotdesc;

    @ColumnAnnotation
    private Integer Fskuareaprice;

    @ColumnAnnotation
    private Integer Fskuareapreprice;

    private Integer Fskuareacostprice;

    private Integer Fskuareabusinesscost;

    private String Fskuareaestimatedispatch;

    @ColumnAnnotation
    private Long Fskuareaproperty;

    private Integer Fskuareastate;
    @ColumnAnnotation
    private Integer Fskuareaminbuycount;
    @ColumnAnnotation
    private Integer Fskuareamaxbuycount;

    @ColumnAnnotation
    private Date Fskuareaaddtime;

    @ColumnAnnotation
    private Date Fskuarealastupdatetime;
    @ColumnAnnotation
    private Integer Fskuareabuymultiple;

    private Integer Fskuareastorelogistictype;

    @ColumnAnnotation
    private Date Fskuareafirstpublishtime;

    private Date Fskuareapromotdescefftime;

    private Date Fskuareapromotdescexptime;

    @ColumnAnnotation
    private String Fskuareabuyer;

    private Integer Fskuareasharecommission;

    private Integer Fentityid;

    @ColumnAnnotation
    private String Fstoreid;

    @ColumnAnnotation
    private Integer Fchannelid;

    private String Fdetail;

    @ColumnAnnotation
    private String Fworkstatecode;

    @ColumnAnnotation
    private String Fcirculationmodecode;

    @ColumnAnnotation
    private Integer Fskuareapostprice;

    private Integer Fincatalog;

    private Integer Fareasort;

    @ColumnAnnotation
    private String Fsaleslabelid;

    private String Fsaleslabelname;

    private String Fsaleslabelurl;

    private Date Fsalesstarttime;

    private Date Fsalesendtime;

    private Integer Fstorestate;

    @ColumnAnnotation
    private Date Fsharecommissionbegintime;

    private Date Fsharecommissionendtime;

    private Long Fcooperatorid;

    private Integer Fisinstall;

    private Integer Finstallcost;

    private String Fcontractid;
}