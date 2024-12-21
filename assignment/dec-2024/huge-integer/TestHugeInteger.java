import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestHugeInteger{
  @Test
  public void testHugeIntegerExist(){
    assertTrue(HugeInteger.isExist());
  }

  @Test
  public void testParseFunction(){
    String numberStr = "12345";
    int numberStrLength = numberStr.length();
    int[] numberArray = HugeInteger.parse(numberStr);
    int numberArrayLength = numberArray.length;
    assertEquals(numberArrayLength, 40);
    int emptyRange = numberArrayLength - numberStrLength;
    
    int stringIndex = 0;
    for (int index = 0; index < emptyRange; index += 1){
      if(index < emptyRange){
        assertEquals(0, numberArray[index]);
      }else {
        int digit = Integer.valueOf(String.valueOf(numberStr.charAt(stringIndex)));
        assertEquals(digit, numberArray[index]);
      }
    }
  }
  
  @Test
  public void testToStringFunction(){
    String numberStr = "7066003851";
    HugeInteger number = new HugeInteger(numberStr);
    assertEquals("7066003851", number.toString());
    
    
  }
  
  
}
