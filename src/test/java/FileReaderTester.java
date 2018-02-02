
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {

  private FileReader _input;

  public FileReaderTester(String name) {
    super(name);
  }

  protected void setUp() {
    try {
      // 본인 폴더 경로로 넣어주세용
      _input = new FileReader(
          "/Users/Hyuk/Documents/devWork/RefactoringJunit/src/main/resources/data.txt");

    } catch (FileNotFoundException e) {
      throw new RuntimeException("테스트 파일을 열 수 없음");
    }
  }

  protected void tearDown() {
    try {
      _input.close();
    } catch (IOException e) {
      throw new RuntimeException("테스트 파일을 닫는 중 에러 발생");
    }
  }

  public void testRead() throws IOException {
    char ch = '&';
    for (int i = 0; i < 4; i++) {
      ch = (char) _input.read();
    }
    assertEquals('d',ch);
  }

  public void testReadAtEnd() throws IOException {
    int ch = -1234;
    for (int i = 0; i < 141; i++) {
      ch = _input.read();
    }
    assertEquals("read at end",-1,_input.read());
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
  }
}

