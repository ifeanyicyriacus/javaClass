import java.util.Scanner;
public class BodyMassIndex{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter weight (in pounds): ");
		float weightInPound = input.nextFloat();
		System.out.print("Enter height (in inches): ");
		float heightInInch = input.nextFloat();
		double weightInKg = weightInPound * 0.45359237;
		double heightInMetre = heightInInch * 0.0254;
		double bmi = weightInKg / (Math.pow(heightInMetre,2));
		System.out.printf("The BMI is: %f%n", bmi);
	}
}
