import java.util.Scanner;
public class TextSearchIndex{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word to search our array for its index: ");
		String testValue = input.next();
		String[] daysOfWeek = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
		
		boolean result = false; String wordIndex = "";
		for(int index = 0; index < daysOfWeek.length; index += 1){
		  if (daysOfWeek[index].equals(testValue.toUpperCase())){
		    wordIndex += index;
		    result = true;
		    break;
		    }
		}
		System.out.printf("%s %s %s%n", testValue, 
		(result)?"is found in the array at index: ":"is not found in the array.",
		(result)? wordIndex:"");
		
	}
}
