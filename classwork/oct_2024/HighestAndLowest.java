import java.util.Scanner;

public class HighestAndLowest{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a five digit integer: ");
    int number = input.nextInt();
    
    //separation
    int a = number / 10_000;
    int b = number / 1000 % 10;
    int c = number / 100 % 10;
    int d = number / 10 % 10;
    int e = number % 10;
    
    int highest = a;
    int lowest = a;
    
    //solving without loops
    if (b > highest) { highest = b; }
    if (c > highest) { highest = c; }
    if (d > highest) { highest = d; }
    if (e > highest) { highest = e; }
    
    if (b < lowest) { lowest = b; }
    if (c < lowest) { lowest = c; }
    if (d < lowest) { lowest = d; }
    if (e < lowest) { lowest = e; }
    
    System.out.printf("The highest number is: %d%n",highest);
    System.out.printf("The lowest number is %d%n",lowest);
  }
}
