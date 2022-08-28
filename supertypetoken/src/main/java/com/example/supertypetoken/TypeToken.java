package com.example.supertypetoken;

public class TypeToken {
    static <T> T create(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }

    public static void main(String[] args) throws Exception {
        String o = create(String.class);
        System.out.println(o.getClass());
    }
}
