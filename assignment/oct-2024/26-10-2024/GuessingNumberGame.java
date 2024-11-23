import java.util.Scanner;
public class GuessingNumberGame{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int targetNumber = (int)(Math.random() *100);
		int guess;
		System.out.print("Guess a number from 0-100: ");
		do{
			guess = input.nextInt();
			if (guess > targetNumber){
				System.out.print("Too high, try again: ");
			} else if (guess < targetNumber){
				System.out.print("Too low, try again: ");
			} else {
				System.out.println("Correct guess.");
			}
		} while (guess != targetNumber);		
	}
}
