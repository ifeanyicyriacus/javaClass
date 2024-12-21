public class HugeInteger{
  private static final int SIZE = 40;
  private int[] number;
  public static boolean isExist(){ return true; }
  
  public HugeInteger(String number){
    setNumber(parse(number));
  }
  
  public static int[] parse(String numberStr){
    numberStr = numberStr.replace("_", "");
    int length = numberStr.length();
    int numberArraySize = SIZE;
    int[] newNumber = new int[numberArraySize];
    for (int index = (length - 1); index >= 0; index -= 1){
      int digit = Integer.valueOf(String.valueOf(numberStr.charAt(index)));
      newNumber[--numberArraySize] = digit;
    }
    return newNumber;
  }
  
  private int[] getNumber(){ return this.number; }
  
  private void setNumber(int[] number){
    if (number.length <= SIZE){
      this.number = number;
    }
  }
  
  public String toString(){
    int[] numberArray = this.getNumber();
    boolean isAllDigitZero = true;
    String result = "";
    for (int index = 0; index < numberArray.length; index += 1){
      if (numberArray[index] > 0 && isAllDigitZero){
        isAllDigitZero = false;
      }
      if(!isAllDigitZero){
        result += numberArray[index];
      }
    }
    return result;
  }
  
  public static HugeInteger add(HugeInteger number1, HugeInteger number2){
    String result = "";
    final int BASE_10 = 10;
    int[] number1Array = number1.getNumber();
    int[] number2Array = number2.getNumber();
    int carryOver = 0;
    for (int index = (SIZE - 1); index >= 0; index -= 1){
      int digitSum = carryOver + number1Array[index] + number2Array[index];
      carryOver = digitSum / BASE_10;
      digitSum = digitSum % 10;
      result = digitSum + result;
    }
    return new HugeInteger(result);
  }
  
  
  
  
  
  
  
}
