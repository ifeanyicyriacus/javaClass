import java.util.Scanner;
public class NegativeZeroAndPositiveSentinel{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	  
	    int counter = 1;
	    System.out.printf("Enter number %d  (enter -1 to quit): ", counter);
	    double number = input.nextDouble();
	    counter += 1;
	    
	    while (number != -100){
	      System.out.printf("Enter number %d  (enter -100 to quit): ", counter);
	      number = input.nextDouble();
	      if (number > 0){positiveCount += 1;}
	      else if (number < 0){negativeCount += 1;}
	      else {zeroCount += 1;}
	      
	      if (counter % 3 == 0){
          System.out.printf("The number of positives are: %d%n", positiveCount);
          System.out.printf("The number of negatives are: %d%n", negativeCount);
          System.out.printf("The number of zeros are: %d%n", zeroCount);
          counter = 1;
          positiveCount = 0; negativeCount = 0; zeroCount = 0;
        }else{counter += 1;}
	      
      }
	}
}
