import java.util.Scanner;

public class GreatestNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int counter = 1;
		System.out.printf("Enter number %d: ", counter);
		double greatest = input.nextDouble(); 
		counter++;
		while(counter <= 3){
			System.out.printf("Enter number %d: ", counter);
			double number = input.nextDouble();
			if (number >= greatest){
				greatest = number;
			}
			counter++;
		}
		System.out.printf("The greatest is: %.2f%n", greatest);
	}
}
