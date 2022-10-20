package com.example.reactivestream.scheduler;

import reactor.core.publisher.Flux;

public class FluxScEx {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .subscribe(System.out::println);
    }
}
