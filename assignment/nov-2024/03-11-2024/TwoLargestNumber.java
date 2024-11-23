import java.util.Scanner;
public class TwoLargestNumber{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter first number: ");
    float largest_1 = input.nextFloat();
    System.out.print("Enter second number: ");
    float largest_2 = input.nextFloat();
    float temp;
    if (largest_2 > largest_1){
      temp = largest_1;
      largest_1 = largest_2;
      largest_2 = temp;
    }
    float number;
    for(int count = 1; count <= 8; count += 1){
      System.out.print("Enter another number: ");
      number = input.nextFloat();
      if (number > largest_1){
        temp = largest_1;
        largest_1 = number;
        largest_2 = temp;
      }else if (number > largest_2){
        largest_2 = number;
      }
    }
    
    System.out.printf("The largest number is: %.2f\n", largest_1);
    System.out.printf("The second largest number is: %.2f\n", largest_2);
    
  
  }
}
