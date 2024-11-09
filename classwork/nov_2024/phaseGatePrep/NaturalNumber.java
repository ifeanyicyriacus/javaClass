import java.util.Scanner;
public class NaturalNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a natural number: ");
		int number = input.nextInt();
		
		while(number > 0){
			System.out.printf("%d, ", number);
			number -= 1;
		}
		
	}
}
