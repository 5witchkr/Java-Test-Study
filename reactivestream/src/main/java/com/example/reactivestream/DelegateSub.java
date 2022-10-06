package com.example.reactivestream;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DelegateSub implements Subscriber<Integer> {

    Subscriber sub;
    public DelegateSub(Subscriber<? super Integer> sub) {
        this.sub = sub;
    }

    @Override
    public void onSubscribe(Subscription s) {
        sub.onSubscribe(s);
    }

    @Override
    public void onError(Throwable t) {
        sub.onError(t);
    }

    @Override
    public void onComplete() {
        sub.onComplete();
    }

    @Override
    public void onNext(Integer i) {
        sub.onNext(i);
    }
}
