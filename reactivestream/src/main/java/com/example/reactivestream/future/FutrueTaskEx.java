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
        }) {
            @Override
            protected void done() {
                try {
                    log.info(get());
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        es.execute(ft);
        es.shutdown();
    }
}
