package com.github.microprograms.qipai_exchange_manager_api.utils;

public class Sort {
    private final Type type;
    private final String fieldName;

    public Sort(Type type, String fieldName) {
        this.type = type;
        this.fieldName = fieldName;
    }

    public Type getType() {
        return type;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return fieldName + " " + type.name();
    }

    public static enum Type {
        asc, desc;
    }
}
