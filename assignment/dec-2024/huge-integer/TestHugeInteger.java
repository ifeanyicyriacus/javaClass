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
    HugeInteger number = new HugeInteger(numberStr);
    int[] numberArray = number.parse(numberStr);
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
    String numberStr = "-7066003851";
    HugeInteger number = new HugeInteger(numberStr);
    assertEquals("-7066003851", number.toString());
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
    
    actual = HugeInteger.subtract(number2, number1);
    expected = new HugeInteger("-1979796958401221124");
    assertEquals(expected.toString(), actual.toString());
  }
  
  
  @Test
  public void testThatIsEqualToMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number2Copy = new HugeInteger("10233435476944232322");
    
    assertFalse(number1.isEqualTo(number2));
    assertTrue(number2.isEqualTo(number2Copy));
  }
  
  @Test
  public void testThatIsNotEqualToMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number2Copy = new HugeInteger("10233435476944232322");
    
    assertTrue(number1.isNotEqualTo(number2));
    assertFalse(number2.isNotEqualTo(number2Copy));
  }
  
  @Test
  public void testThatIsGreaterThanMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number2Copy = new HugeInteger("10233435476944232322");
    assertTrue(number1.isGreaterThan(number2));
    assertFalse(number2.isGreaterThan(number2Copy));
    assertFalse(number2.isGreaterThan(number1));
    
  }
  
}
