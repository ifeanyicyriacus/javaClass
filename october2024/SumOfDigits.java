import java.util.Scanner;
public class SumOfDigits{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer between 0 and 1000: ");
    int number = input.nextInt();
    
    int hundreds = number / 100;
    int tens = ((number / 10) % 10);
    int units = (number % 10);
    int sumOfDigits = hundreds + tens + units;
    
    System.out.printf("The sum of the digits is %d%n", sumOfDigits);
    
    
  }
}
