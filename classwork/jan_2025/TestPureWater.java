import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestPureWater{
  @Test
  public void testPureWaterClassExist(){
    new PureWater();
  }
  
  @Test
  public void testThatfindIndexFunctionReturnsExpectedResult(){
    int[] numbers = {12, 17, 24, 32, 14};
    String expected = PureWater.findIndex(numbers, 24);
    String actual = "index 2";
    assertEquals(expected, actual);
  }
  
  @Test
  public void testThatfindIndexFunctionReturnsExpectedResultWhenKeywordNotFound(){
    int[] numbers = {12, 17, 24, 32, 14};
    String expected = PureWater.findIndex(numbers, 54);
    String actual = "not available";
    assertEquals(expected, actual);
  }

  @Test
  public void testThatPositiveNegativeAndZeroCountFunctionReturnsExpectedResult(){
    int[] numbers = {15, 34, -1, 24, -7, 9, 0};
    String expected = PureWater.positiveNegativeAndZeroCount(numbers);
    int zeros = 1;
    int positives = 4;
    int negatives = 2;
    String actual = String.format("positives: %d%nnegatives: %d%nzeros: %d", positives, negatives, zeros);
    assertEquals(expected, actual);
    
  }
  

}
