public class ARaisedToPowerB{
	public static void main(String[] args){
		System.out.print("a\tb\tpow(a, b)\n");
		int counter = 1;
		do {
			int counterB = counter + 1;
			System.out.printf("%d\t%d\t%d\n", counter, counterB, (int) Math.pow(counter, counterB));
			counter++;
		} while(counter <= 5);
	}
}
