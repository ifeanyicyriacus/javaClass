import java.util.Scanner;
public class SmallMultiplicationTable{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	  System.out.print("Input the number (Table to be calculated): ");
		int number = input.nextInt();
		System.out.print("Input number of terms: ");
		int terms = input.nextInt();
		
		int counter = 0;
		while (counter <= terms){
			System.out.printf("%d X %d = %d%n", number, counter, (number*counter));
			counter++;
		}
	}
}
