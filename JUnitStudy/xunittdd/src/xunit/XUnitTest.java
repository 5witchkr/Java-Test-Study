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


        //composite pattern
        TestSuite suite2 = new TestSuite();
        suite2.add(new TestCaseTest("testTemplateMethod"));
        suite2.add(suite);
        suite2.add(suite);
        //run & out
        TestResult result2 = new TestResult();
        suite2.run(result2);
        System.out.println(result2.getSummary());
    }
}
