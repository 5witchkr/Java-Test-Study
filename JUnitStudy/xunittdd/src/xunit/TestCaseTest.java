package xunit;


//테스트케이스를 테스트하는 테스트
public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

   public void testRunning() {
        WasRun wasRun = new WasRun("testMethod");
        Assert.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assert.assertEquals(true, wasRun.wasRun);
    }

    public void testSetUp() {
        WasRun wasRun = new WasRun("testMethod");
        Assert.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();
        Assert.assertEquals(true, wasRun.wasSetUp);
    }
}
