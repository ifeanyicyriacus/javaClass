import java.util.Scanner;
public class SumOfEvenWithinRange{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first integer: ");
    int integer1 = input.nextInt();
    System.out.print("Enter the second integer: ");
    int integer2 = input.nextInt();
    
    while (integer2 < integer1){
      System.out.print("Try again:\nEnter the second integer: ");
      integer2 = input.nextInt();
    }
    
    int sumOfEvenWithinRange = 0;
    for (int index = integer1; index <= integer2; index += 1){
      if (index % 2 == 0){
        sumOfEvenWithinRange += index;
      }
    }
    System.out.printf("The sum of the even numbers between (%d) and (%d) is: %d%n", integer1, integer2, sumOfEvenWithinRange);
    
    
  }
}
