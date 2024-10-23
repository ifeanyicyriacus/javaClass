import java.util.Scanner;
public class BinaryToDecimal{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Binary digit: ");
		int binNumber = input.nextInt();
		
		int base = 0; int decNumber = 0; int counter = 0;
		int crop1 = 10; int crop2 = 1;
		
		do{
			int value = 0;
			base = ((binNumber % crop1) / crop2);
			value = (int)(base * Math.pow(2, counter));
						
			decNumber += value;
			crop1 *= 10; crop2 *= 10; counter +=1;
		} while((binNumber / crop2) > 0);
		System.out.printf("Binary (%d) is decimal (%d)%n", binNumber, decNumber);
	}
}
