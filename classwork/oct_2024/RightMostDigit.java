import java.util.Scanner;
public class RightMostDigit{
	public static void main(String ... args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the first number: ");
		int number1 = input.nextInt() % 10;
		System.out.print("Input the first number: ");
		int number2 = input.nextInt() % 10;
		System.out.print("Input the first number: ");
		int number3 = input.nextInt() % 10;
		
		if(((number1 == number2) || ((number2 == number3) || (number3 == number1))){
			System.out.println("The Result is: true");
		}else {System.out.println("The Result is: false");}
	}
}
