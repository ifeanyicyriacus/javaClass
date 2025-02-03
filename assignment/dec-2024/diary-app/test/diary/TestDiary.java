package diary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestDiary {
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
  public void testThatYouCanNotAddToEntryWhenDiaryIsLocked(){
    String diaryName = "Personal Reflection";
    Diary newDiary = new Diary(diaryName);
    String subject = "Time and Money";
    String body = "I think money or its abstraction should be a fundamental quantity like mass and time";
    assertNull(newDiary.addEntry(subject, body));    
  }
  
  @Test
  public void testThatYouCanAddToEntryWhenDiaryIsUnlocked(){
    String diaryName = "Personal Reflection";
    Diary newDiary = new Diary(diaryName);
    String subject = "Time and Money";
    String body = "I think money or its abstraction should be a fundamental quantity like mass and time";
    newDiary.setIsLocked(false);
    newDiary.addEntry(subject, body);
    newDiary.addEntry(subject, body);
    assertNotNull(newDiary.addEntry(subject, body));
    assertEquals(newDiary.getEntries().size(), 3);
  }
  
  @Test
  public void testThatFindEntryByIdReturnsCorrectValue(){
    String diaryName = "Dietel Old Testament";
    Diary newDiary = new Diary(diaryName);
    newDiary.setIsLocked(false);
    
    Entry actual1 = newDiary.addEntry("Mathematics", "What you cant measure dont exist");
    Entry actual2 = newDiary.addEntry("Computer Science", "It all boils down to zeros(0) and Ones(1)");
    Entry expected1 = newDiary.findEntryById(actual1.getId());
    Entry expected2 = newDiary.findEntryById(actual2.getId());
    assertEquals(actual1, expected1);
    assertEquals(actual2, expected2);    
  }
  
  @Test
  public void testThatDeleteEntryWorks(){
    String diaryName = "Movie Collection";
    Diary newDiary = new Diary(diaryName);
    newDiary.setIsLocked(false);
    
    Entry entry1 = newDiary.addEntry("Kevin Hart", "JUMANJI Director cut");
    Entry entry2 = newDiary.addEntry("Chris Rock", "Everybody loves Chris");
    int noOfEntriesBeforeDeletion = newDiary.getEntries().size();
    
    newDiary.deleteEntry(newDiary.findEntryById(entry1.getId()));
    newDiary.deleteEntry(newDiary.findEntryById(entry2.getId()));
    int noOfEntriesAfterDeletion = newDiary.getEntries().size();
    
    assertNotEquals(noOfEntriesBeforeDeletion, noOfEntriesAfterDeletion);
    assertEquals((noOfEntriesBeforeDeletion - 2), noOfEntriesAfterDeletion);
  }
  
  @Test
  public void testThatUpdateEntryReturnsCorrectvalue(){
    String diaryName = "Favourite Movies";
    Diary newDiary = new Diary(diaryName);
    newDiary.setIsLocked(false);
    
    Entry entry1 = newDiary.addEntry("Christmas movie", "It's A Wonderful Life");  
    assertEquals(entry1.getEntryBody(), "It's A Wonderful Life");
    Entry updatedEntry1 = newDiary.updateEntry(entry1, "Christmas movie", "Die Hard");
    
    assertEquals(entry1, updatedEntry1);
    assertEquals(entry1.getEntryBody(), "Die Hard");
  }
  
}
