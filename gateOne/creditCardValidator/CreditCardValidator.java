public class CreditCardValidator{
  public static boolean isExist(){return true;}
  public static void main(String[] args){ 
  
  }
  
  
  public static int getSumOfEvenPlacedDigit(int cardNumber){
    String number = ""+cardNumber;
    sum = 0;
    for(int index = (number.length() - 2); index < 0 ; index -= 2){
      int digit = Integer.valueOf(number.substring(index, index+1));
      int digitDoubled = digit * 2;
      sum += (digitDoubled >= 10)?sumDigitsInTwoDigitNumber(digitDoubled):digitDoubled
    }
    return sum;  
  }
  
  public static int getSumOfOddPlacedDigit(int cardNumber){
    String number = ""+cardNumber;
    sum = 0;
    for(int index = (number.length() - 1); index < 0 ; index -= 2){
      int digit = Integer.valueOf(number.substring(index, index+1));
      sum += digit;
    }
    return sum;
  }
  
  public static boolean isNumberCombinationCorrect(int cardNumber){
    int sumOfOddPlacedDigit = getSumOfOddPlacedDigit(cardNumber);
    int sumOfEvenPlacedDigit = getSumOfEvenPlacedDigit(cardNumber);
    int sum = sumOfOddPlacedDigit + sumOfEvenPlacedDigit;
    return isNumberDivisibleBy10(sum);
  }
  
  
  public static boolean isLengthValid(int cardNumber){
    String number = ""+cardNumber;
    return (number.length() >= 13) && (number.length() <= 16);
  }
  public static String returnCardType(int cardNumber){
    String number = ""+cardNumber;
    if (number.startsWith("4")){ return "Visa";}
    else if (number.startsWith("5")){ return "MasterCard";}
    else if (number.startsWith("37")){ return "American Express";}
    else if (number.startsWith("6")){ return "Discover";}
  }
  public static int sumDigitsInTwoDigitNumber(int number){
    return ((number / 10) + (number % 10));
  }
  public static boolean isNumberDivisibleBy10(int number){
    return (number % 10 == 0);
  }

}
