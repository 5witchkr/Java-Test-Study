package domaineither;

public interface Result<T> extends Either<RuntimeException, T> {
    static <T> Result<T> right(T right) {
        return new Result.Right<>(right);
    }

    static <T> Result<T> left(RuntimeException left) {
        return new Result.Left<>(left);
    }
    final class Right<T> implements Result<T> {
        public Right(T value) {}
        @Override
        public RuntimeException getLeft() {
            return null;
        }
        @Override
        public boolean isLeft() {
            return false;
        }
        @Override
        public boolean isRight() {
            return false;
        }
        @Override
        public T get() {
            return null;
        }
        @Override
        public String stringPrefix(){
            return null;
        }
    }
    final class Left<T> implements Result<T> {
        public Left(RuntimeException ex) {
        }
        @Override
        public RuntimeException getLeft(){
            return null;
        }
        @Override
        public boolean isLeft() {
            return false;
        }
        @Override
        public boolean isRight(){
            return false;
        }
        @Override
        public T get(){
            return null;
        }
        @Override
        public String stringPrefix() {
            return null;
        }
    }
}
