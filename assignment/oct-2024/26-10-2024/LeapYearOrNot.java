import java.util.Scanner;
public class LeapYearOrNot{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input the year: ");
		int year = input.nextInt();
		
		if ((year % 4) == 0){
		  System.out.printf("%d is a leap year%n", year);
		} else{
			System.out.printf("%d is not a leap year%n", year);		
		}						
	}
}
