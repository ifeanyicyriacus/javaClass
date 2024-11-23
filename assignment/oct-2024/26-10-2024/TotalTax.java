import java.util.Scanner;
public class TotalTax{
	public static void main(String[] args){
		int EARNING_CEILING = 30000;
		double NORMAL_TAX_RATE = 15.0 / 100.0;
		double EXCESS_TAX_RATE = 20.0 / 100.0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your total earnings: ");
		double earnings = input.nextDouble();
		double excessEarnings = earnings - EARNING_CEILING;
		double totalTax = 0;
		
		if (excessEarnings <= 0){
			totalTax = earnings * NORMAL_TAX_RATE;
		} else {
			totalTax = EARNING_CEILING * NORMAL_TAX_RATE;
			totalTax += (excessEarnings * EXCESS_TAX_RATE);
		}
		System.out.printf("The total tax payable: %f%n",totalTax);
	}
}
