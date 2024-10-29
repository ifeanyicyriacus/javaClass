import java.util.Scanner;
public class NegativeZeroAndPositive{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		  int positiveCount = 0; int negativeCount = 0; int zeroCount = 0;
		  
		  int counter = 1;
		  while (counter <= 3){
		    System.out.printf("Enter number %d: ", counter);
		    double number = input.nextDouble();
		    if (number > 0){positiveCount += 1;}
		    else if (number < 0){negativeCount += 1;}
		    else {zeroCount += 1;}
		    counter += 1;
		  }
      System.out.printf("The number of positives are: %d%n", positiveCount);
      System.out.printf("The number of negatives are: %d%n", negativeCount);
      System.out.printf("The number of zeros are: %d%n", zeroCount);
	}
}
