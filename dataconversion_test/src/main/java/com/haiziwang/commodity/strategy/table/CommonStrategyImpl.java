package com.haiziwang.commodity.strategy.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.annotation.ColumnAnnotation;
import com.haiziwang.commodity.common.CanalRow;
import com.haiziwang.commodity.common.Constant;
import com.haiziwang.commodity.utils.SpringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonStrategyImpl {

    private static final Logger logger = LoggerFactory.getLogger(CommonStrategyImpl.class);

    private static final int SPU_ID_LENGTH = 10;

    protected static final ApplicationContext context = SpringUtil.getApplicationContext();

    /**
     * 构造spuId
     *
     * @param skuId
     * @return
     */
    public static String createSpuId(Long skuId, String prefix) {
        StringBuffer sb = new StringBuffer(prefix);
        if (skuId != null && skuId > 0) {
            BigDecimal skuIdLength = new BigDecimal(String.valueOf(skuId).length()).setScale(0, BigDecimal.ROUND_HALF_UP);
            BigDecimal maxLength = new BigDecimal(String.valueOf(SPU_ID_LENGTH));
            int supplementLenth = maxLength.subtract(skuIdLength).intValue();
            IntStream.range(0, supplementLenth).forEach(i -> sb.append("0"));
            sb.append(String.valueOf(skuId));
        }
        return sb.toString();
    }

    /**
     * 获取需要转化的字段：通过反射获取自定义注解实现
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<String> getColumnsToChange(Class<T> clazz) {
        List<String> columns = new ArrayList<>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            columns = Arrays.stream(fields).filter(field -> {
                ColumnAnnotation columnAnnotation = field.getAnnotation(ColumnAnnotation.class);
                if (columnAnnotation != null) {
                    field.setAccessible(true);
                    return columnAnnotation.toChange();
                }
                return false;
            }).map(Field::getName).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columns;
    }

    protected Map<String, String> getUpdatedColumns(CanalRow canalRow, List<String> needUpdateColumns) {
        boolean needChange = false;
        Map<String, String> columnMap = new HashMap<>(100);
        List<CanalEntry.Column> columns = canalRow.getColumns();
        for (CanalEntry.Column column : columns) {
            String columnName = column.getName();
            String value = column.getValue();
            if (column.getUpdated() && needUpdateColumns.contains(columnName)) {
                if (!needChange) {
                    needChange = true;
                }
                columnMap.put(columnName, value);
            }
        }
        canalRow.setNeedChange(needChange);
        return columnMap;
    }

    protected Map<String, String> convertColumnsToMap(CanalRow canalRow) {
        Map<String, String> columnMap = new HashMap<>(100);
        List<CanalEntry.Column> columns = canalRow.getColumns();
        for (CanalEntry.Column column : columns) {
            String columnName = column.getName();
            String value = column.getValue();
            columnMap.put(columnName, value);
        }
        return columnMap;
    }

    /**
     * 拷贝实体
     *
     * @param object
     * @param columnName
     * @param value
     * @return
     */
    protected Object copyValue(Object object, String columnName, String value) {
        try {
            Field[] skuFields = object.getClass().getDeclaredFields();
            for (Field field : skuFields) {
                field.setAccessible(true);
                String name = field.getName();
                String type = field.getGenericType().toString();
                if (value != null && name.equalsIgnoreCase(columnName)) {
                    logger.debug("column[{}]  type[{}] value[{}]", columnName, type, value);
                    if (type.equals("class java.lang.String")) {
                        field.set(object, value);
                        break;
                    } else if (type.equals("class java.lang.Integer")) {
                        field.set(object, Integer.valueOf(value));
                        break;
                    } else if (type.equals("class java.lang.Boolean")) {
                        field.set(object, Boolean.valueOf(value));
                        break;
                    } else if (type.equals("class java.lang.Long")) {
                        field.set(object, Long.valueOf(value));
                        break;
                    } else if (type.equals("class java.util.Date")) {
                        if ("0000-00-00 00:00:00".equals(value)) {
                            break;
                        }
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = format.parse(value);
                        field.set(object, new Date(date.getTime()));
                        break;
                    } else if (type.equals("class java.time.LocalDateTime")) {
                        if ("0000-00-00 00:00:00".equals(value)) {
                            break;
                        }
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        field.set(object, LocalDateTime.parse(value, dateTimeFormatter));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 将CanalRow中CanalEntry.Column转化为具体PO
     *
     * @param canalRow
     * @param object
     * @return
     */
    protected Object getPOByCanalRow(CanalRow canalRow, Object object) {
        canalRow.setNeedChange(true);
        if (object != null) {
            List<CanalEntry.Column> columns = canalRow.getColumns();
            for (CanalEntry.Column column : columns) {
                String columnName = column.getName();
                String value = column.getValue();
                if (column.getUpdated()) {
                    logger.debug("table [{}] column [{}] 更新为：[{}]", columnName, value);
                }
                object = copyValue(object, columnName, value);
            }
        }
        return object;
    }

    /**
     * 根据spuId获取分表下标
     *
     * @param spuId
     * @return
     */
    protected static Integer getTableIndex(String spuId) {
        Integer index = null;
        if (StringUtils.isNotEmpty(spuId)) {
            long spuIdL = Long.valueOf(spuId.substring(2));
            index = Integer.valueOf((int) (spuIdL % Constant.DB_SHARDING));
        }
        return index;
    }

    protected static Integer getTableAreaIndex(String spuId) {
        Integer index = null;
        if (StringUtils.isNotEmpty(spuId)) {
            long spuIdL = Long.valueOf(spuId.substring(2));
            index = Integer.valueOf((int) (spuIdL % Constant.DB_SHARDING_AREA));
        }
        return index;
    }

    protected Boolean checkUpdateSpuOrSku(boolean flag) {
        if (!flag)
            flag = true;
        return flag;
    }

}