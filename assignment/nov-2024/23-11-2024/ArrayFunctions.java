public class ArrayFunctions{
	public static void main(String[] args){
		int[] sampleArray1 = {19, 32, 133, 56, 40};
		int[] sampleArray2 = {};
		
		System.out.println("largest number is: " + findLargestFrom(sampleArray1));
	}
	
	public static int findLargestFrom(int[] listOfNumbers){
		int largest = listOfNumbers[0];
		for(int index = 1; index < listOfNumbers.length; index += 1){
			if (listOfNumbers[index] > largest){
				largest = listOfNumbers[index];
			}
		}
		return largest;
	}
	
	public static int reverseList(int[] listOfNumbers){
	  int length = listOfNumbers.length - 1;
	  int middle = listOfNumbers.length / 2;
	  for (int index = 0; index <= length; index += 1, length -= 1){
	    int temp = listOfNumbers[index];
	    listOfNumbers[index] = listOfNumbers[length];
	    listOfNumbers[length] = temp;
	  }
	  
	}
	
}
