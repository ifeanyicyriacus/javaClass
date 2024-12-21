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
    setEntrySubject(entrySubject);
    setEntryBody(entryBody);
    setTimeStamp();
  }
  
  public int getId(){ return this.id; }
  public static int getEntryCount(){ return entryCount; }
  
  public String getEntrySubject(){ return this.entrySubject; }
  public void setEntrySubject(String entrySubject){ this.entrySubject = entrySubject; }
  
  public String getEntryBody(){ return this.entryBody; }
  public void setEntryBody(String entryBody){ this.entryBody = entryBody; }
  
  public String getTimeStamp(){ return this.timeStamp.toString(); }
  private void setTimeStamp(){ this.timeStamp = new Date(); }
  
  
  
  public String toString(){
    String entry = String.format("\033[1m(%2d)\t%s\033[0m%n", getId(), getEntrySubject());
    entry += String.format("\033[3m%s\033[0m%n", getTimeStamp());
    entry += String.format("%s", getEntryBody());
    return entry;
  }
}
