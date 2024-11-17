public class ArrayReverse{
	public static void main(String[] args){
		int[] sampleIntegerArray = {23, 32, 45, 76, 87, 87, 100};
		int fullLength = sampleIntegerArray.length - 1;
		int halfLength = (int)(sampleIntegerArray.length / 2);
		
		System.out.println("Integer before reversing:");
		System.out.println(arrayToStringList(sampleIntegerArray));
		
		int temp;
		for (int index = 0; index <= halfLength; index += 1){
			temp = sampleIntegerArray[index];
			sampleIntegerArray[index] = sampleIntegerArray[(fullLength) - index];
			sampleIntegerArray[fullLength] = temp;
		}
		
		System.out.println("Integer after reversing:");
		System.out.println(arrayToStringList(sampleIntegerArray));
	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
	
}
