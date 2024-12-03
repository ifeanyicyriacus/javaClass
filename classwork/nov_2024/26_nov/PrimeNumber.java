import java.util.Scanner;
import java.util.Arrays;

public class PrimeNumber{
	public static int[] primeLessThanNumber(int number){
	  int[] newList = new int[1];
	  int length = newList.length;
	  int index = 0;
	  for (int indexA = 2; indexA < number; indexA += 1){
	    for (int indexB = indexA; indexB < number; indexB += 1){
        if (ifExistInArray(newList, indexB) && isPrime(indexB)){
          newList = Arrays.copyOf(newList, length++);
          newList[index] = indexB;
          index += 1;
        } 
	    }
	  }
	  return newList;
	}
	
	
	public static boolean isPrime(int number){
	  for (int index = 2; index < number; index += 1){
        if (number % index == 0)
            return false;
    }
    return true;	
	}
	
	public static boolean ifExistInArray(int[] intList, int key){
	  for (int number: intList){
	    if (number == key){
	    return false;
	    }
	  }
    return true;
	}
	
}
