import java.util.Scanner;
public class RangeAndValue{
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
		int counter = 0;
		System.out.print("Enter start range: ");
		int min = input.nextInt();
		System.out.print("Enter stop range: ");
		int max = input.nextInt();
		System.out.print("Enter step: ");
		int step = input.nextInt();

		for(int i = min; min <= i && i <= max; i++){
			if (i % step == 0){counter +=1;}
		}
		System.out.println(counter);
	}
}