import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class TestPanChecker {
  @Test
  public void testPanCheckerBeforeInputTest() {
    PanChecker panChecker = new PanChecker();
    String sampleTest1 = "The quick brown fox jumpes over the lazy dog";
    String sampleTest2 = "The quick brown fox jumpes over the lzzy rat";
    assertTrue(panChecker.panChecker(sampleTest1));
    assertFalse(panChecker.panChecker(sampleTest2));
  }
  
}
