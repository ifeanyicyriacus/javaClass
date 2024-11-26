import java.util.Arrays;
class TestPrimeNumber{
	static int noOfTest = 0;
	static int noOfTestFailed = 0;
	public static void main (String[] args){
		PrimeNumber primeNumber = new  PrimeNumber();

		int[] actual = primeNumber.primeLessThanNumber(17);
		int[] expected = {2,3,5,7,11,13};
		System.out.println(assertEqual("Prime Function", actual, expected));
		
		System.out.println(finalReport());
	}
	
	public static String assertEqual(String testName, int[] a, int[] b){
		noOfTest += 1;
		if(Arrays.compare(a, b) == 0){
			return "\033[32m"+ testName +" passed\033[0m\n";
		}
		noOfTestFailed += 1;
		return "\033[32m"+ testName +" failed\033[0m\n";
	}
	
	public static String finalReport(){
	  int noOfTestPassed = noOfTest - noOfTestFailed;
	  return "Ran "+ noOfTest +" tests\n"+ noOfTestPassed +" passed\n"+ noOfTestFailed +" failed\n"; 
	
	}
	
}
