package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        //테스트 메소드 실행
        new TestCaseTest("testRunning").run();

        //테스트 SetUp
        new TestCaseTest("testSetUp").run();
    }
}
