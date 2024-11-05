import java.util.Scanner;
public class ClassExercise1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter grade: ");
		int grade = input.nextInt();
		if (grade < 50){
			System.out.println("D");
		}
		if (grade > 50 && grade <= 60){
			System.out.println("C");
		}
		if (grade > 60 && grade <= 80){
			System.out.println("B");
		}
		if (grade > 80 && grade <= 100){
			System.out.println("A");
		}
	}

}
