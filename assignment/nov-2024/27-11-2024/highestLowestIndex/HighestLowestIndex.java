public class HighestLowestIndex{
  public int[] getHighestAndLowest(int[] numbers){
    int[] result = new int[2];
    int highest = numbers[0];
    int lowest = numbers[0];

    for (int index = 1; index < numbers.length; index += 1){
      if (highest < numbers[index]) { 
        highest = numbers[index];
        result[0] = index; 
      }
      if (lowest > numbers[index]) { 
        lowest = numbers[index];
        result[1] = index;
      }
    }
    return result;
    
  }
}
