import java.util.Scanner;
public class GreatPyramid{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the estimated number of stones: ");
    int numberOfStone = input.nextInt();
    System.out.print("Enter the average weight of each stone (in Kg): ");
    float averageStoneWeight = input.nextFloat();
    System.out.print("Enter the number of years it took to build: ");
    float buildTimeInYears = input.nextFloat();
    
    float totalWeightOfStone = numberOfStone * averageStoneWeight;
    float weightPerYear = totalWeightOfStone / buildTimeInYears;
    float weightPerHour = (weightPerYear / 365 * 24);
    float weightPerMinute = weightPerHour / 60;
    
    System.out.printf("Weight per year= %.0f%n", weightPerYear);
    System.out.printf("Weight per hour= %.0f%n", weightPerHour);
    System.out.printf("Weight per minute= %.0f%n",weightPerMinute);
  }
}
