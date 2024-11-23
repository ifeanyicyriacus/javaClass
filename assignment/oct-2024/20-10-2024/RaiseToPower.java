import java.util.Scanner;
public class RaiseToPower{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the 1st number: ");
    float base = input.nextFloat();
    System.out.print("Enter the 2nd number: ");
    float exponent = input.nextFloat();
    float result = base;
    int counter = 2;
    
    if (exponent == 0) {result = 1;}
    else{
      while (counter <= Math.abs(exponent)){
        result *= base;
        counter++;
      }
    }
    if (exponent < 0) {result = 1/result;}
    System.out.printf("%.0f raised to power %.0f = %.3f%n", base, exponent, result);
  }
}
