import java.util.Scanner;
public class BinaryToDecimal{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Binary digit: ");
		long binNumber = input.nextLong();
		
		long decNumber = 0; int powerCounter = 0;
		long crop1 = 10; long crop2 = 1;
		
		do{
			long value = 0; long base = 0; 
			base = (long)((binNumber % crop1) / crop2);
			value = (long)(base * Math.pow(2, powerCounter));
						
			decNumber += value;
			crop1 *= 10; crop2 *= 10; powerCounter +=1;
		} while((binNumber / crop2) > 0);
		System.out.printf("Binary (%d) is decimal (%d)%n", binNumber, decNumber);
	}
}
