package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        //테스트 메소드 실행
        new TestCaseTest("testTemplateMethod").run();
        //result 테스트 실행
        new TestCaseTest("testResult").run();
        //failed result formmating test
        new TestCaseTest("testFailedResultFormatting").run();
        //failed result test
        new TestCaseTest("testFailedResult").run();

    }
}
