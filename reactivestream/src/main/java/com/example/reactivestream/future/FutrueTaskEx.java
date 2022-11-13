package com.example.reactivestream.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutrueTaskEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        FutureTask<String> ft = new FutureTask<>(() -> {
            Thread.sleep(2000);
            log.info("Async");
            return "Hello";
        });

        es.execute(ft);

        log.info(String.valueOf(ft.isDone()));
        Thread.sleep(2100);
        log.info("Task");
        log.info(String.valueOf(ft.isDone()));

        log.info(ft.get());
        log.info("Exit");
    }
}
