import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestStudentGrade {
  int[][] sampleIntTable1 = {{2, 4, 5}, {10, 12, 15}, {15, 9, 14}};
  int[] sampleIntTable2 = {5, 2, 23, 10, 15};
  int[] sampleIntTable3 = {50, 20, 23, 100, 60};
  double[][] sampleDoubleTable1 = {{9.3, 4.6, 5.3}, {10.2, 12.2, 15.1}, {15.1, 2.9, 14.1}};
  double[][] sampleDoubleTable2 = {{2.9, 4.6, 0}, {10.2, 12.2, 0}, {15.1, 9.3, 0}};
  double[] sampleDoubleTable3 = {2.9, 10.2, 15.1};
  double[][] sampleDoubleTable4 = {{90.0, 45.0, 90.0}, {45.0, 12.0, 11.0}, {70.0, 9.3, 50.0}};
  double[][] sampleDoubleTable4WithTotal = {{90, 45, 90, 225}, {45, 12, 11, 68}, {70, 9.3, 50, 129.3}};
  double[] sampleDoubleTable5 = {50.1, 20.1, 23.1, 100.0, 60.2};
  
  @Test
  public void testStudentGradeExists() {
    assertTrue("failure - should be true", StudentGrade.isExist());
  }
  
  @Test
  public void testGetSumOfList() {
    double actual = StudentGrade.getSumOfList(sampleDoubleTable3, 0, sampleDoubleTable3.length);
    double expected = 28.2;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetAverageOf() {
    double actual = StudentGrade.getAverageOf(sampleDoubleTable3, 0, sampleDoubleTable3.length);
    double expected = 14.1;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetIndexOfHighestDouble() {
    int actual = StudentGrade.getIndexOfHighest(sampleDoubleTable3);
    int expected = 3;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetIndexOfHighestInt() {
    int actual = StudentGrade.getIndexOfHighest(sampleIntTable2);
    int expected = 2;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetIndexOfLowestDouble() {
    int actual = StudentGrade.getIndexOfLowest(sampleDoubleTable3);
    int expected = 0;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetIndexOfLowestInt() {
    int actual = StudentGrade.getIndexOfLowest(sampleIntTable2);
    int expected = 1;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetNumbersThatPassed() {
    int passMark = 50;
    int actual = StudentGrade.getNumbersThatPassed(sampleDoubleTable5, passMark);
    int expected = 3;
    assertEquals(actual, expected);
  }

  @Test
  public void testPluckDoubleColumn() {
    int columnNumber = 1;
    double[] actual = StudentGrade.pluckDoubleColumn(sampleDoubleTable1, columnNumber);
    double[] expected = {10.2, 12.2, 15.1};
    assertArrayEquals(actual, expected);
  }
  
  @Test
  public void testOverallHighest() {
    int numberOfcolumnsToConsider = 3;
    double[] actual = StudentGrade.overallHighest(sampleDoubleTable1, numberOfcolumnsToConsider);
    double[] expected = {1.0, 3.0, 15.1};
    assertArrayEquals(actual, expected);
  }
  @Test
  public void testOverallLowest() {
    int numberOfcolumnsToConsider = 3;
    double[] actual = StudentGrade.overallLowest(sampleDoubleTable1, numberOfcolumnsToConsider);
    double[] expected = {2.0, 1.0, 2.9};
    assertArrayEquals(actual, expected);
  }
  
    @Test  
    public void testFlipTable() {
    int targetRowLength = 3;
    int targetcolLength = 3;
    double[][] actual = StudentGrade.flipTable(sampleDoubleTable1, targetRowLength, targetcolLength);
    double[][] expected = {{9.3, 10.2, 15.1}, {4.6, 12.2, 15.1}, {5.3, 15.1, 14.1}};
    assertArrayEquals(actual, expected);
  }
  
  @Test
  public void testGetHardestSubject() {
    int numberOfcolumnsToConsider = 3;
    int actual = StudentGrade.getHardestSubject(sampleDoubleTable4, numberOfcolumnsToConsider);
    int expected = 1;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetEasiestSubject() {
    int numberOfcolumnsToConsider = 3;
    int actual = StudentGrade.getEasiestSubject(sampleDoubleTable4, numberOfcolumnsToConsider);
    int expected = 0;
    assertEquals(actual, expected);
  } 
  
  @Test  
  public void testSubjectToPassList() {
    int numberOfcolumnsToConsider = 3;
    int[] actual = StudentGrade.subjectToPassList(sampleDoubleTable4, numberOfcolumnsToConsider);
    int[] expected = {2, 0, 2};
    assertArrayEquals(actual, expected);
  }
  
  @Test  
  public void testGetBestStudentIndex() {
    int totalColumnIndex = 3;
    int actual = StudentGrade.getBestStudentIndex(sampleDoubleTable4WithTotal, totalColumnIndex);
    int expected = 0;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetWorstStudentIndex() {
    int totalColumnIndex = 3;
    int actual = StudentGrade.getWorstStudentIndex(sampleDoubleTable4WithTotal, totalColumnIndex);
    int expected = 1;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetClassTotalScore() {
    int totalColumnIndex = 3;
    double actual = StudentGrade.getClassTotalScore(sampleDoubleTable4WithTotal, totalColumnIndex);
    double expected = 422.3;
    assertEquals(actual, expected);
  }
  
  @Test
  public void testGetClassAverageScore() {
    int totalColumnIndex = 3;
    double actual = StudentGrade.getClassAverageScore(sampleDoubleTable4WithTotal, totalColumnIndex);
    actual = Math.round(actual);
    double expected = 141;
    assertEquals(actual, expected);
  }
  
}
