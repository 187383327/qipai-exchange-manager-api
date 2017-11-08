package com.github.microprograms.qipai_exchange_manager_api.utils;

public class Condition {
    private final String key;
    private final String value;

    public Condition(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + value;
    }
}
