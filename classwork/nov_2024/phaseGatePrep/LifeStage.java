import java.util.Scanner;
public class LifeStage{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = input.nextInt();
		
		if(age >= 65){
			System.out.println("User is a Senior");
		}else if(age >= 18){
			System.out.println("User is an adult");
		}else if(age >= 13){
			System.out.println("User is an teen");
		}else {
			System.out.println("User is a child");
		}
		
	}
}
