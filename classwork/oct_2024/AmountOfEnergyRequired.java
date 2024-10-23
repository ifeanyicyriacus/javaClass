import java.util.Scanner;
public class AmountOfEnergyRequired{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the amount of water to heat (in Kg): ");
		float weightOfWater = input.nextFloat();
		System.out.print("Enter the initial temperature (in celcius): ");
		float initTemp = input.nextFloat();
		System.out.print("Enter the final temperature (in celcius): ");
		float finalTemp = input.nextFloat();
		double energyRequired = weightOfWater * (finalTemp - initTemp) * 4184;
		System.out.printf("The energy required the heat %.2fKg of water from (%.2f - %.2f) degree celcius is: %.2fjoules.%n", weightOfWater, initTemp, finalTemp, energyRequired);
	}
}
