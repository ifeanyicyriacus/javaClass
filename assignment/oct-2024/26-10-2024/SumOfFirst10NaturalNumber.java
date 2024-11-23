public class SumOfFirst10NaturalNumber{
	public static void main(String[] args){
		int counter = 1;
		int sum = 0;
		
		while (counter <= 10) {
		  sum += counter;
		  counter++;
		}
		System.out.printf("The sum of the first 10 natural number is: %d%n", sum);
	}
}
