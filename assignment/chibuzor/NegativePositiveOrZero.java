import java.util.Scanner;
public class NegativePositiveOrZero{
  public static void main(String[] args){
    int counter = 1;
    int positiveCount = 0;
    int negativeCount = 0;
    int zeroCount = 0;
    Scanner input = new Scanner(System.in);
    do {
      System.out.print("Enter the number: ");
      float number = input.nextFloat();
      if (number > 0) {positiveCount++;}
      else if (number < 0) {negativeCount++;}
      else {zeroCount++;}
      counter++;
    } while (counter <= 5);
    System.out.printf("Positive numbers: %d%nNegative numbers: %d%nZeros: %d%n", positiveCount, negativeCount, zeroCount);
  }
}
