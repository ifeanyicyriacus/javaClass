import java.util.Scanner;
public class SumOfThreeNumbers{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1st number: ");
		float num1 = input.nextFloat();
		System.out.print("Enter 1st number: ");
		double num2 = input.nextDouble();
		System.out.print("Enter 1st number: ");
		int num3 = input.nextInt();
		
		double sum = num3 + num2 + num1;
		System.out.printf("The sum is: %.2f%n", sum);
	}
}

