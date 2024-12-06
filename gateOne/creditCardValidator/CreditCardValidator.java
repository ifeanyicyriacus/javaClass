import java.util.Scanner;

public class CreditCardValidator{
  public static boolean isExist(){return true;}
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Hello, kindly Enter Card details to verify");
    String cardNumber = input.next();
    
    String result = String.format("Credit Card Type: %s%n", returnCardType(cardNumber));
    result += String.format("Credit Card Number: %s%n", cardNumber);
    result += String.format("Credit Card Digit Length: %d%n", cardNumber.length());
    String cardStatus = (isNumberCombinationCorrect(cardNumber)) ? "Valid": "Invalid";
    result += String.format("Credit Card Validity Status: %s%n", cardStatus);
    System.out.print(result);
  }
  
  
  public static int getSumOfEvenPlacedDigitDoubled(String cardNumber){
    int sum = 0;
    for(int index = (cardNumber.length() - 2); index >= 0 ; index -= 2){
      String digitString = cardNumber.substring(index, index+1);
      int digit = Integer.valueOf(digitString);
      int digitDoubled = digit * 2;
      sum += (digitDoubled >= 10)?sumDigitsInTwoDigitNumber(digitDoubled):digitDoubled;
    }
    return sum;  
  }
  
  public static int getSumOfOddPlacedDigit(String cardNumber){
    int sum = 0;
    for(int index = (cardNumber.length() - 1); index >= 0 ; index -= 2){
      String digitString = cardNumber.substring(index, index+1);
      int digit = Integer.valueOf(digitString);
      sum += digit;
    }
    return sum;
  }
  
  public static boolean isNumberCombinationCorrect(String cardNumber){
    int sumOfOddPlacedDigit = getSumOfOddPlacedDigit(cardNumber);
    int sumOfEvenPlacedDigitDoubled = getSumOfEvenPlacedDigitDoubled(cardNumber);
    int sum = sumOfOddPlacedDigit + sumOfEvenPlacedDigitDoubled;
    return isNumberDivisibleBy10(sum);
  }
  
  public static boolean isLengthValid(String cardNumber){
    return (cardNumber.length() >= 13) && (cardNumber.length() <= 16);
  }
  public static String returnCardType(String cardNumber){
    if (cardNumber.startsWith("4")){ return "Visa Card";}
    else if (cardNumber.startsWith("5")){ return "MasterCard Card";}
    else if (cardNumber.startsWith("37")){ return "American Express Card";}
    else if (cardNumber.startsWith("6")){ return "Discover Card";}
    else return "Invalid Card";
  }
  public static int sumDigitsInTwoDigitNumber(int number){
    return ((number / 10) + (number % 10));
  }
  public static boolean isNumberDivisibleBy10(int number){
    return (number % 10 == 0);
  }

}
