package com.example.reactivestream.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



@Slf4j
public class FluxScEx2 {
    public static void main(String[] args) throws InterruptedException {
        //case1
        //interval -> 주기를 가지고 무한대로 실행 (daemon thread)
        Flux.interval(Duration.ofMillis(500))
                .subscribe(s-> log.debug("onNext:{}", s));

        log.debug("exit");
        TimeUnit.SECONDS.sleep(5);

        //JVM은 userThread는 남아있으면 종료하지않음(case2)
        //그러나 daemonThread는 남아있어도 종료해버림(case1)


//        //otherCase userThread는 mainThread가 끝나도 계속됨 (JVM이 계속 떠있다.)
//        Executors.newSingleThreadExecutor().execute(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("Hello");
//        });
//        System.out.println("Exit");
    }
}
