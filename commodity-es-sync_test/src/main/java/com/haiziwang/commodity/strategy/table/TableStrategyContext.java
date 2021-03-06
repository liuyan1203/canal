package com.haiziwang.commodity.strategy.table;

import com.haiziwang.commodity.enums.TableTypeEnum;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class TableStrategyContext {

    private TableStrategy tableStrategy;

    public TableStrategyContext(String msgId) {
        Map<String, String> clazzMap = TableTypeEnum.getAllClazz();
        if (!StringUtils.isEmpty(msgId)) {
            String clazz = clazzMap.get(msgId);
            try {
//                synchronized (this){
//                    tableStrategy = (TableStrategy) Class.forName(clazz).newInstance();
//                }
                tableStrategy = (TableStrategy) Class.forName(clazz).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public TableStrategy getTableStrategy() {
        return tableStrategy;
    }

}