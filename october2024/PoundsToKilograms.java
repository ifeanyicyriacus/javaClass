import java.util.Scanner;

public class PoundsToKilograms{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter number (in pounds):");
    float numInPounds = input.nextFloat();
    double numInkilograms = numInPounds * 0.454;
    
    System.out.printf("%f pounds is %f kilograms%n", numInPounds, numInkilograms);
  }
}
