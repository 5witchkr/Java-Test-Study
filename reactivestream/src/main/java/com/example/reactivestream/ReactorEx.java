package com.example.reactivestream;

import reactor.core.publisher.Flux;

/**
 *
 */
public class ReactorEx {
    public static void main(String[] args) {

        //case 1
        Flux.<Integer>create(e -> {
                    e.next(1);
                    e.next(2);
                    e.next(3);
                    e.complete();
                })
                .log()
                .map(s->s*10)
                .log()
                .subscribe(System.out::println);


        //case 2
        Flux.<Integer>create(e -> {
            e.next(1);
            e.next(2);
            e.next(3);
            e.complete();
        })
                .log()
                .map(s->s*10)
                .log()
                .reduce(0, (a,b) -> a+b)
                .log()
                .subscribe(System.out::println);
    }
}
