import java.util.Scanner;
public class ThreeNumberEqualitySentinel{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int number1 = 0; int number2 = 0; int number3 = 0;
		
		 while(number1 != -1 && number2 != -1 && number3 != -1){
		  System.out.print("Enter number1 or enter -1 to abort: ");
		  number1 = input.nextInt();
		  if (number1 == -1){continue;}
		  System.out.print("Enter number2 or enter -1 to abort: ");
		  number2 = input.nextInt();
		  if (number2 == -1){continue;}
		  System.out.print("Enter number3 or enter -1 to abort: ");
		  number3 = input.nextInt();
		  if (number3 == -1){continue;}
		  
		  if(number1 == number2 && number1 == number3){
			  System.out.println("All three numbers are equal\n");
		  } else
			  System.out.println("All three numbers are not equal\n");
		}
	}
}
