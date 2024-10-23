import java.util.Scanner;
public class DecimalToBinary{
	public static void main(String[] args){
	  System.out.print("Enter decimal number: ");
		Scanner input = new Scanner(System.in);
		int decNumber = input.nextInt();
		String binNumber = "";
		do{
			int rem = decNumber % 2;
			binNumber = rem + binNumber;
			decNumber /= 2;
		} while (decNumber  > 0);
		System.out.printf("Binary number: %s%n", binNumber);
	}
}
