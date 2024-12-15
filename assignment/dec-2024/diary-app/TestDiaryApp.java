import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDiaryApp{
  @Test 
  public void testEntryExists(){
    assertTrue(Entry.isExist());
  }
  
  @Test
  public void testEntryConstructorCreatesANewEntry(){
    assertEquals(Entry.getEntryCount(), 0);
    String newEntrySubject = "Dec 15 entry";
    String newEntryBody = "They sent the wrong santa to Semicolon, he comes bearing snacks :)";
    Entry newEntry = new Entry(newEntrySubject, newEntryBody);
    assertEquals(newEntry.getId(), 1);
    assertEquals(newEntry.getEntrySubject(), newEntrySubject);
    assertEquals(newEntry.getEntryBody(), newEntryBody);
    assertEquals(Entry.getEntryCount(), 1);
  }
  
  @Test 
  public void testDiaryExists(){
    assertTrue(Diary.isExist());
  }

}
