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

   public void testTemplateMethod() {
        wasRun.run();
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = wasRun.run();
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    public void testFailedResultFormatting() {
        //testResult Test
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = wasRun.run();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }
}
