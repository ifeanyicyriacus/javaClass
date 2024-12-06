public class CreditCardValidator{
  public static boolean isExist(){return true;}
  public static void main(String[] args){ 
  
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
    if (cardNumber.startsWith("4")){ return "Visa";}
    else if (cardNumber.startsWith("5")){ return "MasterCard";}
    else if (cardNumber.startsWith("37")){ return "American Express";}
    else if (cardNumber.startsWith("6")){ return "Discover";}
    else return "";
  }
  public static int sumDigitsInTwoDigitNumber(int number){
    return ((number / 10) + (number % 10));
  }
  public static boolean isNumberDivisibleBy10(int number){
    return (number % 10 == 0);
  }

}
