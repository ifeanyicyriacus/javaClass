import java.util.Scanner;
public class TwoNumberSum{
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		String choice = "n";
		do{
			System.out.print("Enter number 1: ");
			double number1 = input.nextDouble();
			System.out.print("Enter number 2: ");
			double number2 = input.nextDouble();
			double sum = number1 + number2;
			System.out.printf("Their sum is: %.2f%n", sum);
			
			System.out.print("Do you still wish to repeat this operation (y/n)? ");
			choice = input.next();
			
		} while (choice.toLowerCase().equals("y"));
	}
}
