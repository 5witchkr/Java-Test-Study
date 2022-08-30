package com.example.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperTypeToken {
    static class TypesafeMap {
        Map<Class<?>, Object> map = new HashMap<>();
        <T> void put(Class<T> clazz, T value){
            map.put(clazz, value);
        }
        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
        }
    }
    static class TypeReference<T>{
        Type type;
        public TypeReference(){
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof ParameterizedType) {
                this.type = ((ParameterizedType)stype).getActualTypeArguments()[0];
            }
            else throw new RuntimeException();
        }
    }
    public static void main(String[] args) throws Exception{
        TypeReference t = new TypeReference<String>() {};
        System.out.println(t.type);
//        TypesafeMap m = new TypesafeMap();
//        m.put(Integer.class, 1);
//        m.put(String.class, "String");
//        m.put(List.class, Arrays.asList(1,2,3));
//
//        System.out.println(m.get(Integer.class));
//        System.out.println(m.get(String.class));
//        System.out.println(m.get(List.class));
    }
}
