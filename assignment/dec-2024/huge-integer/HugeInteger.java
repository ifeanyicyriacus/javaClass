public class HugeInteger{
  private int[] number;
  public static boolean isExist(){ return true; }
  
  public HugeInteger(String number){
    setNumber(parse(number));
  }
  
  public static int[] parse(String numberStr){
    numberStr = numberStr.replace("_", "");
    int length = numberStr.length();
    int numberArraySize = 40;
    int[] newNumber = new int[numberArraySize];
    for (int index = (length - 1); index >= 0; index -= 1){
      int digit = Integer.valueOf(String.valueOf(numberStr.charAt(index)));
      newNumber[--numberArraySize] = digit;
    }
    return newNumber;
  }
  
  private int[] getNumber(){ return this.number; }
  
  private void setNumber(int[] number){
    if (number.length <= 40){
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
  
  
  
  
  
  
  
  
  
}
