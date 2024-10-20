import java.util.Scanner;

public class PhysicsAcceleration{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter the initial velocity: ");
    float velocity0 = input.nextFloat();
    System.out.print("Enter the final velocity: ");
    float velocity1 = input.nextFloat();    
    System.out.print("Enter the time duration: ");
    float duration = input.nextFloat();    
    
    double acceleration = (velocity1 - velocity0)/ duration;
    System.out.printf("The average acceleration is %f%n%n", acceleration);
  }
}
