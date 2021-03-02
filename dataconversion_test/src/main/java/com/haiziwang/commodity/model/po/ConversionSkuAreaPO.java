package com.haiziwang.commodity.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class ConversionSkuAreaPO {
    private Long Fid;

    private Integer Fplatformid;

    private String Fspuid;

    private Long Fskuid;

    private Integer Fentityid;

    private Integer Fchannelid;

    private String Fstoreid;

    private Integer Fincatalog;

    private String Fworkstatecode;

    private String Fcirculationmodecode;

    private Integer Fskuareapostprice;

    private Integer Fskuareaprice;

    private Integer Fskuareapreprice;

    private String Fsaleslabelid;

    private String Fsubchannelinfo;

    private Long Fskuareaproperty;

    private String Fskuareabuyer;

    private Date Fskuareaaddtime;

    private Date Fskuarealastupdatetime;

    private Date Fskuareafirstpublishtime;
}