import java.util.Scanner;
public class HighestCommonFactor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Highest Common Factor calculator");
		System.out.print("Enter the first number: ");
		int number1 = input.nextInt(); 
		System.out.print("Enter the second number: ");
		int number2 = input.nextInt(); 
		
		int hcm=1;
		int lowerNumber = number1;
		if (number2 < lowerNumber){lowerNumber = number2;}
		for (int count = 1; count <= lowerNumber; count += 1){
			if(number1 % count == 0 && number2 % count == 0){
				hcm = count;
			}
		}
		System.out.printf("The highest common multiple of (%d) and (%d) is: %d%n", number1, number2, hcm);
	}
}
