package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class SelectSql {
    private String tableName;
    private List<String> fieldNames;
    private Object where;
    private List<Sort> sorts;
    private Pager pager;

    public SelectSql tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public SelectSql fieldNames(List<String> fieldNames) {
        this.fieldNames = fieldNames;
        return this;
    }

    public SelectSql where(Object where) {
        this.where = where;
        return this;
    }

    public SelectSql sorts(List<Sort> sorts) {
        this.sorts = sorts;
        return this;
    }

    public SelectSql pager(Pager pager) {
        this.pager = pager;
        return this;
    }

    public String build() {
        StringBuffer sb = new StringBuffer("SELECT ");
        sb.append(fieldNames == null || fieldNames.isEmpty() ? "*" : StringUtils.join(fieldNames, ","));
        sb.append(" FROM ").append(tableName);
        if (where != null) {
            sb.append(" WHERE ").append(where.toString());
        }
        if (sorts != null && !sorts.isEmpty()) {
            sb.append(" ORDER BY ").append(StringUtils.join(sorts, ","));
        }
        if (pager != null) {
            sb.append(" ").append(pager);
        }
        return sb.toString();
    }
}
