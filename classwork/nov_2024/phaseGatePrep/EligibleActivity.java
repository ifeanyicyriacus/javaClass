import java.util.Scanner;
public class EligibleActivity{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your age, to determine the activity you can partake in: ");
		int age = input.nextInt();
		
		if(age < 16){
			System.out.println("You may not partake in any activity");
		}else if(age < 18){
			System.out.println("You may only partake in only driving");
		}else if(age < 21){
			System.out.println("You may only partake in both driving and voting");
		}else {
			System.out.println("You are eligible to partake in driving, voting and drinking activity");
		}
		
	}
}
