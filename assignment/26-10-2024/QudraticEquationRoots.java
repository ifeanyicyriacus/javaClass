import java.util.Scanner;
public class QudraticEquationRoots{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the value of a: ");
		double a = input.nextDouble();
		System.out.print("Enter the value of b: ");
		double b = input.nextDouble();
		System.out.print("Enter the value of c: ");
		double c = input.nextDouble();
		double discriminant = (Math.pow(b, 2) - 4 * a * c);
		
		if (a == 0){
		  System.out.println("There are no roots when a = 0");
		} else if(discriminant > 0){
		  double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		  double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		  System.out.printf("The roots are %.3f and %.3f%n", root1, root2);
		} else if(discriminant == 0){
		  double root = (-b + Math.sqrt(discriminant)) / (2 * a);
		  System.out.printf("The root is %.3f%n", root);
		} else {
		  double realRoot = -b / (2 * a);
		  double imaginaryUnit = 1.0/(2 * a);
		  System.out.printf("The roots are %.3f+%.3fi and %.3f-%.3fi%n", realRoot, imaginaryUnit, realRoot, imaginaryUnit);
		}
	}
}
