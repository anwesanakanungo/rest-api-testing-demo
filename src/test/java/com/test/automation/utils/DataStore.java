package com.test.automation.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.LinkedHashMap;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataStore {

    private static final ThreadLocal<LinkedHashMap<String, Object>> dataMap =
            ThreadLocal.withInitial(() -> new LinkedHashMap<String, Object>());

    public static void setValue(String key, Object value){
        dataMap.get().put(key,value);
    }
    public static Object getValue(String key){
       return dataMap.get().get(key);
    }
}
