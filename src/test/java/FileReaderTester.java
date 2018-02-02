import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;

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
    assert ('d' == ch);
  }

}

