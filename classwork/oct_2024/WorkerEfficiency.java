import java.util.Scanner;
public class WorkerEfficiency{
	public static void main(String[] args){
	  	Scanner input = new Scanner(System.in);
	  	System.out.print("Enter the time taken by worker to complete a particular job: ");
	  	int timeTaken = input.nextInt();
	  	
	  	if(2 <= timeTaken && timeTaken <= 3){
	  	  System.out.println("The worker is highty efficent");
	  	}else if (3 <= timeTaken && timeTaken <= 4){
	  	  System.out.println("The worker should improve speed");
	  	}else if (4 <= timeTaken && timeTaken <= 5){
	  	  System.out.println("The worker should be given training to improve speed");
	  	}else if (timeTaken > 5){
	  	  System.out.println("The worker should leave the company");
	  	}	  	
	}
}
