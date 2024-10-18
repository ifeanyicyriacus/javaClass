import java.util.Scanner;

public class SortingNumber{
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
    
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    //sorting
    
    int temp;
    if (a > b){
      temp = a;
      a = b;
      b = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (a > c){
      temp = a;
      a = c;
      c = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (a > d){
      temp = a;
      a = d;
      d = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (a > e){
      temp = a;
      a = e;
      e = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    
    if (b > c){
      temp = b;
      b = c;
      c = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (b > d){
      temp = b;
      b = d;
      d = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (b > e){
      temp = b;
      b = e;
      e = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    
    if (c > d){
      temp = c;
      c = d;
      d = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    if (c > e){
      temp = c;
      c = e;
      e = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    
    if (d > e){
      temp = d;
      d = e;
      e = temp;
    }
    System.out.printf("%d, %d, %d, %d, %d %n%n", a, b, c, d, e);
    
    
  }
}
