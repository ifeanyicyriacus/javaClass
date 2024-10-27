import java.util.Scanner;

public class VolumeOfTriangle{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the length of a side of an equilateral triangle: ");
    float lengthOfSide = input.nextFloat();
    double area = (Math.sqrt(3)/4) * Math.pow(lengthOfSide, 2);
    double volume = area * lengthOfSide;
    
    System.out.printf("The area is %.2f%n",area);
    System.out.printf("The volume of the Tringular prism is %.2f%n", volume);
    
  }
}
