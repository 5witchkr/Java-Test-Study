package com.example.supertypetoken;

import com.example.supertypetoken.SupertypetokenApplication.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class SpringTypeRefRestTemplate {
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();
//        //ERR
//        List<User> users = rt.getForObject("http://localhost:8080", List.class);
//        System.out.println(users.get(0).getName());
//
//        //NON TypeSafe
//        List<Map> musers = rt.getForObject("http://localhost:8080", List.class);
//        System.out.println(musers.get(0).get("name"));
        
        //TypeSafe with TypeReference
        List<User> user = rt.exchange("http://localhost:8080",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {}).getBody();
        user.forEach(System.out::println);
    }
}
