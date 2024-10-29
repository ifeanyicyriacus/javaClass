import java.util.Scanner;
public class ThreeNumberEquality{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number1: ");
		int number1 = input.nextInt();
		System.out.print("Enter number2: ");
		int number2 = input.nextInt();
		System.out.print("Enter number3: ");
		int number3 = input.nextInt();
		
		if(number1 == number2 && number1 == number3 && number2 == number3){
			System.out.println("All three numbers are equal");
		} else
			System.out.println("All three numbers are not equal");
		
	}
}
