package com.example.supertypetoken;

import java.util.HashMap;
import java.util.Map;

public class TypeToken {
    static class TypesafeMap {
        Map<Class<?>, Object> map = new HashMap<>();
        <T> void put(Class<T> clazz, T value) {
            map.put(clazz, value);
        }
        <T> T get(Class<T> clazz){
            return clazz.cast(map.get(clazz));  //.cast -> 명시적 타입캐스팅
        }
    }

    public static void main(String[] args) throws Exception {
        TypesafeMap m = new TypesafeMap();
        m.put(Integer.class, 1);
        m.put(String.class, "string");
    }
}
