package com.haiziwang.commodity.model.po;

import com.haiziwang.commodity.annotation.ColumnAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class ConversionSpuPO {
    private Long Fid;
    @ColumnAnnotation
    private Integer Fplatformid;
    private String Fspuid;
    @ColumnAnnotation
    private String Fspuextcode;
    private String Fmainspuid;
    @ColumnAnnotation
    private Long Fcooperatorid;
    private Integer Fflagshipstoreid;
    @ColumnAnnotation
    private String Fsputitle;
    @ColumnAnnotation
    private String Fspuonlinetitle;
    @ColumnAnnotation
    private String Fspushortname;
    private String Fspusubtitle;
    @ColumnAnnotation
    private Integer Fspustate;
    @ColumnAnnotation
    private Integer Fspuoperationmodel;
    @ColumnAnnotation
    private Integer Fsputype;
    @ColumnAnnotation
    private String Fspumainurl;
    @ColumnAnnotation
    private Integer Fbrandid;
    @ColumnAnnotation
    private String Ferpbrandid;
    @ColumnAnnotation
    private Integer Fcategoryid;
    @ColumnAnnotation
    private String Ferppubnavid;
    @ColumnAnnotation
    private String Fspusaleattr;
    private String Fspucategoryattr;
    private Long Ftempid;
    private Long Ftoptempid;
    private Long Fbottomtempid;
    @ColumnAnnotation
    private Long Fspuproperty;
    private Integer Fspuvatrate;
    private Integer Fspupurchtaxrate;
    private String Fspuproducingarea;
    private String Fspuspecmodel;
    private Integer Fspusort;
    private String Fsaleslabelid;
    private Long Fmcid;
    private String Fremark;
    @ColumnAnnotation
    private String Fcreateuser;
    @ColumnAnnotation
    private Date Fspuaddtime;
    @ColumnAnnotation
    private Date Fspulastupdatetime;
    private Date Fspulastupstoretime;
    private Date Fspulastdownstoretime;
    private Integer Fisforce;

}