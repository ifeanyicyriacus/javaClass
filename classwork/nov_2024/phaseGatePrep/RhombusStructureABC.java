import java.util.Scanner;
public class RhombusStructureABC{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the number: ");
		int number = input.nextInt();
		
		char letter = 'A';
		for(int index = 1; index <= number; index += 1){
			for(int i = 1; i <= (number-index); i += 1){
			  System.out.print(" ");
			}
			for(int i = 1; i <= index; i += 1){
			  System.out.print(letter++);
			}
			letter += 1;
			System.out.println();
			
		}
		
		
	}
}
