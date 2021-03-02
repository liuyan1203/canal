package com.haiziwang.commodity.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 母婴行业
 */
@Data
public class MaternalChildDTO {
    //适用年龄主阶段
    @JSONField(name = "Fmainagescope")
    private String Fmainagescope;
    //适用年龄子阶段(年龄段)
    @JSONField(name = "Fsubagescope")
    private String Fsubagescope;
    //适用性别 1-男 2-女 3-通用
    @JSONField(name = "Fgender")
    private Integer Fgender;

}