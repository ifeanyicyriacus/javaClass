public class ArrayMerge{
	public static void main(String[] args){
		int[] array1 = {23, 32, 45, 76, };
		int[] array2 = {87, 100, 10};
		System.out.println("Original array list:");
		System.out.printf("[%s], ", arrayToStringList(array1));
		System.out.printf("[%s]%n", arrayToStringList(array2));
		
		String mergedArray = arrayToStringList(mergeArray(array1, array2));
		System.out.println("Merged array:");
		System.out.printf("[%s] %n", mergedArray);
	}
	
	public static int[] mergeArray(int[] intList1, int[] intList2){
		int lenght1 = intList1.length;
		int lenght2 = intList2.length;
		int totalLength = lenght1 + lenght2;
		int[] combinedArray = new int[totalLength];
		for(int index = 0; index < totalLength; index += 1){
			if(index < lenght1){
				combinedArray[index] = intList1[index];
			}else{
				combinedArray[index] = intList2[index - lenght1];
			}
		}
		return combinedArray;
	}

	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}

