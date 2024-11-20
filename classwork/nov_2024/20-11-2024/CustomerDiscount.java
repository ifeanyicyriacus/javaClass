import java.util.Scanner;
public class CustomerDiscount{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the customer type ((r)regular/(p)premium): ");
    String customerType = input.next();
    System.out.print("Enter the amount: $");
    Double amount = input.nextDouble();
    System.out.print("Is this a repeat customer: ((y)yes/ (n) no): ");
    String repeatOrNot = input.next().toLowerCase();
    boolean isRepeatCustomer = (repeatOrNot.equals("y"))? true: false;
    double discount= 0.0;
    
    if (customerType.equals("p") && amount >= 500){
      discount = amount * 10 / 100;
      if (isRepeatCustomer)
        discount += amount * 2/ 100;
    }else if (customerType.equals("r") && amount >= 300){
      discount = amount * 5 / 100;
      if (isRepeatCustomer)
        discount += amount * 2/ 100;
    }
    
    amount = amount - discount;
    System.out.printf("You are to pay $%.2f%n", amount);
    
  }
}
