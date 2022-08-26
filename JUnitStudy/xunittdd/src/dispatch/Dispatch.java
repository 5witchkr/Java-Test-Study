package dispatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            System.out.println("run2");
        }
    }
    public static void main(String[] arg){
        List<Service> svc = Arrays.asList(new RunService(), new RunnerService());
        svc.forEach(Service::run);
    }
}
