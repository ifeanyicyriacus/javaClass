import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestDiaryApp{
  @Test 
  public void testEntryExists(){
    assertTrue(Entry.isExist());
  }
  
  @Test
  public void testEntryConstructorCreatesANewEntry(){
    int entryCountBeforeInstantiation = Entry.getEntryCount();
    String newEntrySubject = "Dec 15 entry";
    String newEntryBody = "They sent the wrong santa to Semicolon, he comes bearing snacks :)";
    Entry newEntry = new Entry(newEntrySubject, newEntryBody);
    assertEquals(newEntry.getId(), (entryCountBeforeInstantiation + 1));
    assertEquals(newEntry.getEntrySubject(), newEntrySubject);
    assertEquals(newEntry.getEntryBody(), newEntryBody);
    assertEquals(Entry.getEntryCount(), (entryCountBeforeInstantiation + 1));
  }
  
  @Test 
  public void testDiaryExists(){
    assertTrue(Diary.isExist());
  }
  
  @Test
  public void testDiaryConstructorCreatesANewDiary(){
    int diaryCountBeforeInstantiation = Diary.getDiaryCount();
    String diaryName = "Business";
    Diary newDiary = new Diary(diaryName);
    assertEquals(newDiary.getName(), diaryName);
    assertEquals(newDiary.getEntries(), new ArrayList<Entry>());
    assertEquals(newDiary.getDiaryCount(), (diaryCountBeforeInstantiation + 1));
  }
  
  @Test
  public void testDiaryCanNotAddEntryWhenLocked(){
    String diaryName = "Personal Reflection";
    Diary newDiary = new Diary(diaryName);
    String subject = "Time and Money";
    String body = "I think money or its abstraction should be a fundamental quantity like mass and time";
    assertFalse(newDiary.addEntry(subject, body));    
  }
  
  @Test
  public void testDiaryCanAddEntryWhenUnlocked(){
    String diaryName = "Personal Reflection";
    Diary newDiary = new Diary(diaryName);
    String subject = "Time and Money";
    String body = "I think money or its abstraction should be a fundamental quantity like mass and time";
    newDiary.unlock();
    assertTrue(newDiary.addEntry(subject, body));    
  }
  
  @Test
  public void testDiaryCanFindEntryById(){
    Entry actual = findEntryById(1);
    assertNotNull(actual);
  }
  
  
  
  
}
