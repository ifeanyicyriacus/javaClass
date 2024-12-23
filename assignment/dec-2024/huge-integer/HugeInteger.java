public class HugeInteger{
  private static final int HUGE_INTEGER_SIZE = 40;
  private int[] number;
  public static boolean isExist(){ return true; }
  
  public HugeInteger(String number){
    setNumber(parse(number));
  }
  
  public static int[] parse(String numberStr){
    numberStr = numberStr.replace("_", "");
    int length = numberStr.length();
    int numberArraySize = HUGE_INTEGER_SIZE;
    int[] newNumber = new int[numberArraySize];
    for (int index = (length - 1); index >= 0; index -= 1){
      int digit = Integer.valueOf(String.valueOf(numberStr.charAt(index)));
      newNumber[--numberArraySize] = digit;
    }
    return newNumber;
  }
  
  private int[] getNumber(){ return this.number; }
  
  private void setNumber(int[] number){
    if (number.length <= HUGE_INTEGER_SIZE){
      this.number = number;
    }
  }
  
  public String toString(){
    int[] numberArray = this.getNumber();
    boolean isAllDigitZero = true;
    String result = "";
    for (int index = 0; index < numberArray.length; index += 1){
      //if (numberArray[index] > 0 && isAllDigitZero){
      if (numberArray[index] != 0 && isAllDigitZero){//to cater for negative numbers
        isAllDigitZero = false;
      }
      if(!isAllDigitZero){
        result += numberArray[index];
      }
    }
    return (result.equals("")) ? "0": result;
  }
  
  public static HugeInteger add(HugeInteger number1, HugeInteger number2){
    String result = "";
    final int BASE_10 = 10;
    int[] number1Array = number1.getNumber();
    int[] number2Array = number2.getNumber();
    int carryOver = 0;
    for (int index = (HUGE_INTEGER_SIZE - 1); index >= 0; index -= 1){
      int digitSum = carryOver + number1Array[index] + number2Array[index];
      carryOver = digitSum / BASE_10;
      digitSum = digitSum % BASE_10;
      result = digitSum + result;
    }
    return new HugeInteger(result);
  }
  
  public static HugeInteger subtract(HugeInteger number1, HugeInteger number2){
    String result = "";
    final int BASE_10 = 10;
    int[] number1Array = number1.getNumber();
    int[] number2Array = number2.getNumber();
    int carryOver = 0;
    
    //do this basic substraction when number1 is greater or equal to number2
    //after i have completed the comparison function i could then compare two BigInt numbers
    //if(number1.isGreaterThanOrEqualTo(number2))
    //else swap and multiply the first digit by -1
    
    for (int index = (HUGE_INTEGER_SIZE - 1); index >= 0; index -= 1){
      int digit1 = (carryOver + number1Array[index]);
      int digit2 = number2Array[index];
      int digitDifference;

      if (digit1 >= digit2){
        digitDifference = digit1 - digit2;
        carryOver = 0;
      } else {
        digit1 += BASE_10; 
        carryOver = -1;
        digitDifference = digit1 - digit2;
      }
      result = digitDifference + result;
    }
    return new HugeInteger(result);
  }

  public boolean isEqualTo(HugeInteger alternativeNumber){
  HugeInteger difference = subtract(this, alternativeNumber);
    if (difference.toString().equals("0")){
      return true;
    }
    else {
      return false;
    }
  }
  
  public boolean isNotEqualTo(HugeInteger alternativeNumber){
    return !(isEqualTo(alternativeNumber));  
  }
  
  
}
