import java.util.Scanner;
public class HalfDiamond{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the number: ");
		int number = input.nextInt();
		
		int letter = 1;
		
		int counter = 1;
		while(counter <= number){
		  int index = 1;
		  while(index <= counter){
		    System.out.print(index);
		    index += 1;
		  }
		  System.out.println();
		  counter += 1;
		  }
		  
		counter = number - 1;
		while(counter >= 1){
		  int index = 1;
		  while(index <= counter){
		    System.out.print(index);
		    index += 1;
		  }
		  System.out.println();
		  counter -= 1;
		  }
		  
		  
		  
	}
}
