import java.util.Scanner;
public class IncreasingOrDecreasingSentinel{
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
	  
	  double number1 = 0;
	  double number2 = 0;
	  double number3 = 0;
	  while(!(number1 == -1 || number2 == -1 || number3 == -1)){
	    System.out.print("Enter number: ");
      number1 = input.nextDouble();
	    System.out.print("Enter another number: ");
      number2 = input.nextDouble();
	    System.out.print("Enter another number: ");
      number3 = input.nextDouble();
	  

	    if (number1 > number2 && number2 > number3){
	      System.out.println("Numbers are arranged in decreasing order");
	    } else if (number1 < number2 && number2 < number3){
	      System.out.println("Numbers are arranged in increasing order");
	    } else {
	      System.out.println("Numbers are in no particular order");
	    }
	  }
	}
}
