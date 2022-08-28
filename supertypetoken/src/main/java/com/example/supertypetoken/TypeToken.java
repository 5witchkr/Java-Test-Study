package com.example.supertypetoken;

public class TypeToken {
    static <T> T create(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }
    static class Generic<T> {
        T value;
        void set(T t) {}
        T get() {return null;}
    }//type erasure

    public static void main(String[] args) throws Exception {
        String o = create(String.class);
        System.out.println(o.getClass());

        Generic<String> s = new Generic<String>();
        s.value = "String~!";   //type erasure-> runtime => ObjectType
        Generic<Integer> i = new Generic<Integer>();
        i.value = 1;
        i.set(10);
    }
}
