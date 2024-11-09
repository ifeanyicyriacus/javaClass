import java.util.Scanner;
public class AwardSelection{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("""
		Select from the options (1-4) below your rank 
		1: Gold Medal
		2: Silver Medal
		3. Bronze Medal
		4. Participant Ribbon
		>>>>  """);
		int awardNumber = input.nextInt();
		
		switch(awardNumber){
			case 1:
				System.out.println("Gold Medal");
				break;
			case 2:
				System.out.println("Silver Medal");
				break;
			case 3:
				System.out.println("Bronze Medal");
				break;
			case 4:
				System.out.println("Participant Ribbon");
				break;
			default:
				System.out.println("Wrong input, Try agin.");
		}
		
		
	}
}
