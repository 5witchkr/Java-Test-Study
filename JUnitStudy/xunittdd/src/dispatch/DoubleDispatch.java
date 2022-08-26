package dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {
    interface Post {void postOn(SNS sns);}
    static class Text implements Post{
        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }
    static class Picture implements Post{
        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }
    interface SNS {
        void post(Text post);
        void post(Picture post);
    }
    static class Facebook implements SNS{
        @Override
        public void post(Text post) {
            System.out.println("text-facebook");
        }
        @Override
        public void post(Picture post) {
            System.out.println("picture-facebook");
        }
    };
    static class Twitter implements SNS{
        @Override
        public void post(Text post) {
            System.out.println("text-twitter");
        }
        @Override
        public void post(Picture post) {
            System.out.println("picture-twitter");
        }
    };
    static class Line implements SNS{
        @Override
        public void post(Text post) {
            System.out.println("text-line");
        }
        @Override
        public void post(Picture post) {
            System.out.println("picture-line");
        }
    };

    public static void main(String[] args){
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter(), new Line());

        //other
        //case -> repository.findxxx() ??
        //proxy type
        //use -> Proxy Visitor Pattern
        //visitor pattern -> deep check

        posts.forEach(p -> sns.forEach(p::postOn));
    }
}

