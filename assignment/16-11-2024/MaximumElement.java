import java.util.Arrays;

public class MaximumElement {
	public static void main(String[] args){
		int[] sample = {23, 32, 45, 76, 32, 32, 87, 87, 100, 32, 10};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
    
    int maximum = getMaximum(sample);
		System.out.printf("The Maximum of the Array is: %d%n", maximum);
	}
	
	public static int getMaximum(int[] intList){
	  Arrays.sort(intList);
		int lengthOfArray = intList.length;
		return intList[lengthOfArray - 1];
	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
