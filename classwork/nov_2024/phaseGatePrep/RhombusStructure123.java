import java.util.Scanner;
public class RhombusStructure123{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the number: ");
		int number = input.nextInt();
		
		char letter = '1';
		for(int row = 1; row <= number; row += 1){
		  for (int spaceIndex = 1; spaceIndex <= (number - row); spaceIndex += 1){
		    System.out.print(" ");
		  }
		  
		  for (int letterIndexA = 1; letterIndexA <= row; letterIndexA += 1){
		    System.out.print(letter++);
		  }
		  letter -= 1;
		  for (int letterIndexA = 1; letterIndexA < row; letterIndexA += 1){
		    System.out.print(--letter);
		  }
		  System.out.println();
		}
		
		for(int row = 1; row < number; row += 1){
	    //handle spaces
	    for (int index = 1; index <= row; index += 1){
	      System.out.print(" ");
	    }
	    for (int letterIndexA = 1; letterIndexA <= (number - row); letterIndexA += 1){
		    System.out.print(letter++);
		  }
		  letter -= 1;
		  for (int letterIndexA = 1; letterIndexA < (number - row); letterIndexA += 1){
		    System.out.print(--letter);
		  }
	    System.out.println();	    
		}


	}
}
