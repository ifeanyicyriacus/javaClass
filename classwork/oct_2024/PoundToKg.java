import java.util.Scanner;
public class PoundToKg{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter weight in pound: ");
		float weightInPound = input.nextFloat();
		double weightInKg = weightInPound * 0.454;
		System.out.printf("%.2f pounds is %.2f kilograms%n", weightInPound, weightInKg);
		
	}
}
