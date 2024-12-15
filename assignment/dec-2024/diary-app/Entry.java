import java.util.Date;

public class Entry{
  public static boolean isExist(){ return true; }
  
  private static int entryCount = 0;
  private final int id;
  private String entrySubject;
  private String entryBody;
  private Date timeStamp;
  
  public Entry(String entrySubject, String entryBody){
    this.id = ++entryCount;
    this.setEntrySubject(entrySubject);
    this.setEntryBody(entryBody);
  }
  
  public int getId(){ return this.id; }
  public String getEntrySubject(){ return this.entrySubject; }
  public String getEntryBody(){ return this.entryBody; }
  public String getTimeStamp(){ return this.timeStamp.toString(); }
  public static int getEntryCount(){ return entryCount; }
  
  private void setTimeStamp(){ this.timeStamp = new Date(); }
  public void setEntrySubject(String entrySubject){ this.entrySubject = entrySubject; }
  public void setEntryBody(String entryBody){
    this.entryBody = entryBody;
    this.setTimeStamp();
  }
  
  public String toString(){
    String entry = String.format("\033[(%2d)\t%s\033[0m%n", getId(), getEntrySubject());
    entry += String.format("\033[3m%s\033[0m%n", getTimeStamp());
    entry += String.format("%s", getEntryBody());
    return entry;
  }
}
