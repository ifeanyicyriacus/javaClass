import java.util.Arrays;

public class MinimumElement {
	public static void main(String[] args){
		int[] sample = {23, 32, 45, 76, 32, 32, 87, 87, 100, 32, 10};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
    
    int minimum = getMinimum(sample);
		System.out.printf("The Minimum of the Array is: %d%n", minimum);
	}
	
	public static int getMinimum(int[] intList){
	  Arrays.sort(intList);
		return intList[0];
	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
