import java.util.ArrayList;

public class ArrayMerge{
	public static void main(String[] args){
		int[] array1 = {23, 32, 45, 76};
		int[] array2 = {87, 100, 10};
		System.out.println("Original array list:");
		System.out.printf("[%s], ", arrayToStringList(array1));
		System.out.printf("[%s]%n", arrayToStringList(array2));
		
		ArrayList<Integer> mergedArray = mergeArray(array1, array2);
		System.out.println("Merged array:");
		System.out.printf("[%s] %n", arrayListToStringList(mergedArray));
	}
	
	public static ArrayList<Integer> mergeArray(int[] intList1, int[] intList2){
		ArrayList<Integer> combinedArray = new ArrayList<Integer>();
		int lenght1 = intList1.length;
		int lenght2 = intList2.length;
		int totalLength = lenght1 + lenght2;
		for(int index = 0; index < totalLength; index += 1){
			if(index < lenght1){
				combinedArray.add(intList1[index]);
			}else{
				combinedArray.add(intList2[index - lenght1]);
			}
		}
		return combinedArray;
	
	}
	
	public static String arrayListToStringList(ArrayList<Integer> intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
