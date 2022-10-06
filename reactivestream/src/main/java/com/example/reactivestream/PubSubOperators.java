package com.example.reactivestream;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * flow: Publisher -> [Data1] -> Operator1 -> [Data2] -> Operator2 -> [Data3] -> Subscriber
 *
 * 1. map (d1 -> f -> d2)
 * 2. sum
 * 3. reduce
 * 4. genericType
 */
@Slf4j
public class PubSubOperators {
    public static void main(String[] args) {
        Publisher<Integer> pub = iterPub(Stream.iterate(1, a -> a + 1).limit(10)
                .collect(Collectors.toList()));

        Publisher<Integer> mapPub = mapPub(pub, (Function<Integer, Integer>) s -> s * 10);

        Publisher<Integer> map2Pub = mapPub(mapPub, (Function<Integer, Integer>) s -> -s);

//        Publisher<Integer> sumPub = sumPub(map2Pub);

//        Publisher<Integer> reducePub = reducePub(map2Pub, 0, (BiFunction<Integer, Integer, Integer>)(a, b) -> a+b);

        Publisher<Integer> mapGenPub = mapGenPub(map2Pub, s-> s*3 );

//        mapGenPub.subscribe(logSub());
        mapGenPub.subscribe(logGenSub());
    }

    private static <T> Publisher<T> mapGenPub(Publisher<T> pub, Function<T, T> f){
        return new Publisher<T>() {
            @Override
            public void subscribe(Subscriber<? super T> sub) {
                pub.subscribe(new DelegateGenSub<T>(sub){
                    @Override
                    public void onNext(T t){
                        sub.onNext(f.apply(t));
                    }
                });
            }
        };
    }

    private static Publisher<Integer> reducePub(Publisher<Integer> pub, int init, BiFunction<Integer, Integer, Integer> bf) {
        return sub -> pub.subscribe(new DelegateSub(sub){
            int result = init;
            @Override
            public void onNext(Integer i){
                result = bf.apply(result, i);
            }

            @Override
            public void onComplete(){
                sub.onNext(result);
                sub.onComplete();
            }
        });
    }


    private static Publisher<Integer> sumPub(Publisher<Integer> pub) {
        return sub -> pub.subscribe(new DelegateSub(sub){
            int sum = 0;
            @Override
            public void onNext(Integer i){
                sum += i;
            }

            @Override
            public void onComplete(){
                sub.onNext(sum);
                sub.onComplete();
            }
        });
    }

    private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> fun) {
        return sub -> pub.subscribe(new DelegateSub(sub){
            @Override
            public void onNext(Integer i){
                sub.onNext(fun.apply(i));
            }
        });
    }

    private static Subscriber<Integer> logSub() {
        return new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe:");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                log.debug("onNext:{}", integer);
            }

            @Override
            public void onError(Throwable t) {
                log.debug("onError:{}", t);
            }

            @Override
            public void onComplete() {
                log.debug("onComplete");
            }
        };
    }

    private static <T> Subscriber<T> logGenSub() {
        return new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe:");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(T t) {
                log.debug("onNext:{}", t);
            }

            @Override
            public void onError(Throwable t) {
                log.debug("onError:{}", t);
            }

            @Override
            public void onComplete() {
                log.debug("onComplete");
            }
        };
    }

    private static Publisher<Integer> iterPub(List<Integer> iterable) {
        return sub -> sub.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                try {
                    iterable.forEach(s -> sub.onNext(s));
                    sub.onComplete();
                } catch (Throwable t) {
                    sub.onError(t);
                }
            }

            @Override
            public void cancel() {

            }
        });
    }
}
