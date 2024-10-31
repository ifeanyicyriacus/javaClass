import java.util.Scanner;
public class GuessingGame{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int correctNumber = 63;
		System.out.print("Enter a number from (0-100): ");
		int guess = input.nextInt();
		
		if (guess < correctNumber){
			System.out.println("Your guess entered is too low");}
		else if(guess > correctNumber){
			System.out.println("Your guess entered is too high");}
		else {
			System.out.println("Correct guess");
		}		
	}
}
