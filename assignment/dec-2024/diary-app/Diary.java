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
  //public void setEntries(ArrayList<Entry> entries){ this.entries = entries; }
  
  public Entry addEntry(String entrySubject, String entryBody){
    if (getIsLocked()){ return null; }
    else {
      Entry newEntry = new Entry(entrySubject, entryBody);
      this.entries.add(newEntry);
      return newEntry;
    }
  }

  public Entry findEntryById(int id){
    for(Entry entry : getEntries()){
      if ( entry.getId() == id ){
        return entry;
      }
    }
    return null;
  }
  
  public void deleteEntry(Entry entry){
    ArrayList<Entry> entries = getEntries();
    entries.remove(entry);
    //setEntries(entries);
  }
  
  public Entry updateEntry(Entry entry, String entrySubject, String entryBody){
    ArrayList<Entry> entries = getEntries();
    int index = entries.indexOf(entry);
    entries.get(index).setEntrySubject(entrySubject);
    entries.get(index).setEntryBody(entryBody);
    return entries.get(index);
  } 
  
  
  public String toString(){
    String diary = String.format("\033[Diary: %s\033[0m%n", getName());
    diary += displayDiariesEntries();
    return diary;
  }
  
  private String displayDiariesEntries(){
    String entries = "";
    for(Entry entry: getEntries()){
      entries += String.format("\033[(%2d)\t%s\033[0m%n", entry.getId(), entry.getEntrySubject());
      entries += String.format("\033[3m%s\033[0m%n", entry.getTimeStamp());
      entries += String.format("%s%n", entry.getEntryBody());
      entries += String.format("-----------------------------------------------------%n");
    }
    return entries;
  }
}
