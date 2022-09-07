package com.example.reactivestream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscription;

public class PubSub {
    public static void main(String[] args) throws InterruptedException {
        Iterable<Integer> itr = Arrays.asList(1,2,3,4,5);
        ExecutorService es = Executors.newCachedThreadPool();

        Publisher p = new Publisher() {
          @Override
          public void subscribe(Subscriber subscriber){
              Iterator<Integer> it = itr.iterator();
              subscriber.onSubscribe(new Subscription() {
                  @Override
                  public void request(long n) {
                      es.execute(() -> {
                          int i = 0;
                          try {
                              while (i++ < n){
                                  if (it.hasNext()){
                                      subscriber.onNext(it.next());
                                  } else {
                                      subscriber.onComplete();
                                      break;
                                  }
                              }
                          } catch (RuntimeException e){
                              subscriber.onError(e);
                          }
                      });
                  }

                  @Override
                  public void cancel() {

                  }
              });
          }
        };
        Subscriber<Integer> s = new Subscriber<Integer>() {
            Subscription subscription;
            @Override//need
            public void onSubscribe(Subscription subscription) {
                System.out.println(Thread.currentThread().getName()+"onSubscribe");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override//optional
            public void onNext(Integer item) {
                System.out.println(Thread.currentThread().getName()+"onNext " + item);
                this.subscription.request(1);
            }

            @Override//optional
            public void onError(Throwable throwable) {
                System.out.println("onError"+throwable.getMessage());
            }

            @Override//optional
            public void onComplete() {
                System.out.println(Thread.currentThread().getName()+"onComplete");
            }
        };

        p.subscribe(s);
        es.awaitTermination(10, TimeUnit.HOURS);
        es.shutdown();
    }
}
