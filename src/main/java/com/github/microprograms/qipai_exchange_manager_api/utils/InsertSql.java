package com.github.microprograms.qipai_exchange_manager_api.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InsertSql {
    public static String build(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> clz = object.getClass();
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        for (Method method : clz.getDeclaredMethods()) {
            if (method.getName().startsWith("get")) {
                fieldNames.add(StringUtils.uncapitalize(method.getName().replaceFirst("get", "")));
                Class<?> returnType = method.getReturnType();
                if (returnType == String.class) {
                    String fieldValue = (String) method.invoke(object);
                    fieldValues.add(fieldValue == null ? "null" : "'" + fieldValue.replaceAll("'", "''") + "'");
                }
                if (returnType == Integer.class) {
                    Integer fieldValue = (Integer) method.invoke(object);
                    fieldValues.add(fieldValue == null ? "null" : fieldValue.toString());
                }
                if (returnType == Long.class) {
                    Long fieldValue = (Long) method.invoke(object);
                    fieldValues.add(fieldValue == null ? "null" : fieldValue.toString());
                }
            }
        }
        String tableName = clz.getSimpleName();
        return String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, StringUtils.join(fieldNames, ","), StringUtils.join(fieldValues, ","));
    }
}
