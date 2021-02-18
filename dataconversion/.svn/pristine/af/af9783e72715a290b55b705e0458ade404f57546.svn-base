package com.haiziwang.commodity.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TableTypeEnum {

    T_SKU("t_sku", "com.haiziwang.commodity.strategy.table.SkuStrategyImpl"),
    T_SKU_ERP("t_sku_erp", "com.haiziwang.commodity.strategy.table.SkuErpStrategyImpl"),
    T_SPU("t_spu", "com.haiziwang.commodity.strategy.table.SpuStrategyImpl"),
    T_SPU_ERP("t_spu_erp", "com.haiziwang.commodity.strategy.table.SpuErpStrategyImpl"),
    T_SKU_AREA("t_sku_area", "com.haiziwang.commodity.strategy.table.SkuAreaStrategyImpl"),
    T_SKU_PACK_INFO("t_sku_pack_info", "com.haiziwang.commodity.strategy.table.PackInfoStrategyImpl");

    private String msgId;
    private String clazz;

    TableTypeEnum(String msgId, String clazz) {
        this.msgId = msgId;
        this.clazz = clazz;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public static Map<String, String> getAllClazz() {
        return Arrays.stream(TableTypeEnum.values())
                .collect(Collectors.toMap(TableTypeEnum::getMsgId, TableTypeEnum::getClazz));
    }

}
