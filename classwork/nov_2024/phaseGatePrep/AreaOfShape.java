import java.util.Scanner;
public class AreaOfShape{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String message1 = """
			Please select the type of shape:
			1. Circle
			2. Rectangle
			3. Triangle
			>>>""";
		double area; double height; double length; double base; double radius;
		System.out.print(message1);
		int shape = input.nextInt();
		switch(shape){
			case 1:
				System.out.print("Enter the Radius of the circle (in meter): ");
				radius = input.nextDouble();
				area = Math.PI * Math.pow(radius, 2);
				System.out.printf("The area of the circle is: %.2fmsq%n", area);
		    break;
	  	case 2:
			  System.out.print("Enter the length of the rectangle (in meter): ");
			  length = input.nextDouble();
			  System.out.print("Enter the height of the rectangle (in meter): ");
			  height = input.nextDouble();
			  area = length * height;
			  System.out.printf("The area of the rectangle is: %.2fmsq%n", area);
	    	break;
	    case 3:
			  System.out.print("Enter the base length of the triangle (in meter): ");
			  base = input.nextDouble();
			  System.out.print("Enter the base height of the triangle (in meter): ");
			  height = input.nextDouble();
			  area = 0.5 * base * height;
			  System.out.printf("The area of the triangle is: %.2f%nmsq", area);
	    	break;
	    default:
	    	System.out.print("Please select a valid shape option, Try again");
  	}
			
		
	}
}
