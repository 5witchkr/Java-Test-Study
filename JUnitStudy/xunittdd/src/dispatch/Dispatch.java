package dispatch;

public class Dispatch {
    static abstract class Service {
        abstract void run();
    }
    static class RunService extends Service {
        @Override
        void run() {
            System.out.println("run1");
        }
    }
    static class RunnerService extends Service {
        @Override
        void run() {
            System.out.println("runt2");
        }
    }
    public static void main(String[] arg){
        Service svc = new RunService();
        //컴파일을 하더라도 결정되지않음 (런타임시 구조 obj - obj)
        svc.run();
    }

}
