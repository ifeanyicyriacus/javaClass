import java.util.Scanner;
public class MaximumNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		double number1 = input.nextInt();
		System.out.print("Enter number 2: ");
		double number2 = input.nextInt();
		System.out.print("Enter number 3: ");
		double number3 = input.nextInt();
		double maximum = number1;
		if (maximum < number2){
			maximum = number2;}
			
		if (maximum < number3){
			maximum = number3;
		}
		System.out.printf("The maximum number is: %.2f%n", maximum);
	}
}
