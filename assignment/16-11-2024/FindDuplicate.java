import java.util.Arrays;

public class FindDuplicate{
	public static void main(String[] args){
		int[] sample = {23, 32, 45, 76, 32, 32, 87, 87, 100};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
		
    System.out.println("Duplicates:");
		System.out.println(findDuplicate(sample));
	}

  public static String findDuplicate(int[] intList){
    Arrays.sort(intList);
	  String text = "";
	  int arrayLength = intList.length;
	  
	  for (int index = 0; index < arrayLength - 1; index += 1){
	    if ((intList[index] == intList[index+1]) && !text.contains(intList[index]+"")){
	      text += intList[index] + " ";
	    }		
	  }
	  return text;
  }
		
  public static String arrayToStringList(int[] intList){
	  String list ="";
	  for(int number: intList){
		  list += (number+ " ");
	  }
	  return list;
	}
}
