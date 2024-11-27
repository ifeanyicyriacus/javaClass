import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestTitleCase {
  @Test
  public void testTitleCaseBeforeInputTest() {
    TitleCase titleCase = new TitleCase();
    String Text = "All is wEll that ends well";
    String actual = titleCase.toTitleCase(Text);
    String expected = "All Is Well That Ends Well";
    assertEquals(actual, expected);
    
  }
  
}
