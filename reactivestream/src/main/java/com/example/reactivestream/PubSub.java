package com.example.reactivestream;

import java.util.Arrays;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

public class PubSub {
    public static void main(String[] args) {
        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);

        Publisher p = new Publisher() {
          @Override
          public void subscribe(Subscriber subscriber){
              subscriber.onSubscribe(new Subscription() {
                  @Override
                  public void request(long n) {

                  }

                  @Override
                  public void cancel() {

                  }
              });
          }
        };
        Subscriber<Integer> s = new Subscriber<Integer>() {
            @Override//need
            public void onSubscribe(Subscription subscription) {

            }

            @Override//optional
            public void onNext(Integer item) {

            }

            @Override//optional
            public void onError(Throwable throwable) {

            }

            @Override//optional
            public void onComplete() {

            }
        };

        p.subscribe(s);
    }
}
