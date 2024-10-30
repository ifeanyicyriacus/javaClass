import java.util.Scanner;
public class IncreasingOrDecreasingCounter{
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);

	  int counter = 3;
	  while(counter != 0){
	    System.out.print("Enter number: ");
      double number1 = input.nextDouble();
	    System.out.print("Enter another number: ");
      double number2 = input.nextDouble();
	    System.out.print("Enter another number: ");
      double number3 = input.nextDouble();
	  

	    if (number1 > number2 && number2 > number3){
	      System.out.println("Numbers are arranged in decreasing order");
	    } else if (number1 < number2 && number2 < number3){
	      System.out.println("Numbers are arranged in increasing order");
	    } else {
	      System.out.println("Numbers are in no particular order");
	    }
	    counter -= 1;
	  }
	}
}
