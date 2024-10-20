import java.util.Scanner;
public class SumOfTwoNumbers{
  public static void main(String[] args){
    String decision = "n";
    float sum = 0;
    Scanner input = new Scanner(System.in);
    do {
      System.out.print("Enter first number: ");
      float number = input.nextFloat();
      sum = number;
      System.out.print("Enter second number: ");
      number = input.nextFloat();
      sum += number;
      System.out.printf("The sum is: %.2f%n",sum);
      System.out.printf("Do you wish to perform the operation again (y/n)");
      decision = input.next();
    }while(decision.equals("y"));
  }
}
