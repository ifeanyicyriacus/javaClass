import java.util.Scanner;
public class TemperatureCalculator{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your the temperature in celcius: ");
		double temperatureInCelcius = input.nextDouble();
		
		if(temperatureInCelcius < 10){
			System.out.println("Cold");
		}else if(temperatureInCelcius <= 25){
			System.out.println("warm");
		}else {
			System.out.println("Hot");
		}
		
	}
}
