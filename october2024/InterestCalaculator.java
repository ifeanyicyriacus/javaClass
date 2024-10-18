import java.util.Scanner;

public class InterestCalaculator{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("enter the balance amount: ");
    float balance = input.nextFloat();
    System.out.print("annual interest rate (e.g., 3 for 3%: ");
    float annualInterestRate = input.nextFloat();
    double interest = balance * annualInterestRate /1200;
    
    System.out.printf("The interest is %f %n", interest);
  }
}
