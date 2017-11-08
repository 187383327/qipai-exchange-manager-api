package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ComplexCondition {
    private final Type type;
    private final List<Object> conditions = new ArrayList<>();

    public ComplexCondition(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public List<Object> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        if (conditions.size() == 1) {
            return conditions.get(0).toString();
        }
        List<String> sql = new ArrayList<>();
        for (Object condition : conditions) {
            if (condition.getClass() == ComplexCondition.class) {
                sql.add("(" + condition.toString() + ")");
            } else {
                sql.add(condition.toString());
            }
        }
        return StringUtils.join(sql, type.getSeparator());
    }

    public static enum Type {
        and(" and "), or(" or ");

        private String separator;

        private Type(String separator) {
            this.separator = separator;
        }

        public String getSeparator() {
            return separator;
        }
    }
}
