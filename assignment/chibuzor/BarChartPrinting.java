import java.util.Scanner;
public class BarChartPrinting{
  public static void main(String[] args){
    String output = "";
    int counter = 1;
    Scanner input = new Scanner(System.in);
    do {
      System.out.print("Enter the number: ");
      int exponent = input.nextInt();
      int temp_counter = 1;
      String asterisks = "";
      while (exponent >= temp_counter){
        asterisks += "*";
        temp_counter++;
      }
      output += asterisks + "\n";
      counter += 1;
    } while(counter <= 5);
    System.out.print(output);    
  }
}
