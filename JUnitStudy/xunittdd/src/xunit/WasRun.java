package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun extends TestCase {
    public boolean wasRun;
    public boolean wasSetUp;


    //선실행
    @Override
    public void setUp(){
        wasSetUp = true;
    }

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        wasRun = true;
    }

}
