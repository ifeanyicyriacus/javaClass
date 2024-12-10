import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBankeBankATM{
  @Test
  public void testBankeBankATMExists(){
    assertTrue(BankeBankATM.isExist());
  }

  @Test
  public void testBankeBankATMAddMoneteryStringValueFunction(){
    String actual = BankeBankATM.addMoneteryStringValue("102.07", "101.62");
    String expected = "203.69";
    assertEquals(actual, expected);
  }

  @Test
  public void testBankeBankATMSubstractMoneteryStringValueFunction(){
    String actual = BankeBankATM.substractMoneteryStringValue("102.07", "101.62");
    String expected = "0.45";
    assertEquals(actual, expected);
    
    actual = BankeBankATM.substractMoneteryStringValue("102.07", "200.68");
    expected = "-98.61";
    assertEquals(actual, expected);
    
    
  }


}

