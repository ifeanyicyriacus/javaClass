import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCaesarCipher{
  String sampleBasic = "abcdefghijklmnopqrstuvwxyz";
  
  @Test 
  public void testCaesarCipherExists(){
    assertTrue(CaesarCipher.isExist());
  }
  
  @Test
  public void testGetAlphabetIdByLetter(){
    int actual = CaesarCipher.getAlphabetIdByLetter("a");
    int expected = 0;
    assertEquals(actual, expected);
    actual = CaesarCipher.getAlphabetIdByLetter("z");
    expected = 25;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testEncrypt(){
    int shift = 3;
    String actual = CaesarCipher.encrypt(sampleBasic, 90);
    String expected = "mnopqrstuvwxyzabcdefghijkl";
    assertEquals(actual, expected);
  }
  
  @Test
  public void testDecrypt(){
    int shift = 3;
    String actual = CaesarCipher.decrypt("mnopqrstuvwxyzabcdefghijkl", 90);
    String expected = sampleBasic;
    assertEquals(actual, expected);
  }
}
