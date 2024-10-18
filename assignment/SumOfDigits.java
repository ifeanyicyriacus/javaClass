import java.util.Scanner;
/** Calculates the sum of digits in an integer (between 0 - 1000)
*@author Ifeanyi Cyriacus
*/
public class SumOfDigits{
  /**
  *@param args
  *@return void
  */
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer between 0 and 1000: ");
    int number = input.nextInt();
    
    int hundreds = number / 100;//first digit
    int tens = ((number / 10) % 10);//second digit
    int units = (number % 10);//last digit
    int sumOfDigits = hundreds + tens + units;
    
    System.out.printf("The sum of the digits is %d%n", sumOfDigits);
    
    
  }
}
