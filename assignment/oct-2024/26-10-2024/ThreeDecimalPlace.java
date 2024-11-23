import java.util.Scanner;
public class ThreeDecimalPlace{
	public static void main(String... args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input floating-point number: ");
		double number1 = input.nextDouble();
		System.out.print("Input another floating-point number: ");
		double number2 = input.nextDouble();
		
		double difference = Math.abs(Math.max(number1, number2) - Math.min(number1, number2));
		if (difference < 0.001){
			System.out.println("They are the same");
		} else {
			System.out.println("They are different");
		}	
	}
}
