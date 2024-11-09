import java.util.Scanner;
public class TextEditor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int sentinelValue = 0;
		int operation;
		String message = """
		
		1. add
		2. view
		3. delete
		4. quit
		>>>   """;
		
		
		while(sentinelValue != -1){
			System.out.print(message);
			operation = input.nextInt();
			switch (operation){
				case 1:
					System.out.println("Add");
					continue;
				case 2:
					System.out.println("View");
					continue;
				case 3:
					System.out.println("Delete");
					continue;
				case 4:
					System.out.println("Quit");
					sentinelValue = -1;
					continue;
				default:
					System.out.println("Wrong input: please try again");
					continue;
			}		
		}
		
		
		
	}
}
