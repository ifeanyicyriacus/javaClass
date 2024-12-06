import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreditCardValidator{
  String sample1 = "4388576018402626";//invalid
  String sample2 = "5399831619690403";//valid
  String sample3 = "5399831619690404";//invalid
  String sample4 = "234319283049582";//invalid
  String sample5 = "634319283049";//invalid
  
  @Test
  public void testCreditCardValidatorExists(){
    assertTrue(CreditCardValidator.isExist());
  }

  @Test
  public void testGetSumOfEvenPlacedDigit(){
    int actual = CreditCardValidator.getSumOfEvenPlacedDigitDoubled(sample1);
    int expected = 37;
    assertEquals(actual, expected);
  }

  @Test
  public void testGetSumOfOddPlacedDigit(){
    int actual = CreditCardValidator.getSumOfOddPlacedDigit(sample1);
    int expected = 38;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testIsNumberCombinationCorrect(){
    boolean actual = CreditCardValidator.isNumberCombinationCorrect(sample1);
    boolean expected = false;
    assertEquals(actual, expected);
    actual = CreditCardValidator.isNumberCombinationCorrect(sample2);
    expected = true;
    assertEquals(actual, expected);
    actual = CreditCardValidator.isNumberCombinationCorrect(sample3);
    expected = false;
    assertEquals(actual, expected);
  }

  @Test
  public void testIsLengthValid(){
    assertTrue(CreditCardValidator.isLengthValid(sample1));
    assertFalse(CreditCardValidator.isLengthValid(sample5));
  }

  @Test
  public void testReturnCardType(){
    String actual = CreditCardValidator.returnCardType(sample1);
    String expected = "Visa";
    assertEquals(actual, expected);
    actual = CreditCardValidator.returnCardType(sample2);
    expected = "MasterCard";
    assertEquals(actual, expected);
    actual = CreditCardValidator.returnCardType(sample5);
    expected = "Discover";
    assertEquals(actual, expected);
  }
  
  @Test
  public void testSumDigitsInTwoDigitNumber(){
    int actual = CreditCardValidator.sumDigitsInTwoDigitNumber(18);
    int expected = 9;
    assertEquals(actual, expected);
    actual = CreditCardValidator.sumDigitsInTwoDigitNumber(10);
    expected = 1;
    assertEquals(actual, expected);
  }

  @Test
  public void testIsNumberDivisibleBy10(){
    assertTrue(CreditCardValidator.isNumberDivisibleBy10(90));
    assertFalse(CreditCardValidator.isNumberDivisibleBy10(34));
  }

}
