import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestHighestLowestIndex {
  @Test
  public void testHighestLowestIndexBeforeInputTest() {
    HighestLowestIndex highestLowestIndex = new HighestLowestIndex();
    int[] testArray = {5, 1, 7, 0, 2, 4};
    int[] actual = highestLowestIndex.getHighestAndLowest(testArray);
    int[] expected = {2, 3};
    assertArrayEquals(actual, expected);
    
  }
  
}
