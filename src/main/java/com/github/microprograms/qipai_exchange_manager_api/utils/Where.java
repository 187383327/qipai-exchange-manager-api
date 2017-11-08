package com.github.microprograms.qipai_exchange_manager_api.utils;

import com.github.microprograms.qipai_exchange_manager_api.utils.ComplexCondition.Type;

public class Where {
    public static ComplexCondition and(Object... conditions) {
        return build(Type.and, conditions);
    }

    public static ComplexCondition or(Object... conditions) {
        return build(Type.or, conditions);
    }

    public static ComplexCondition build(Type type, Object... conditions) {
        ComplexCondition complexCondition = new ComplexCondition(type);
        for (Object condition : conditions) {
            complexCondition.getConditions().add(condition);
        }
        return complexCondition;
    }
}
