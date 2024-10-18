import java.util.Scanner;
public class ThreeDigitPalindromeTest{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a three digit number: ");
    int number = input.nextInt();
    int hundreds = number / 100;
    int units = number % 10;
    
    if (hundreds == units){
      System.out.printf("%d is a palindrome%n", number);
    }else{
      System.out.printf("%d is not a palindrome%n", number);
    }  
  }
}
