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
  
  @Test
  public void testThatAddFunctionReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    
    HugeInteger actual = HugeInteger.add(number1, number2);
    HugeInteger expected = new HugeInteger("22446667912289685768");
    assertEquals(expected.toString(), actual.toString());
  }
  
  @Test
  public void testThatSubtractFunctionReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    
    HugeInteger actual = HugeInteger.subtract(number1, number2);
    HugeInteger expected = new HugeInteger("1979796958401221124");
    assertEquals(expected.toString(), actual.toString());
    
    
    
  }
  
  
  
  
  
  
  
}
