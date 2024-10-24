import java.util.Scanner;

public class PositiveNegative{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input the number: ");
		int number = input.nextInt();
		
		if (number > 0){
			System.out.println("Number is positive");
		}else{
			System.out.println("Number is not positive");
		}
	}
}
