public class ArrayReverse{
	public static void main(String[] args){
		int[] sampleIntegerArray = {23, 32, 45, 76, 87, 87, 100};
		System.out.println("Integer before reversing:");
		System.out.println(arrayToStringList(sampleIntegerArray));
		
		System.out.println("Integer after reversing:");
		System.out.println(arrayToStringList(reverse(sampleIntegerArray)));
	}
	
	
	public static int[] reverse(int[] intList){
	  int temp;
	  int fullLength = intList.length - 1;
		int halfLength = (int)(intList.length / 2);
		
		for (int index = 0; index <= halfLength; index += 1){
			temp = intList[index];
			intList[index] = intList[(fullLength) - index];
			intList[fullLength] = temp;
		}
		return intList;
	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
	
}
