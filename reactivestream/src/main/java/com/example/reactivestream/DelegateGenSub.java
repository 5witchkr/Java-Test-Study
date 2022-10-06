//package com.example.reactivestream;
//
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//
//public class DelegateGenSub<T> implements Subscriber<T> {
//
//    Subscriber sub;
//
//    public DelegateGenSub(Subscriber<? super T> sub) {
//        this.sub = sub;
//    }
//
//    @Override
//    public void onSubscribe(Subscription s) {
//        sub.onSubscribe(s);
//    }
//
//    @Override
//    public void onError(Throwable t) {
//        sub.onError(t);
//    }
//
//    @Override
//    public void onComplete() {
//        sub.onComplete();
//    }
//
//    @Override
//    public void onNext(T i) {
//        sub.onNext(i);
//    }
//}
