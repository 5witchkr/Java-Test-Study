package com.example.reactivestream.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Slf4j
public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        //Future = 미래에 실행되는 비동기작업의 결과물
        //submit = return 값을 가질 수 있는 callable
        Future<String> f = es.submit(() -> {
            Thread.sleep(2000);
            log.info("Async");
            return "Hello";
        });

        //isDone = 작업이 다 됐는지 확인함
        log.info(String.valueOf(f.isDone()));
        Thread.sleep(2100);
        log.info("Task");
        log.info(String.valueOf(f.isDone()));

        //Future.get()은 결과가 올때까지 Blocking 됨
        log.info(f.get());
        log.info("Exit");
    }
}
