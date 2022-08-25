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
        //svc.runt()은 컴파일시점에서는 결정되지않음 (런타임시 결정 obj - obj)
        //dynamicDispatch
        svc.run(); //receiver parameter 가 new *Service 를 결정
    }

}
