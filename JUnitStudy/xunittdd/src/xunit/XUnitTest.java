package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        //runner
        TestSuite suite = TestCaseTest.suite();
        //run
        TestResult result = new TestResult();
        suite.run(result);
        //out
        System.out.println(result.getSummary());
    }
}
