import java.util.Scanner;
public class ClassExercise4{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter grade: ");
		int grade = input.nextInt();
		
		switch (grade){
		  case 50:
		    System.out.println("C");
		    break;
		  case 70:
		    System.out.println("B");
		    break;
		  case 100:
		    System.out.println("A");
		    break;
		  default:
		    System.out.println("Well done!");
		  
		}
		
	}

}
