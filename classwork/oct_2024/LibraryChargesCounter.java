import java.util.Scanner;
public class LibraryChargesCounter{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int counter = 3;
		while(counter != 0){
			System.out.print("Enter the number of days (after duedate) it took to return the book: ");
			int numberOfDays = input.nextInt();
			if (numberOfDays >= 30){
				System.out.println("The member's membership will be cancelled");}
			else if (numberOfDays >= 10){
				System.out.println("The member should be fined 5 rupees");}
			else if (numberOfDays >= 6){
				System.out.println("The member should be fined 1 rupee");}
			else if (numberOfDays == 5){
				System.out.println("The member should be fined 50 paise");}
			else {
				System.out.println("The member should not be fined");}	
			counter -= 1;
		}
	}
}
