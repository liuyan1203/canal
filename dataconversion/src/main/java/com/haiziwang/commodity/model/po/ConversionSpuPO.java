package com.haiziwang.commodity.model.po;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ConversionSpuPO {
    private Long Fid;
    private Integer Fplatformid;
    private String Fspuid;
    private String Fspuextcode;
    private String Fmainspuid;
    private Long Fcooperatorid;
    private Integer Fflagshipstoreid;
    private String Fsputitle;
    private String Fspuonlinetitle;
    private String Fspushortname;
    private String Fspusubtitle;
    private Integer Fspustate;
    private Integer Fspuoperationmodel;
    private Integer Fsputype;
    private String Fspumainurl;
    private Integer Fbrandid;
    private String Ferpbrandid;
    private Integer Fcategoryid;
    private String Ferppubnavid;
    private String Fspusaleattr;
    private String Fspucategoryattr;
    private Long Ftempid;
    private Long Ftoptempid;
    private Long Fbottomtempid;
    private Long Fspuproperty;
    private Integer Fspuvatrate;
    private Integer Fspupurchtaxrate;
    private String Fspuproducingarea;
    private String Fspuspecmodel;
    private Integer Fspusort;
    private String Fsaleslabelid;
    private Long Fmcid;
    private String Fremark;
    private String Fcreateuser;
    private Date Fspuaddtime;
    private Date Fspulastupdatetime;
    private Date Fspulastupstoretime;
    private Date Fspulastdownstoretime;


}