import java.util.Scanner;
public class MaxMinArray{
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
		double[] numbers = new double[7];
		double max;
    double min;
    
    
		
		System.out.println("Enter 7 numbers: ");
		for (int index = 0; index < (numbers.length); index += 1){
			System.out.printf("Enter no (%d of 7): ", index+1);
			numbers[index] = input.nextDouble();
		}
		
		max = numbers[0];
		min = numbers[0];
		System.out.println("You entered: ");
		System.out.print("[");
		for (int index = 0; index < (numbers.length); index += 1){
		  System.out.print(numbers[index] + ", ");
		  if (numbers[index] > max)
		    max = numbers[index];
		  if (numbers[index] < min)
		    min = numbers[index];	    
		}
		System.out.println("]");
		
		
		
		System.out.printf("The maximum number is: %f%n", max);
		System.out.printf("The minimum number is: %f%n", min);
		
	}
}
