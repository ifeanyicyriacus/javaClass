import java.util.Scanner;
public class TextSearch{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word to search our array: ");
		String testValue = input.next();
		String[] daysOfWeek = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
		
		boolean result = false;
		for(int index = 0; index < daysOfWeek.length; index += 1){
		  if (daysOfWeek[index].equals(testValue.toUpperCase())){
		    result = true;}
		}
		System.out.printf("%s %s%n", testValue, (result)?"is contained in the array.":"is not contained in the array.");
		
	}
}
