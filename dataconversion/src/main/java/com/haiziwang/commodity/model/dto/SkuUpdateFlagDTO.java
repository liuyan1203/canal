package com.haiziwang.commodity.model.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class SkuUpdateFlagDTO {
    private Boolean updateSku = Boolean.FALSE;
    private Boolean updateSpu = Boolean.FALSE;

    public SkuUpdateFlagDTO check(String columnName, Map<String, Set<String>> conversionRelation) {
        for (Map.Entry entry : conversionRelation.entrySet()) {
            String key = (String) entry.getKey();
            Set<String> value = (Set<String>) entry.getValue();
            if (value.contains(columnName)) {
                if ("sku".equals(key)) {
                    if (!updateSku)
                        this.setUpdateSku(true);
                }
                if ("spu".equals(key)) {
                    if (!updateSpu)
                        this.setUpdateSpu(true);
                }
                if (updateSku && updateSpu)
                    break;
            }
        }
        return this;
    }

}