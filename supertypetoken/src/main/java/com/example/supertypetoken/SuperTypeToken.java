package com.example.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SuperTypeToken {
    static class Sup<T> {
        T value;
    }

    public static void main(String[] args) throws NoSuchFieldException{
        //anonymous class
        Sup b = new Sup<String>(){};
        //not eraser (runtime type safe)
        Type t = b.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) t;
        System.out.println(ptype.getActualTypeArguments()[0]);
    }
}
