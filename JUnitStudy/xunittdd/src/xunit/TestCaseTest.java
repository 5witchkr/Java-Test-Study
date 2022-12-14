package xunit;


import xunit.annotation.Test;

//테스트케이스를 테스트하는 테스트
public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }
    //refactor
    WasRun wasRun;

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
    }

    @Override
    public void setUp() {
        wasRun = new WasRun("testMethod");
    }

    @Test
    public void testTemplateMethod() {
       TestResult result = new TestResult();
       wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    @Test
    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    public void testFailedResultFormatting() {
        //testResult Test
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        TestResult result = new TestResult();
        suite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }
}
