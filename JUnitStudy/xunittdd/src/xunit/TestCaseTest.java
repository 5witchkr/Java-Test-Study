package xunit;


//테스트케이스를 테스트하는 테스트
public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    //refactor

    WasRun wasRun;
    @Override
    public void setUp() {
        wasRun = new WasRun("testMethod");
    }

   public void testRunning() {
        Assert.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEquals("setUp testMethod", wasRun.log);
        Assert.assertEquals(true, wasRun.wasRun);
    }

    public void testSetUp() {
        Assert.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();
        //setUp 순서
        Assert.assertEquals("setUp testMethod", wasRun.log);
        Assert.assertEquals(true, wasRun.wasSetUp);
    }
}
