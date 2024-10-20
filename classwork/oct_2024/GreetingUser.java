import java.util.Scanner;

public class GreetingUser{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Username: ");
		String userName = input.nextLine();
		
		System.out.printf("Hi %s, Nice to meet you!%n", userName);
		System.out.println("Hi " + userName + ", Nice to meet you!");
		System.out.print("Hi " + userName + ", Nice to meet you!\n");
	}
}
