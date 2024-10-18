import java.util.Scanner;

public class Multiples{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 1st integer: ");
    int num1 = input.nextInt();
    System.out.print("Enter 2nd integer: ");
    int num2 = input.nextInt();
    int num1Tripled = num1 * 3;
    int num2Doubled = num2 * 2;
    int remainder = num1Tripled % num2Doubled;
    
    if (remainder > 0){
      System.out.printf("The 1st num tripled (%d) is not a multiple of 2nd number doubled (%d)%n",num1Tripled, num2Doubled);
    }else {
      System.out.printf("The 1st num tripled (%d) is a multiple of 2nd number doubled (%d)%n",num1Tripled, num2Doubled);
    }
  }
}
