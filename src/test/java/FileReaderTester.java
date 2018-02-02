import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;

public class FileReaderTester extends TestCase {

  private FileReader _input;

  public FileReaderTester(String name) {
    super(name);
  }

  protected void setup() {
    try {
      _input = new FileReader("data.txt");
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

}

