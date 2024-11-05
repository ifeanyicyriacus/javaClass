import java.util.Scanner;
public class SimplePattern{
	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the maximum number to display: ");
		int maxNumber = input.nextInt();
		
		int counter = 1;
		while(counter <= maxNumber ){
			int number = 1;
			while (number <= counter){
				System.out.print(number++);
			}
			System.out.println();
			counter +=1;
		}
		counter -= 2;
		
		while(counter > 0 ){
			int number = 1;
			while (number <= counter){
				System.out.print(number++);
			}
			System.out.println();
			counter -=1;
		}

	
	}
}
