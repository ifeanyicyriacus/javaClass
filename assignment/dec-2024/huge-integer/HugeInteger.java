public class HugeInteger{
  private static final int HUGE_INTEGER_SIZE = 40;
  private int[] number;
  private boolean isNegative;
  private int length;
  public static boolean isExist(){ return true; }
  
  public HugeInteger(String number){
    setNumber(parse(number));
  }
  
  public int[] parse(String numberStr){
    numberStr = numberStr.replace("_", "");
    if(numberStr.length() >= 1 && numberStr.substring(0,1).equals("-")){
      numberStr = numberStr.replace("-", "");
      setIsNegative(true);
    }
    
    int length = numberStr.length();
    setLength(length);
    int numberArraySize = HUGE_INTEGER_SIZE;
    int[] newNumber = new int[numberArraySize];
    for (int index = (getLength() - 1); index >= 0; index -= 1){
      int digit = Integer.valueOf(String.valueOf(numberStr.charAt(index)));
      newNumber[--numberArraySize] = digit;
    }
    return newNumber;
  }
  
  public int[] getNumber(){ return this.number; }
  private void setNumber(int[] number){
    if (number.length <= HUGE_INTEGER_SIZE){
      this.number = number;
    }
  }
  
  public boolean getIsNegative(){ return this.isNegative; }
  private void setIsNegative(boolean isNegative) { this.isNegative = isNegative; }

  public int getLength(){ return this.length; }
  private void setLength(int length){ this.length = length; }
  
  public String toString(){
    int[] numberArray = this.getNumber();
    boolean isAllDigitZero = true;
    String result = "";
    for (int index = 0; index < numberArray.length; index += 1){
      if (numberArray[index] != 0 && isAllDigitZero){
        isAllDigitZero = false;
      }
      if(!isAllDigitZero){
        result += numberArray[index];
      }
    }
    if (getIsNegative()){
      result = "-" + result;
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
    boolean isResultNegative = false;  
    if(number2.isGreaterThan(number1)){
      HugeInteger temp = number1;
      number1 = number2;
      number2 = temp;
      isResultNegative = true;
    }
    
    final int BASE_10 = 10;
    int[] number1Array = number1.getNumber();
    int[] number2Array = number2.getNumber();
    int borrow = 0;
    
    for (int index = (HUGE_INTEGER_SIZE - 1); index >= 0; index -= 1){
      int digit1 = (borrow + number1Array[index]);
      int digit2 = number2Array[index];
      int digitDifference;

      if (digit1 >= digit2){
        digitDifference = digit1 - digit2;
        borrow = 0;
      } else {
        digit1 += BASE_10; 
        borrow = -1;
        digitDifference = digit1 - digit2;
      }
      result = digitDifference + result;
    }
    result = (isResultNegative) ? ("-" + result) : result;
    return new HugeInteger(result);
  }

  public boolean isEqualTo(HugeInteger alternativeNumber){
    if (this.getIsNegative() != alternativeNumber.getIsNegative()) { return false; }
    if (this.getLength() != alternativeNumber.getLength()) { return false; }
    
    int[] numberArray = this.getNumber();
    int[] alternativeNumberArray = alternativeNumber.getNumber();
    for (int index = 0; index < HUGE_INTEGER_SIZE; index += 1) {
      if(numberArray[index] != alternativeNumberArray[index]) { return false; }
    } return true;
  }
  
  public boolean isNotEqualTo(HugeInteger alternativeNumber){
    return !(isEqualTo(alternativeNumber));
  }
  
  public boolean isGreaterThan(HugeInteger alternativeNumber){
    if (isEqualTo(alternativeNumber)){ return false; }
    if ((this.getIsNegative() == false) && (alternativeNumber.getIsNegative() == true)) { return true; }
    if ((this.getIsNegative() == true) && (alternativeNumber.getIsNegative() == false)) { return false; }
    if (this.getLength() > alternativeNumber.getLength()) { return true; }
    if (this.getLength() < alternativeNumber.getLength()) { return false; }
    
    int[] numberArray = this.getNumber();
    int[] alternativeNumberArray = alternativeNumber.getNumber();
    for (int index = 0; index < HUGE_INTEGER_SIZE; index += 1) {
      if (numberArray[index] == alternativeNumberArray[index] ) { continue; }
      else if (numberArray[index] > alternativeNumberArray[index]) { return true; }
      else { return false; }
    }
    return false;
  }
  
  public boolean isLessThan(HugeInteger alternativeNumber){
    if (isEqualTo(alternativeNumber)) { return false; }
    else return !isGreaterThan(alternativeNumber);
  }
  
  public boolean isGreaterThanOrEqualTo(HugeInteger alternativeNumber){
    return !isLessThan(alternativeNumber);
  }
  
  public boolean isLessThanOrEqualTo(HugeInteger alternativeNumber){
    return !isGreaterThan(alternativeNumber);
  }
  
  public static HugeInteger multiply (HugeInteger number, int multiplier){
    HugeInteger product = new HugeInteger("0");
    for (int count = 1; count <= multiplier; count += 1){
      product = add(product, number);
    }
    return product;
  }

//  public static HugeInteger divide (HugeInteger number, int divisor){
//    HugeInteger remainder = number;
//    HugeInteger count = new HugeInteger("0");
//    final HugeInteger ONE = new HugeInteger("1");
//    HugeInteger hugeDivisor = new HugeInteger("" + divisor);
//
//    while (remainder.toString().charAt(0) != '-'){
//      remainder = subtract(remainder, hugeDivisor);
//      count = add(count, ONE);
//    }
//    return subtract(remainder, ONE);
//  }

  //  public static HugeInteger remainder (HugeInteger number, int divisor){}


//  public static HugeInteger multiply (HugeInteger number, HugeInteger multiplier){
//    int[] numberArray = number.getNumber();
//    int[] multiplierArray = multiplier.getNumber();
//    String[] additionLines = new String[multiplier.getLength()];
//    final int BASE_10 = 10;
//
//    int carryOver = 0; int lineCount = 0;
//
//    for (int multiplierIndex = (HUGE_INTEGER_SIZE - 1); multiplierIndex > (HUGE_INTEGER_SIZE - multiplier.getLength()); multiplierIndex -= 1){
//      for (int numberIndex = (HUGE_INTEGER_SIZE - 1); numberIndex > (HUGE_INTEGER_SIZE - number.getLength()); numberIndex -= 1){
//        int digitProduct = (carryOver + (multiplierArray[multiplierIndex] * numberArray[numberIndex]));
//        additionLines[lineCount] = (digitProduct % BASE_10) + additionLines[lineCount];
//        carryOver = digitProduct / BASE_10;
//        if (carryOver != 0 && numberIndex == (HUGE_INTEGER_SIZE - number.getLength() + 1)){
//          additionLines[lineCount] = carryOver + additionLines[lineCount];
//          carryOver = 0;
//        }
//      }
//      additionLines[lineCount] += "0".repeat(lineCount);
//      lineCount++;
//    }
//
//    HugeInteger product = new HugeInteger("0");
//    for (String additionLine:  additionLines){
//      System.out.println(additionLine);
//      HugeInteger additionLineNumber = new HugeInteger(additionLine);
//      product = add(product, additionLineNumber);
//    }
//    return product;
//  }


//  public static HugeInteger divide (HugeInteger number, HugeInteger divisor){}

//  public static HugeInteger remainder (HugeInteger number, HugeInteger divisor){}
  
  
  
}
