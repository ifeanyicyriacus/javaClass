import java.util.Scanner;
public class TwoLowestScores{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter x1 coordinate: ");
    float x1 = input.nextFloat();
        System.out.print("Enter y1 coordinate: ");
    float y1 = input.nextFloat();
        System.out.print("Enter x2 coordinate: ");
    float x2 = input.nextFloat();
        System.out.print("Enter y2 coordinate: ");
    float y2 = input.nextFloat();
        System.out.print("Enter x3 coordinate: ");
    float x3 = input.nextFloat();
        System.out.print("Enter y3 coordinate: ");
    float y3 = input.nextFloat();
    
    double side1 = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    double side2 = Math.sqrt(Math.pow((x3-x2), 2) + Math.pow((y3-y2), 2));
    double side3 = Math.sqrt(Math.pow((x3-x1), 2) + Math.pow((y3-y1), 2));
    double s =(side1 + side2 + side3)/2;
    double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    //double area = 0.5 * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));
    
    System.out.printf("%nThe area of the triangle is %.2f%n", Math. abs(area));
    
  }
}
