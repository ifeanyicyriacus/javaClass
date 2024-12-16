import java.util.ArrayList;

public class Diary{
  public static boolean isExist(){ return true; }
  private static int diaryCount = 0;
  
  private String name;
  private ArrayList<Entry> entries;
  private boolean islocked;
  
  public Diary(String name){
    this.setName(name);
    this.entries = new ArrayList<Entry>();
    this.lock();
    diaryCount += 1;
  }
  
  public String getName(){ return this.name; }
  public boolean getIsLocked(){ return this.islocked; }
  public ArrayList<Entry> getEntries(){ return this.entries; }
  public static int getDiaryCount(){ return diaryCount; }
  
  public void unlock(){ this.islocked = false; }
  public void lock(){ this.islocked = true; }
  public void setName(String name){ this.name = name; }
  
  public boolean addEntry(String entrySubject, String entryBody){
    if (getIsLocked()){ return false; }
    else {
      Entry newEntry = new Entry(entrySubject, entryBody);
      return this.entries.add(newEntry);
    }
  }

  public boolean updateEntry(Entry entry, String entrySubject, String entryBody){
    //access the Arraylist
    return false;
  }
  
  public boolean deleteEntry(Entry entry){
    //access the array list
    //entries.remove(entry)
    return false;
  }
  
  public Entry findEntryById(int id){
    for(Entry entry : getEntries()){
      if ( entry.getId() == id ){
        return entry;
      }
    }
    return null;
  }
  
  
  
  
  
  
  
  private String toStringHelper(){ return ""; }
  public String toString(){ return ""; }

}
