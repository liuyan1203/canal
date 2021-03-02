package com.haiziwang.commodity.utils;

import com.haiziwang.commodity.common.Constant;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableUtil {

    public static String getPrefixTableName(String tableName) {
        if (StringUtils.isEmpty(tableName))
            return tableName;
        Pattern pattern = Pattern.compile("_\\d+$");
        Matcher matcher = pattern.matcher(tableName);
        if (matcher.find()) {
            int idx = tableName.lastIndexOf("_");
            if (idx != -1) {
                tableName = tableName.substring(0, idx);
            }
        }
        return tableName;
    }

    /**
     * 根据spuId获取分表下标
     *
     * @param spuId
     * @return
     */
    public static Integer getTableIndex(String spuId) {
        Integer index = null;
        if (StringUtils.isNotEmpty(spuId)) {
            long spuIdL = Long.valueOf(spuId.substring(2));
            index = Integer.valueOf((int) (spuIdL % Constant.DB_SHARDING));
        }
        return index;
    }

    public static Integer getTableAreaIndex(String spuId) {
        Integer index = null;
        if (StringUtils.isNotEmpty(spuId)) {
            long spuIdL = Long.valueOf(spuId.substring(2));
            index = Integer.valueOf((int) (spuIdL % Constant.DB_SHARDING_AREA));
        }
        return index;
    }
}