import java.util.Scanner;
public class FeetToMeter{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter number (in feet):");
    float numInFeet = input.nextFloat();
    double numInMeter = numInFeet / 0.305;
    
    System.out.printf("%f feet is %f meters%n", numInFeet, numInMeter);
  }
}
