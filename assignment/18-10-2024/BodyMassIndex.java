import java.util.Scanner;
/** Calculates the body mass index from weight(in Kg) and height (in metre)
*@author Ifeanyi Cyriacus
*/
public class BodyMassIndex{
  /**
  *@param args
  *@return void
  */
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your weight (in Kg): ");
    float weight = input.nextFloat();
    System.out.print("Enter your height (in metres): ");
    float height = input.nextFloat();
    double bmi = weight / Math.pow(height, 2);//(weight/height^2)
    /*the BMI scale follows:
    (bmi > 29.9)"You are obese"
    (25.0 <= bmi <= 29.9)"You have over weight"
    (18.5 <= bmi <= 24.9)"You have normal weight"
    (bmi < 18.5) "under weight"
    */
    if (bmi > 29.9){System.out.println("You are obese");}
    else if (bmi > 24.9){System.out.println("You are over weight");}
    else if (bmi > 18.49){System.out.println("You have normal weight");}
    else {System.out.println("You are under weight");} 
  }
}
