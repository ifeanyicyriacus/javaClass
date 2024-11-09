import java.util.Scanner;
public class SumOfAllDigitInNumber{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a positive integer: ");
    int number = input.nextInt();
    
    int cropA = 10;
    int cropB = 1;
    int sumOfAllDigitInNumber = 0;
    
    while((number/cropB) > 0 ){
      int digit = (number%cropA)/cropB;
      sumOfAllDigitInNumber += digit;
      
      cropA *= 10;
      cropB *= 10;
    }
    System.out.printf("The sum of all the digit is: %d%n", sumOfAllDigitInNumber);
    
  }
}
