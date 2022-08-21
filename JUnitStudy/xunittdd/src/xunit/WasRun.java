package xunit;

public class WasRun extends TestCase {
    public String log;


    //선실행
    @Override
    public void setUp(){
        log = "setUp";
    }

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        log += " testMethod";
    }

    @Override
    public void tearDown() {
        log += " tearDown";
    }

}
