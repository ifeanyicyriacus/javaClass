import java.util.Scanner;
/** Converts length in feets to meters
*@author Ifeanyi Cyriacus
*/
public class FeetToMeter{
  /**
  *@param args
  *@return void
  */
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter number (in feet):");//prompting the user
    float numInFeet = input.nextFloat();//collecting input
    double numInMeter = numInFeet / 0.305;
    
    System.out.printf("%f feet is %f meters%n", numInFeet, numInMeter);
  }
}
