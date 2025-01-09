public class PureWater{
  
  public static String findIndex(int[] numberList, int keyword){
    for (int index = 0; index < numberList.length; index += 1){
      if (numberList[index] == keyword) {
        return "index " + index;
      } 
    } return "not available";
  }
  public static String positiveNegativeAndZeroCount(int[] numberList){
    int zeros = 0;
    int positives = 0;
    int negatives = 0;
    
    for (int number: numberList){
      if (number < 0) { negatives += 1;}
      else if (number > 0) { positives += 1;}
      else { zeros += 1; }
    }
    
    return String.format("positives: %d%nnegatives: %d%nzeros: %d", positives, negatives, zeros);
      
  }
}
