import java.util.ArrayList;
import java.util.Arrays;

public class ArrayFunctions{
	public static void main(String[] args){
		int[] list1 = {19, 32, 133, 40, 56, 40, 70};
		int[] list2 = {60, 82, 9, 36, 90};
		int number1 = 76328656;
		int number2 = 102003000;
		String list1Txt = Arrays.toString(list1);
		String list2Txt = Arrays.toString(list2);
		String sampleText1 = "MoiMoi";
		String sampleText2 = "madam";
		
		System.out.printf("list1: %s%n%n", list1Txt);
		
		System.out.println("1. Largest number in (list1) is: " + findLargestFrom(list1));
		System.out.printf("2. Reversed (list1): %s%n", Arrays.toString(reverseList(list1)));
    reverseList(list1);
    System.out.printf("3a. Does (19) exist in: %s: %b%n", list1Txt, checkIfExist(list1, 19));
    System.out.printf("3b. Does (20) exist in: %s: %b%n", list1Txt, checkIfExist(list1, 20));
    
    
    System.out.printf("4. Elements in Odd position in %s are: %s%n", list1Txt, Arrays.toString(returnOddPositionElement(list1)));
    System.out.printf("5. Elements in Even position in %s are: %s%n", list1Txt, Arrays.toString(returnEvenPositionElement(list1)));
    System.out.printf("6. Running total of %s is: %d%n", list1Txt, getRunningTotal(list1));
    System.out.printf("7a. Is \"%s\" a palindrome? %b%n", sampleText1, checkIfPalindrome(sampleText1));
    System.out.printf("7b. Is \"%s\" a palindrome? %b%n", sampleText2, checkIfPalindrome(sampleText2));
    System.out.printf("8a. The sum of %s (using for loop) is: %d%n", list1Txt, sumUsingForLoop(list1));
    System.out.printf("8a. The sum of %s (using while loop) is: %d%n", list1Txt, sumUsingWhileloop(list1));
    System.out.printf("8a. The sum of %s (using do..while loop) is: %d%n", list1Txt, sumUsingDoWhileLoop(list1));
    
    System.out.printf("9. Concatinating %s and %s gives: %n %s%n", list1Txt, list2Txt, Arrays.toString(concatinateLists(list1, list2)));
    System.out.printf("10. Alternatingly Concatinating %s and %s gives: %n %s%n", list1Txt, list2Txt, Arrays.toString(alternatingConcatination(list1, list2)));
    System.out.printf("11a. Function takes in (%d) and retutns: %s %n", number1, Arrays.toString(numberToListOfDigit(number1)));
    System.out.printf("11b. Function takes in (%d) and retutns: %s %n", number2, Arrays.toString(numberToListOfDigit(number2)));
    
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
	
	public static int[] reverseList(int[] listOfNumbers){
	  int length = listOfNumbers.length;
	  int middle = listOfNumbers.length / 2;
	  for (int index = 0; index < middle; index += 1){
	    int temp = listOfNumbers[index];
	    listOfNumbers[index] = listOfNumbers[--length];
	    listOfNumbers[length] = temp;
	  }
	  return listOfNumbers;
	}
	
	public static boolean checkIfExist(int[] listOfNumbers, int number){
	  for (int element: listOfNumbers){
	    if (number == element){ return true; }
	  }
	  return false;
	}
	
	public static int[] returnOddPositionElement(int[] listOfNumbers){
	
	  ArrayList<Integer> oddNumberList = new ArrayList<Integer>();
	  boolean toggle = true;
	  for (int index = 0; index < listOfNumbers.length; index += 1){
	    if (toggle){
	      oddNumberList.add(listOfNumbers[index]);
	    }
	    toggle = !toggle;
	  }
	  return arrayListToArray(oddNumberList);
	}
	
	public static int[] returnEvenPositionElement(int[] listOfNumbers){
	  ArrayList<Integer> evenNumberList = new ArrayList<Integer>();
	  boolean toggle = false;
	  for (int index = 0; index < listOfNumbers.length; index += 1){
	    if (toggle){
	      evenNumberList.add(listOfNumbers[index]);
	    }
	    toggle = !toggle;
	  }
	  return arrayListToArray(evenNumberList);
	}
	
	public static int getRunningTotal(int[] numbers){	  
	  int total = 0;
	  for(int number : numbers){
	    total += number;
	  }
	  return total;
	}
	
	public static boolean checkIfPalindrome(String text){
	  String[] letters = text.toLowerCase().split("");
	  int length = letters.length;
	  int middle = letters.length / 2;
	  
	  for(int index = 0; index < middle; index += 1){
	    if(!letters[index].equals(letters[--length])){
	      return false;
	    }
	  }
	  return true;
	}
	
	public static int sumUsingForLoop(int[] numbers){
	  int sum = 0;
	  for (int counter = 0; counter < numbers.length; counter += 1){
      sum += numbers[counter];
    }
    return sum;
	}
	
	public static int sumUsingWhileloop(int[] numbers){
	  int sum = 0;
	  int counter = 0;
	  while(counter < numbers.length){
	    sum += numbers[counter];
	    counter += 1;
	  }
	  return sum;
	}
	
	public static int sumUsingDoWhileLoop(int[] numbers){
	  int sum = 0;
	  int counter = 0;
	  do{
	    sum += numbers[counter];
	    counter += 1;
	  }while(counter < numbers.length);
	  return sum;
	}
	
	public static int[] concatinateLists(int[] list1, int[] list2){
	  int length1 = list1.length;
	  int totalLengthSum = list1.length + list2.length;
	  int[] newList = Arrays.copyOf(list1, totalLengthSum);
	  
	  for(int index = 0; index < list2.length; index += 1){
	    newList[length1 + index] = list2[index];
	  }
	  return newList;
	}
	
	public static int[] alternatingConcatination(int[] list1, int[] list2){
	  int length1 = list1.length;
	  int length2 = list2.length;
	  int totalLength = length1 + length2;
	  
	  int[] newlist = new int[totalLength];
	  int maxLength = (length1 >= length2) ? length1 : length2;
	  int count = 0;
	  
	  for(int index = 0; index < maxLength; index += 1){
	    if (index < length1){
	      newlist[count++] = list1[index];
	    }
	    if (index < length2){
	      newlist[count++] = list2[index];
	    }
	  }
	  return newlist;
	}
	
	public static int[] numberToListOfDigit(int number){
	  String numberStr = number + "";
	  int length = numberStr.length();
	  int[] intList = new int[length];
	  int cropA = 10; int cropB = 1;
	  
	  for(int index = (length - 1); index >= 0; index -= 1){
	    int digit = (number % cropA) / cropB;	    
	    intList[index] = digit;
	    cropA *= 10; cropB *= 10;	  
	  }
	  return intList;
	}
	
	
	
	public static int[] arrayListToArray (ArrayList<Integer> numberArrayList){
	  int[] numbersArray = new int[numberArrayList.size()];
	  for (int index = 0; index < numberArrayList.size(); index += 1){
	    numbersArray[index] = numberArrayList.get(index);
	  }
	  return numbersArray;
	}

	
	
	
}
