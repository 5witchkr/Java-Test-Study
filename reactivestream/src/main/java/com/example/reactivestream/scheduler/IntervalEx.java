package com.example.reactivestream.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
public class IntervalEx {
    public static void main(String[] args) {
        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                int num = 0;
                @Override
                public void request(long n) {
                    ScheduledExecutorService exce = Executors.newSingleThreadScheduledExecutor();
                    exce.scheduleAtFixedRate(() -> {
                        sub.onNext(num++);
                    }, 0, 300, TimeUnit.MILLISECONDS);
                }

                @Override
                public void cancel() {

                }
            });
        };

        pub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                log.debug("onNext: {}",integer);
            }

            @Override
            public void onError(Throwable t) {
                log.debug("onError: {}",t);
            }

            @Override
            public void onComplete() {
                log.debug("onComplete");
            }
        });
    }
}
