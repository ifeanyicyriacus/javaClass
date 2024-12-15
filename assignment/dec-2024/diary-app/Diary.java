import java.util.ArrayList;

public class Diary{
  public static boolean isExist(){ return true; }
  
  private String name;
  private ArrayList<Entry> entries;
  private boolean islocked;
  
  public Diary(String name){
    
    
  }
  
  public String getName(){ return this.name; }
  public boolean getIsLocked(){ return this.islocked; }
  public ArrayList<Entry> getEntries(){ return this.entries; }
  
  public void setName(){}
  private void setIsLocked(boolean status){ this.islocked = status; }
  
  public void unlock(){}
  public void lock(){}
  
  private
  public String toString(){}

}
