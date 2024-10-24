import java.util.Scanner;
public class AccumulatedValue{
	public static void main(String ... args){
		int NO_OF_MONTH_IN_YEAR = 12;
		int PERCENTAGE = 100;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter investment amount: ");
		double investmentAmount = input.nextDouble();
		System.out.print("Enter interest rate: ");
		double interestRate = input.nextDouble() / (double)PERCENTAGE;
		System.out.print("Enter number of years: ");
		double noOfYears = input.nextDouble();
		double monthlyInterestRate = interestRate / ((double)NO_OF_MONTH_IN_YEAR);
		double noOfMonth = noOfYears * NO_OF_MONTH_IN_YEAR;
		double accumulatedValue = investmentAmount * Math.pow((1 + monthlyInterestRate), noOfMonth);
		
		System.out.printf("The accumulated value: %.2f%n", accumulatedValue);
		
	}
}
