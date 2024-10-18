import java.util.Scanner;
public class ArithematicSmallestLargest{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 1st integer: ");
    int num1 = input.nextInt();
    System.out.print("Enter 2rd integer: ");
    int num2 = input.nextInt();
    System.out.print("Enter 3rd integer: ");
    int num3 = input.nextInt();
    int smallest = num1;
    int largest = num1;
    if (num2 > largest){largest = num2;}
    if (num3 > largest){largest = num3;}
    if (num2 < smallest){smallest = num2;}
    if (num3 < smallest){smallest = num3;}
    System.out.printf("Their sum is: %d%n", (num1 + num2 + num3));
    System.out.printf("Their average is: %d%n", (num1 + num2 + num3)/3);
    System.out.printf("Their product is: %d%n", (num1 * num2 * num3));
    System.out.printf("The smallest of the numbers is: %d%n", smallest);
    System.out.printf("The largest of the numbers is: %d%n", largest);
  }
}
