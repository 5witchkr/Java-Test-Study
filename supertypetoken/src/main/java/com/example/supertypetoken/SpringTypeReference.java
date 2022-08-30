package com.example.supertypetoken;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringTypeReference {
    public static void main(String[] args) {
        ParameterizedTypeReference<?> typeReference = new ParameterizedTypeReference<List<Map<Set<Integer>, String>>>() {};
        System.out.println(typeReference.getType());
    }
}
