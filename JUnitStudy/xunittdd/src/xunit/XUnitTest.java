package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite();
        //테스트 메소드 실행
        suite.add(new TestCaseTest("testTemplateMethod"));
        //result 테스트 실행
        suite.add(new TestCaseTest("testResult"));
        //failed result formmating test
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        //failed result test
        suite.add(new TestCaseTest("testFailedResult"));
        //suite
        suite.add(new TestCaseTest("testSuite"));
        //run
        TestResult result = new TestResult();
        suite.run(result);
        //out
        System.out.println(result.getSummary());
    }
}
