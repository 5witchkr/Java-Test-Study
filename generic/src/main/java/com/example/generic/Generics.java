package com.example.generic;

public class Generics {
    static class Hello<T> {//T -> type parameter
        T t;
        T method(T val){return null;}
    }

    static void print(String value){
        System.out.println(value);
    }

    public static void main (String[] args){
        print("Generic");
        new Hello<String>(); //type argument
    }
}
//for typesafe, for recycle generic code
