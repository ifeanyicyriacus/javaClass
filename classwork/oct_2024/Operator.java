public class Operator{
	public static void main(String[] args){
		
		int numA = 12;
		int numB = 22;
		
		System.out.println((!(numA > numB ||numA < numB  && numB <= numA | numA >= numB ^ false & true))?
		"The condition return true":
		"The condition result to false");
	
	}
}
