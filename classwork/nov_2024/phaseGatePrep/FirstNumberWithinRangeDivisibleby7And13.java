import java.util.Scanner;
public class FirstNumberWithinRangeDivisibleby7And13{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first integer: ");
    int number1 = input.nextInt();
    System.out.print("Enter the second integer: ");
    int number2 = input.nextInt();
    
    while (number2 < number1){
      System.out.print("Second integer should be bigger, Try again:\nEnter the second integer: ");
      number2 = input.nextInt();
    }
    
    int firstNumberDivisibleby7And13 = 0;
    for (int number = number1; number <= number2; number += 1){
      if(number % 7 == 0 && number % 13 == 0){
        firstNumberDivisibleby7And13 = number;
        break;
      }
    }
    
    if (firstNumberDivisibleby7And13 == 0){
      System.out.println("There are no multiple of both 7 and 13 that exist within range");
    }else {
      System.out.printf("The first number divisible by both 7 and 13 within range (%d) and (%d) is: %d%n", number1, number2, firstNumberDivisibleby7And13);
    }
    
  }
}
