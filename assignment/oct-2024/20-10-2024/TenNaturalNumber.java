public class TenNaturalNumber{
	public static void main(String[] args){
		int counter = 1;
		int sum = 0;
		while (counter <= 10){
			sum += counter;
			counter++;
		}
		System.out.printf("The sum of the first 10 natural numbers is: %d%n", sum);
	}
}
