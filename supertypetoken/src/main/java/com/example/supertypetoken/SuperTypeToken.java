package com.example.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperTypeToken {
    static class TypesafeMap {
        Map<Type, Object> map = new HashMap<>();
        <T> void put(TypeReference<T> tr, T value){
            map.put(tr.type, value);
        }
        <T> T get(TypeReference<T> tr) {
            if(tr.type instanceof Class<?>)
                return ((Class<T>)tr.type).cast(map.get(tr.type));//ex TypeReference<String>
            else
                return ((Class<T>)((ParameterizedType)tr.type).getRawType()).cast(map.get(tr.type));//ex TypeReference<List<String>>
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

        @Override
        public int hashCode() {
            return type.hashCode();
        }
    }
    public static void main(String[] args) throws Exception{
        TypesafeMap m = new TypesafeMap();
        m.put(new TypeReference<Integer>(){}, 1);
        m.put(new TypeReference<String>(){}, "String");
        m.put(new TypeReference<List>(){}, Arrays.asList(1,2,3));
        m.put(new TypeReference<List<Integer>>(){}, Arrays.asList(1,2,3));
        m.put(new TypeReference<List<String>>(){}, Arrays.asList("a","b","c"));
        m.put(new TypeReference<List<List<String>>>(){}, Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("c", "d"), Arrays.asList("e","f")
        ));

        System.out.println(m.get(new TypeReference<Integer>(){}));
        System.out.println(m.get(new TypeReference<String>(){}));
        System.out.println(m.get(new TypeReference<List>(){}));
        System.out.println(m.get(new TypeReference<List<Integer>>(){}));
        System.out.println(m.get(new TypeReference<List<String>>(){}));
        System.out.println(m.get(new TypeReference<List<List<String>>>(){}));
    }
}
