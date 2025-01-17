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
    HugeInteger number = new HugeInteger(numberStr);
    int[] numberArray = number.parse(numberStr);
    
    int numberArrayLength = number.getNumber().length;
    assertEquals(numberArrayLength, 40);
    
    numberStr = numberStr.replace("_", "").replace("-", "");
    int numberStrLength = numberStr.length();
    assertEquals(numberStrLength, number.getLength());
    
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
    String expected = "22446667912289685768";
    assertEquals(expected, actual.toString());
  }
  
  @Test
  public void testThatSubtractFunctionReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    
    HugeInteger actual = HugeInteger.subtract(number1, number2);
    String expected = "1979796958401221124";
    assertEquals(expected, actual.toString());
    
    actual = HugeInteger.subtract(number2, number1);
    expected = "-1979796958401221124";
    assertEquals(expected, actual.toString());
  }
  
  
  @Test
  public void testThatIsEqualToMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number2Copy = new HugeInteger("10233435476944232322");
    HugeInteger number2CopyNeg = new HugeInteger("-10233435476944232322");

    assertFalse(number1.isEqualTo(number2));
    assertTrue(number2.isEqualTo(number2Copy));
    assertFalse(number2.isEqualTo(number2CopyNeg));
  }
  
  @Test
  public void testThatIsNotEqualToMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number2Copy = new HugeInteger("10233435476944232322");
    HugeInteger number2CopyNeg = new HugeInteger("-10233435476944232322");

    assertTrue(number1.isNotEqualTo(number2));
    assertFalse(number2.isNotEqualTo(number2Copy));
    assertTrue(number2.isNotEqualTo(number2CopyNeg));
  }
  
  @Test
  public void testThatIsGreaterThanMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number1Neg = new HugeInteger("-12213232435345453446");
    HugeInteger number2Neg = new HugeInteger("-10233435476944232322");
    HugeInteger number1Short = new HugeInteger("5232435345453446");
    
    assertFalse(number1.isGreaterThan(number1));
    assertFalse(number1Neg.isGreaterThan(number1Neg));
    assertTrue(number1.isGreaterThan(number1Neg));
    assertFalse(number1Neg.isGreaterThan(number1));
    
    assertFalse(number2.isGreaterThan(number2));
    assertFalse(number2Neg.isGreaterThan(number2Neg));
    assertTrue(number2.isGreaterThan(number2Neg));
    assertFalse(number2Neg.isGreaterThan(number2));
    
    assertTrue(number1.isGreaterThan(number1Short));
    assertFalse(number1Neg.isGreaterThan(number1Short));
    assertTrue(number1.isGreaterThan(number2));
    assertFalse(number2.isGreaterThan(number1));
  }
  
  @Test
  public void testThatIsLessThanMethodReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number1Neg = new HugeInteger("-12213232435345453446");
    HugeInteger number2Neg = new HugeInteger("-10233435476944232322");
    HugeInteger number1Short = new HugeInteger("5232435345453446");

    assertFalse(number1.isLessThan(number1));
    assertFalse(number1Neg.isLessThan(number1Neg));
    assertFalse(number1.isLessThan(number1Neg));
    assertTrue(number1Neg.isLessThan(number1));

    assertFalse(number2.isLessThan(number2));
    assertFalse(number2Neg.isLessThan(number2Neg));
    assertFalse(number2.isLessThan(number2Neg));
    assertTrue(number2Neg.isLessThan(number2));

    assertFalse(number1.isLessThan(number1Short));
    assertTrue(number1Neg.isLessThan(number1Short));
    assertFalse(number1.isLessThan(number2));
    assertTrue(number2.isLessThan(number1));
  
  }
  
  @Test
  public void testThatIsGreaterThanOrEqualToReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number1Neg = new HugeInteger("-12213232435345453446");
    HugeInteger number2Neg = new HugeInteger("-10233435476944232322");
    HugeInteger number1Short = new HugeInteger("5232435345453446");

    assertTrue(number1.isGreaterThanOrEqualTo(number1));
    assertTrue(number1Neg.isGreaterThanOrEqualTo(number1Neg));
    assertTrue(number1.isGreaterThanOrEqualTo(number1Neg));
    assertFalse(number1Neg.isGreaterThanOrEqualTo(number1));

    assertTrue(number2.isGreaterThanOrEqualTo(number2));
    assertTrue(number2Neg.isGreaterThanOrEqualTo(number2Neg));
    assertTrue(number2.isGreaterThanOrEqualTo(number2Neg));
    assertFalse(number2Neg.isGreaterThanOrEqualTo(number2));

    assertTrue(number1.isGreaterThanOrEqualTo(number1Short));
    assertFalse(number1Neg.isGreaterThanOrEqualTo(number1Short));
    assertTrue(number1.isGreaterThanOrEqualTo(number2));
    assertFalse(number2.isGreaterThanOrEqualTo(number1));
  }
  
  @Test
  public void testThatIsLessThanOrEqualToReturnsCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    HugeInteger number1Neg = new HugeInteger("-12213232435345453446");
    HugeInteger number2Neg = new HugeInteger("-10233435476944232322");
    HugeInteger number1Short = new HugeInteger("5232435345453446");
    
    assertTrue(number1.isLessThanOrEqualTo(number1));
    assertTrue(number1Neg.isLessThanOrEqualTo(number1Neg));
    assertFalse(number1.isLessThanOrEqualTo(number1Neg));
    assertTrue(number1Neg.isLessThanOrEqualTo(number1));
    
    assertTrue(number2.isLessThanOrEqualTo(number2));
    assertTrue(number2Neg.isLessThanOrEqualTo(number2Neg));
    assertFalse(number2.isLessThanOrEqualTo(number2Neg));
    assertTrue(number2Neg.isLessThanOrEqualTo(number2));
    
    assertFalse(number1.isLessThanOrEqualTo(number1Short));
    assertTrue(number1Neg.isLessThanOrEqualTo(number1Short));
    assertFalse(number1.isLessThanOrEqualTo(number2));
    assertTrue(number2.isLessThanOrEqualTo(number1));    
  }
  
  @Test
  public void testThatMultiplyFunctionReturnCorrectValue(){
    HugeInteger number1 = new HugeInteger("12213232435345453446");
    HugeInteger number2 = new HugeInteger("10233435476944232322");
    int multiplier1 = 10; int multiplier2 = 5;
//    HugeInteger number1Neg = new HugeInteger("12213232435345453446");
//    HugeInteger number2Neg = new HugeInteger("10233435476944232322");
    int multiplier1Neg = -10; int multiplier2Neg = -5;

    HugeInteger expected = HugeInteger.multiply(number1, multiplier1);
    assertEquals("122132324353454534460", expected.toString());
    expected = HugeInteger.multiply(number2, multiplier2);
    assertEquals("51167177384721161610", expected.toString());

    expected = HugeInteger.multiply(number1, multiplier1Neg);
    assertEquals("-122132324353454534460", expected.toString());
    expected = HugeInteger.multiply(number2, multiplier2Neg);
    assertEquals("-51167177384721161610", expected.toString());
    

  }

//  @Test
//  public void testThatDivideFunctionReturnCorrectValue(){
//    HugeInteger number1 = new HugeInteger("60");
//    HugeInteger number2 = new HugeInteger("10");
//    int divisor1 = 10; int divisor2 = 5;
//
//    HugeInteger expected = HugeInteger.divide(number1, divisor1);
//    assertEquals("6", expected.toString());
//    expected = HugeInteger.divide(number2, divisor2);
//    assertEquals("2", expected.toString());
//
//  }
//
}
