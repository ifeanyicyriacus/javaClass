import java.util.Random;
import java.util.Scanner;
public class GuessingGameSentinelRandom{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int correctNumber = random.nextInt(100);
	  int guess;
	  do{
		  System.out.print("Enter a number from (0-100): ");
		  guess = input.nextInt();
		  if (guess < correctNumber){
			  System.out.println("Your guess entered is too low");}
		  else if(guess > correctNumber){
			  System.out.println("Your guess entered is too high");}
		  else {
			  System.out.println("🥳Correct guess🏆🏆🏆");
		  }
		} while(!(guess == correctNumber));
		
	}
}
