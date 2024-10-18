import java.util.Scanner;
/** Tests if a 3 digit number is a palindrome
*@author Ifeanyi Cyriacus
*/
public class ThreeDigitPalindromeTest{
  /**
  *@param args
  *@return void
  */
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a three digit number: ");
    /*
    for a three digit Palindrome i only need to test the first and last digit. when the first and second digits are not zero*/
    int number = input.nextInt();
    int hundreds = number / 100;//first digit
    int units = number % 10;//last digit
    
    if (hundreds == units){
      System.out.printf("%d is a palindrome%n", number);
    }else{
      System.out.printf("%d is not a palindrome%n", number);
    }  
  }
}
