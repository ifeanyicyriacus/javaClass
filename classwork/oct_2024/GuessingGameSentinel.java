import java.util.Scanner;
public class GuessingGameSentinel{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int correctNumber = 63;
	  int guess;
	  do{
		  System.out.print("Enter a number from (0-100): ");
		  guess = input.nextInt();
		  if (guess < correctNumber){
			  System.out.println("Your guess entered is too low");}
		  else if(guess > correctNumber){
			  System.out.println("Your guess entered is too high");}
		  else {
			  System.out.println("Correct guess");
		  }
		} while(!(guess == correctNumber));
		
	}
}
