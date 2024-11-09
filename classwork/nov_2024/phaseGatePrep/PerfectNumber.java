import java.util.Scanner;
public class PerfectNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number to check if it is a perfect number: ");
		int number = input.nextInt();
		int sumOfMultiples = 0;
		for(int counter = 1; counter < number; counter += 1){
			if(number % counter == 0){
				sumOfMultiples += counter;
			}
		}
		
		if(sumOfMultiples == number){
			System.out.printf("(%d) is a perfect number%n", number);
		} else {
			System.out.printf("(%d) is not a perfect number%n", number);
		}
		
		
		
	}
}
