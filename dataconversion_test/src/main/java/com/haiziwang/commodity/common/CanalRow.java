package com.haiziwang.commodity.common;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.haiziwang.commodity.enums.TableType;

import java.util.List;

public class CanalRow {
    private String tableName;
    private TableType tableType = TableType.ZERO;
    private CanalEntry.EventType eventType;
    private List<CanalEntry.Column> columns;
    private boolean needChange;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TableType getTableType() {
        return this.tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public CanalEntry.EventType getEventType() {
        return eventType;
    }

    public void setEventType(CanalEntry.EventType eventType) {
        this.eventType = eventType;
    }

    public List<CanalEntry.Column> getColumns() {
        return columns;
    }

    public void setColumns(List<CanalEntry.Column> columns) {
        this.columns = columns;
    }

    public boolean getNeedChange() {
        return needChange;
    }

    public void setNeedChange(boolean needChange) {
        this.needChange = needChange;
    }
}