import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {

  private FileReader _input;
  private FileReader _empty;

  public FileReaderTester(String name) {
    super(name);
  }

  protected void setUp() {
    try {
      // 본인 폴더 경로로 넣어주세용
      _input = new FileReader(
          "./src/main/resources/data.txt");
      _empty = newEmptyFile();

    } catch (IOException e) {
      throw new RuntimeException("테스트 파일을 열 수 없음");
    }
  }

  private FileReader newEmptyFile() throws IOException {
    File empty = new File("./src/main/resources/empty.txt");
    FileOutputStream out = new FileOutputStream(empty);
    out.close();
    return new FileReader(empty);
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
    assertEquals('d', ch);
  }

  public void testReadAtEnd() throws IOException {
    int ch = -1234;
    for (int i = 0; i < 141; i++) {
      ch = _input.read();
    }
    assertEquals("read at end", -1, _input.read());
  }

  public void testReadBoundaries() throws IOException {
    assertEquals("read first char", 'B', _input.read());
    int ch;
    for (int i = 0; i < 135; i++) {
      ch = _input.read();
    }
    assertEquals("read last char", '6', _input.read());
    assertEquals("read at end", -1, _input.read());
    assertEquals("read past end", -1, _input.read());
  }

  public void testEmptyRead() throws IOException {
    assertEquals(-1, _empty.read());
  }

  public void testReadAfterClose() throws IOException {
    _input.close();
    try {
      _input.read();
      fail("read past end에 예외가 발생하지 않음");
    } catch (IOException io) {
    }
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
  }
}

