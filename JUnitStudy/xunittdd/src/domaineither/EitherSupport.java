package domaineither;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface EitherSupport {
    default <P, R> Either<? extends RuntimeException, R>
    getResult(Function<P, R> func, P param, Logger logger) {
        try {
            return Either.right(func.apply(param));
        } catch (RuntimeException re) {
            return Either.left(re);
        }
    }

    default <P, R> Either<? extends RuntimeException, List<R>>
    getResultList(Function<P, List<R>> func, P param, Logger logger) {
        try {
            return Either.right(runc.apply(param));
        } catch (RuntimeException re) {
            System.out.println("Error occurred");
            return Either.left(re);
        }
    }

    @Slf4j
    public class DomainCode implements EitherSupport {
        public void f() {
            Either<? extends RuntimeException, String> resultOrException = getResult(String::valueOf,0,log);
            Either<? extends RuntimeException, List<String>> resultListOrException = getResultList(
                    (Integer i) -> IntStream.range(0, i)
                            .boxed()
                            .map(String::valueOf)
                            .collect(Collectors.toList()), 0 , log);
        }
    }
}
