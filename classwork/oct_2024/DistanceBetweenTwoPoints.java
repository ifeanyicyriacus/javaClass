import java.util.Scanner;
import java.lang.Math;
public class DistanceBetweenTwoPoints{
	public static void main(String[] args){
	  double RADIUS_OF_EARTH = 6371.01;
	  
	  Scanner input = new Scanner(System.in);
	  System.out.printf("Input the latitude of coordinate 1: ");
	  double pointX1 = input.nextDouble();
	  System.out.printf("Input the longititude of coordinate 1: ");
	  double pointY1 = input.nextDouble();
	  System.out.printf("Input the latitude of coordinate 2: ");
	  double pointX2 = input.nextDouble();
	  System.out.printf("Input the longititude of coordinate 2: ");
	  double pointY2 = input.nextDouble();
	  
	  double distance = RADIUS_OF_EARTH * Math.acos(Math.sin(pointX1) * Math.sin(pointX2) + Math.cos(pointX1) * Math.cos(pointX2) * Math.cos(pointY1 - pointY2));
	  
		System.out.printf("The distance between those points is: %fkm\n", distance);
	}
}
