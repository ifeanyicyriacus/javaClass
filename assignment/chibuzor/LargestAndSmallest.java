import java.util.Scanner;
public class LargestAndSmallest{
	public static void main(String[] args){
		float largestNumber = 0;
		float smallestNumber = 0;
		String response = "";
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter number: ");
			float number = input.nextFloat();
			if (largestNumber == 0 && smallestNumber == 0){
			  largestNumber = number;
			  smallestNumber = number;
			}
			if (number > largestNumber) {largestNumber = number;}
			if (number < smallestNumber) {smallestNumber = number;}
			System.out.print("Do you want to continue (y/n): ");
			response = input.next();
			
		} while(response.equals("y"));
		System.out.printf("The largest number is: %.2f%nThe smallest number is: %.2f%n",largestNumber, smallestNumber);
	}
}
