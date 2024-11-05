import java.util.Scanner;
public class SimplePattern2{
	public static void main (String[] args){
	  Scanner input = new Scanner(System.in);
	
		System.out.print("Enter the maximum asteriks '*' to display per line: ");
	  int length = input.nextInt();
	  int halfLength = (int)(length/2);

    for(int i = 1; i <= halfLength; i++){     
      for(int j = 1; j <= i; j++){
        System.out.print("*");}
      for(int k = 1; k <= (length-(i*2)); k++){
        System.out.print(" ");}
      for(int l = 1; l <= i; l++){
        System.out.print("*");}
      System.out.println();
		}
		
		for(int i = 1; i <= length; i++){
		  System.out.print("*");
		}
		System.out.println();
		
		for(int i = halfLength; i > 0; i--){
      for(int j = 1; j <= i; j++){
        System.out.print("*");}
      for(int k = 1; k <= (length-(i*2)); k++){
        System.out.print(" ");}
      for(int l = 1; l <= i; l++){
        System.out.print("*");}
      System.out.println();
		}

	
	}
}
