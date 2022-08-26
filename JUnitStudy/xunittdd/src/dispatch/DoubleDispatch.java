package dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch {
    interface Post {void postOn(SNS sns);}
    static class Text implements Post{
        public void postOn(SNS sns) {
            System.out.println("text -> "+sns.getClass().getSimpleName());
        }
    }
    static class Picture implements Post{
        public void postOn(SNS sns) {
            System.out.println("picture -> " +sns.getClass().getSimpleName());
        }
    }
    interface SNS {}
    static class Facebook implements SNS{};
    static class Twitter implements SNS{};

    public static void main(String[] args){
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter());

        posts.forEach(p -> sns.forEach(p::postOn));
    }
}
