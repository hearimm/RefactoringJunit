import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MasterTester extends TestCase {

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }

  public static Test suite() {
    TestSuite result = new TestSuite();
    result.addTest(new TestSuite(FileReaderTester.class));
//    result.addTest(new TestSuite(FileWriterTester.class));
    // 기타 테스트 클래스를 추가하며 한번에 실행 하도록 구성할 수 있다.
    return result;
  }
}
