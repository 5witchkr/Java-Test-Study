package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        TestResult result = new TestResult();
        //테스트 메소드 실행
        new TestCaseTest("testTemplateMethod").run(result);
        //result 테스트 실행
        new TestCaseTest("testResult").run(result);
        //failed result formmating test
        new TestCaseTest("testFailedResultFormatting").run(result);
        //failed result test
        new TestCaseTest("testFailedResult").run(result);
        //
        new TestCaseTest("testSuite").run(result);

        System.out.println(result.getSummary());
    }
}
