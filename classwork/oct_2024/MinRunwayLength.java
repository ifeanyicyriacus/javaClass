import java.util.Scanner;
public class MinRunwayLength{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the airplane acceleration in (m/s^2): ");
		float acceleration = input.nextFloat(); 
		System.out.print("Enter the take off speed of the airplane in (m/s): ");
		float velocity = input.nextFloat();
		double minRunwayLength = Math.pow(acceleration, 2) / (2 * velocity);
		System.out.printf("The minimum runway length is: %.2f metres.%n", minRunwayLength);
	}
}
