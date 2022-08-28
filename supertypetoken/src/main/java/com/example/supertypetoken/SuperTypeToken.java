package com.example.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperTypeToken {
    static class Sup<T> {
        T value;
    }
    static class Sub extends Sup<String>{} //not eraser Type

    public static void main(String[] args) throws NoSuchFieldException{
        Sup<String> s = new Sup<>();
        Sub b = new Sub();
        Type t = b.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]);
    }
}
