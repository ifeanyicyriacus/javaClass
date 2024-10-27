import java.util.Scanner;
public class LargestSmallestNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		int largest = number;
		int smallest = number;
		System.out.print("Enter a number: ");
	  System.out.print(" or press (<ctrl> + d) to exit: ");
		while (input.hasNext()) {
			System.out.print("Enter another number: ");
			number = input.nextInt();
			if (number > largest){
				largest = number;
			} else if (number < smallest) {
				smallest = number;
			}
		}
		
		System.out.printf("%nLargest: %d%n", largest);
		System.out.printf("Smallest: %d%n", smallest);		
	}
}
