import java.util.Scanner;
public class StringToInteger{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input a number (String): ");
		String stringNumber = input.next();
		int integerNumber = Integer.valueOf(stringNumber);
		System.out.println(integerNumber);
  }
}
