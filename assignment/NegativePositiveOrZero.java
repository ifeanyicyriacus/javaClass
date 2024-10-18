import java.util.Scanner;
/** Counts the number of +ve, -ve and zeros value in set of five numbers
*@author Ifeanyi Cyriacus
*/
public class NegativePositiveOrZero{
  /**
  *@param args
  *@return void
  */
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the first number: ");
	  float num1 = input.nextFloat();
	  System.out.print("Enter the second number: ");
	  float num2 = input.nextFloat();
	  System.out.print("Enter the third number: ");
	  float num3 = input.nextFloat();
	  System.out.print("Enter the forth number: ");
	  float num4 = input.nextFloat();
	  System.out.print("Enter the fifth number: ");
	  float num5 = input.nextFloat();
	  //initializing my three counters
	  int positivesCount = 0; int negativesCount = 0; int zerosCount = 0;
	  //testing and incrementing
	  if (num1 > 0){ positivesCount += 1;}
	  else if (num1 < 0){ negativesCount += 1;}
	  else {zerosCount += 1;}
	  if (num2 > 0){ positivesCount += 1;}
	  else if (num2 < 0){ negativesCount += 1;}
	  else {zerosCount += 1;}
	  if (num3 > 0){ positivesCount += 1;}
	  else if (num3 < 0){ negativesCount += 1;}
	  else {zerosCount += 1;}
	  if (num4 > 0){ positivesCount += 1;}
	  else if (num4 < 0){ negativesCount += 1;}
	  else {zerosCount += 1;}
	  if (num5 > 0){ positivesCount += 1;}
	  else if (num5 < 0){ negativesCount += 1;}
	  else {zerosCount += 1;}
	  System.out.printf("Positive numbers: %d%nNegative numbers: %d%nZeros: %d%n", positivesCount, negativesCount, zerosCount);
	}
}
