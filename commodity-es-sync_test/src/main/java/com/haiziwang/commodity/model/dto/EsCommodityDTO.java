package com.haiziwang.commodity.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class EsCommodityDTO {
    @JSONField(name = "eagle_type")
    private String eagleType = "update";
    // 租户号，商品化必填
    @JSONField(name = "eagle_tenant_id")
    private String eagleTenantId;
    //es主键（Fplatformid_Fspuid_Fskuid_Fentityid）
    @JSONField(name = "Pkey")
    private String pkey;

    @JSONField(name = "Fplatformid")
    private Integer Fplatformid;
    @JSONField(name = "Fspuid")
    private String Fspuid;
    @JSONField(name = "Fspuextcode")
    private String Fspuextcode;
    @JSONField(name = "Fcooperatorid")
    private Long Fcooperatorid;
    @JSONField(name = "Fsputitle")
    private String Fsputitle;
    @JSONField(name = "Fspushortname")
    private String Fspushortname;
    @JSONField(name = "Fspustate")
    private Integer Fspustate;
    @JSONField(name = "Fspuoperationmodel")
    private Integer Fspuoperationmodel;
    @JSONField(name = "Fsputype")
    private Integer Fsputype;
    @JSONField(name = "Fspumainurl")
    private String Fspumainurl;
    @JSONField(name = "Fcategoryid")
    private Integer Fcategoryid;
    @JSONField(name = "Fcategorylist")
    private List<CategaryDTO> Fcategorylist;
    @JSONField(name = "Ferppubnavid")
    private String Ferppubnavid;
    @JSONField(name = "Fshopnavi")
    private List<String> Fshopnavi;
    @JSONField(name = "Fcreateuser")
    private String Fcreateuser;
    @JSONField(name = "Fspuaddtime")
    private Long Fspuaddtime;
    @JSONField(name = "Fspulastupdatetime")
    private Long Fspulastupdatetime;
    @JSONField(name = "Fspuonlinetitle")
    private String Fspuonlinetitle;
    @JSONField(name = "Fbrandid")
    private Integer Fbrandid;
    @JSONField(name = "Fspusaleattr")
    private String Fspusaleattr;
    @JSONField(name = "Fskubindlist")
    private List<SkuBindDTO> Fskubindlist;
    @JSONField(name = "Fspuproperty")
    private List<Integer> Fspuproperty;
    @JSONField(name = "Fskuproperty")
    private List<Integer> Fskuproperty;
    @JSONField(name = "Fspuchildrenids")
    private List<String> Fspuchildrenids;
    @JSONField(name = "Ferpbrandid")
    private String Ferpbrandid;
    @JSONField(name = "Fbrandname")
    private String Fbrandname;
    @JSONField(name = "Ferpbrandname")
    private String Ferpbrandname;
    @JSONField(name = "Ferpcategorylist")
    private List<CategaryDTO> Ferpcategorylist;
    @JSONField(name = "Fisforce")
    private Integer Fisforce;

    @JSONField(name = "Fskuid")
    private Long Fskuid;
    @JSONField(name = "Fskuextcode")
    private String Fskuextcode;
    @JSONField(name = "Fskulocalcode")
    private String Fskulocalcode;
    @JSONField(name = "Fgoodsno")
    private String Fgoodsno;
    @JSONField(name = "Fskustate")
    private Integer Fskustate;
    @JSONField(name = "Fskumainurl")
    private String Fskumainurl;
    @JSONField(name = "Fskuerpreferprice")
    private Integer Fskuerpreferprice;
    @JSONField(name = "Fskuunit")
    private String Fskuunit;
    @JSONField(name = "Fskuunitcost")
    private Integer Fskuunitcost;
    @JSONField(name = "Fskusaleattr")
    private String Fskusaleattr;
    @JSONField(name = "Fskuaddtime")
    private Long Fskuaddtime;
    @JSONField(name = "Fskulastupdatetime")
    private Long Fskulastupdatetime;
    @JSONField(name = "FClothingObject")
    private ClothingDTO FClothingObject;
    @JSONField(name = "FMaternalChildObject")
    private MaternalChildDTO FMaternalChildObject;
    @JSONField(name = "FGlobalObject")
    private Object FGlobalObject;
    @JSONField(name = "Fpackinfolist")
    private List<PackInfoDTO> Fpackinfolist;

    @JSONField(name = "Fentityid")
    private Integer Fentityid;
    @JSONField(name = "Fincatalog")
    private Integer Fincatalog;
    @JSONField(name = "Fworkstatecode")
    private String Fworkstatecode;
    @JSONField(name = "Fcirculationmodecode")
    private String Fcirculationmodecode;
    @JSONField(name = "Fskuareaprice")
    private Integer Fskuareaprice;
    @JSONField(name = "Fskuareaproperty")
    private List<Integer> Fskuareaproperty;
    @JSONField(name = "Fskuareaaddtime")
    private Long Fskuareaaddtime;
    @JSONField(name = "Fskuarealastupdatetime")
    private Long Fskuarealastupdatetime;
    @JSONField(name = "Fstoreid")
    private String Fstoreid;
    @JSONField(name = "Fskuareafirstpublishtime")
    private Long Fskuareafirstpublishtime;
    @JSONField(name = "Fsaleslabelid")
    private String Fsaleslabelid;
    @JSONField(name = "Farealabelidlist")
    private List<Long> Farealabelidlist;

}