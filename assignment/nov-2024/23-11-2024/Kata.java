public class Kata {
	public static void main(String[] args){
	    System.out.printf("1a. is (%d) an even number: %b\n", 13, isEven(13));
	    System.out.printf("1b. is (%d) an even number: %b\n", 24, isEven(24));
	    System.out.printf("2a. is (%d) a prime number: %b\n", 13, isPrimeNumber(13));
	    System.out.printf("2b. is (%d) a prime number: %b\n", 24, isPrimeNumber(24));
	    System.out.printf("3a. The difference between (%d and %d) is %d\n", 7,3, subtract(7, 3));
	    System.out.printf("3b. The difference between (%d and %d) is %d\n", 3,7, subtract(3, 7));
	    System.out.printf("4a. The quotient of (%d/%d) is %.2f\n", 5,0, divide(5, 0));
	    System.out.printf("4b. The quotient of (%d/%d) is %.2f\n", 5,2, divide(5, 2));
	    System.out.printf("5a. (%d) has %d factors\n", 10, factorOf(10));
	    System.out.printf("5b. (%d) has %d factors\n", 15, factorOf(15));
	    System.out.printf("6a. is (%d) a square? %b\n", 25, isSquare(25));
	    System.out.printf("6b. is (%d) a square? %b\n", 10, isSquare(10));
	    System.out.printf("7a. is (%d) a palindrome? %b\n", 5225, isPalindrome(5225));
	    System.out.printf("7b. is (%d) a palindrome? %b\n", 54345, isPalindrome(54345));
      System.out.printf("7c. is (%d) a palindrome? %b\n", 53345, isPalindrome(53345));
      System.out.printf("8a. The factorial of (%d) is %d\n", 5, factorialOf(5));
      System.out.printf("8b. The factorial of (%d) is %d\n", 10, factorialOf(10));
      System.out.printf("9b. The square of (%d) is %d\n", 10, squareOf(10));
      System.out.printf("9b. The square of (%d) is %d\n", 5, squareOf(5));
      
	}
	
	public static boolean isEven(int number){
	  return (number % 2 == 0) ? true: false;	
	}
	
	public static boolean isPrimeNumber(int number){
	  if (number == 1){ return false; }
	  for (int test = 2; test < number; test += 1){
	    if (number % test == 0){ return false; }
	  }
	  return true;
	}
	
	public static int subtract(int number1, int number2){
	  return Math.abs(number1 - number2);
	}
	
	public static float divide(int number1, int number2){
	  if (number2 == 0){ return (float) 0; }
	  float quotient = (float)number1/number2;
	  return quotient;
	}
	
	public static int factorOf(int number){
	  int factorCount = 1;
	  for (int index = 1; index < number; index += 1){
	    if (number % index == 0){ factorCount += 1; }
	  }
	  return factorCount;
	}
	
	public static boolean isSquare(int number){
	  double numberSqrt = Math.sqrt(number);
	  int numberSqrtInt = (int)numberSqrt;
	  if (numberSqrtInt == numberSqrt){ return true;}
	  else { return false; }
	}
	
	public static boolean isPalindrome(int number){
	  String numberStr = number + "";
	  char[] numberCharacters = numberStr.toCharArray();
	  int length = numberCharacters.length;
	  int halfLength = length / 2;
	  
	  for (int index = 0; index < halfLength; index += 1){
	    char rightSide = numberCharacters[index];
	    char leftSide = numberCharacters[--length];
	    
	    if (rightSide != leftSide){ return false; }
	  }
	  return true;	  
	}
	
  public static long factorialOf(int number){
    if (number == 1) { return (long)1; }
    return (long) (number * factorialOf(--number));
  }
  
  public static long squareOf(int number){
    return (long)(number * number);
  }


}
