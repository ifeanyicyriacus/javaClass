public class MultiplicationTable{
	public static void main(String[] args){

		for (int counterB = 1; counterB <= 9; counterB++){
			int counterA = 1;
			do{
				System.out.printf("%d * %d = %d\t", counterA, counterB, (counterA * counterB));
				counterA++;
			} while(counterA <= 9);
			System.out.printf("%n");
		}
	}
}
