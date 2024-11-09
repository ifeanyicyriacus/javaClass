import java.util.Scanner;
public class TaxRate{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your annual income: ");
		double annualIncome = input.nextDouble();
		
		if(annualIncome <= 9875){
			System.out.println("Your Tax bracket is 10%");
		}else if(annualIncome <= 40125){
			System.out.println("Your Tax bracket is 12%");
		}else if(annualIncome <= 85525){
			System.out.println("Your tax bracket is 22%");
		}else {
			System.out.println("Your tax bracket is 24%");
		}
		
	}
}
