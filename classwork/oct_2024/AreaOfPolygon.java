import java.util.Scanner;
public class AreaOfPolygon{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of sides: ");
		int noOfSide = input.nextInt();
		System.out.print("Enter the length of one side: ");
		float lengthOfSide = input.nextFloat();
		double areaOfPolygon = (noOfSide * Math.pow(lengthOfSide, 2))/(4*Math.tan(Math.PI/noOfSide));
		
		System.out.printf("The area of the polygon is: %f%n", areaOfPolygon);
	}
}
