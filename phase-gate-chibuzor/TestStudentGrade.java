import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestStudentGrade {
  @Test
  public void testStudentGradeExists() {
    StudentGrade studentGrade = new StudentGrade();
    int[] testArray = {5, 1, 7, 0, 2, 4};
    int[] actual = studentGrade.//getHighestAndLowest(testArray);
    int[] expected = {2, 3};
    assertArrayEquals(actual, expected);
    
  }
  
}
