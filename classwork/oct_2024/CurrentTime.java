import java.time.LocalDateTime;
public class CurrentTime{
	public static void main(String[] args){
		String dayOfWeek = LocalDateTime.now().getDayOfWeek().toString().substring(0,3);
		int dayOfMonth = LocalDateTime.now().getDayOfMonth();
		String monthOfYear = LocalDateTime.now().getMonth().toString().substring(0,3);
		int year = LocalDateTime.now().getYear();
		int hrs = LocalDateTime.now().getHour();
		int min = LocalDateTime.now().getMinute();
		int sec = LocalDateTime.now().getSecond();
		System.out.printf("%s %d %s, %d %d:%d:%d%n", dayOfWeek, dayOfMonth, monthOfYear, year, hrs, min, sec);
	}
}

