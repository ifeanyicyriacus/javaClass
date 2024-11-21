import java.util.Scanner;
public class AirlineReservation{
	public static void main(String[] args){
	  Scanner input = new Scanner(System.in);
		boolean[] seatingChart = {
		false, false, false, false, false, false, false, false, false, false};
		int seat;
		final int FIRST_CLASS = 1;
		final int ECONOMY_CLASS = 2;
		
		int choice;
		String downgrade;
		int availableSeatNumber;
		
		for (int count= 0; count < 10; count += 1){
		  System.out.print("""
		  choose (1 or 2):
		  1. First class
		  2. Economy class
		  >>> """);
		  choice = input.nextInt();
		  
		  switch (choice){
		    case 1:
		      availableSeatNumber = available(seatingChart, FIRST_CLASS);
		      if (availableSeatNumber != -1){
		        seatingChart[availableSeatNumber] = true;
		        System.out.println(displayBoardingPass(availableSeatNumber));
		        continue;
		      } else{
		        availableSeatNumber = available(seatingChart, ECONOMY_CLASS);
		        if (availableSeatNumber != -1){
		          System.out.print("First class is not available\n do you want to downgrade to economy (y) yes or (n) no? ");
		          downgrade = input.next().toLowerCase();
		          if (downgrade.equals("y")){
		            seatingChart[availableSeatNumber] = true;
		            System.out.println(displayBoardingPass(availableSeatNumber));
		            continue;
		          } else{ 
		            System.out.print("Next flight will be in 3 hours");
		            count -= 1;
		            continue;
		          }
		        }
		      }
		      break;
		    case 2:
		      availableSeatNumber = available(seatingChart, ECONOMY_CLASS);
		      if (availableSeatNumber != -1){
		        seatingChart[availableSeatNumber] = true;
		        System.out.println(displayBoardingPass(availableSeatNumber));
		        continue;
		      } else{
		        availableSeatNumber = available(seatingChart, FIRST_CLASS);
		        if (availableSeatNumber != -1){
		          System.out.print("Economy class is not available\n do you want to upgrade to first class (y) yes or (n) no? ");
		          downgrade = input.next().toLowerCase();
		          if (downgrade.equals("y")){
		            seatingChart[availableSeatNumber] = true;
		            System.out.println(displayBoardingPass(availableSeatNumber));
		            continue;
		          } else{ 
		            System.out.println("Next flight will be in 3 hours");
		            count -= 1;
		            continue;
		          }
		        }
		      }
		      break;
		      default:
		        count -= 1;
		        System.out.println("Invalid Input, try again..");
		  }
		}
		
	}
	
	public static int available(boolean[] seatArray, int seatClass){
	  if (seatClass == 1){
	    for (int index = 0; index < 5; index += 1)
	      if (seatArray[index] == false)
	        return index;
		} else if (seatClass == 2){
		  for (int index = 5; index < 10; index += 1)
	      if (seatArray[index] == false)
	        return index;
	    }
	  return -1;
	}
	
	public static String displayBoardingPass(int seatNumber){
	  return (seatNumber < 5)? "You have been assigned seat number: "+ (seatNumber + 1) + " in First Class.\n":
	"You have been assigned seat number: "+ (seatNumber + 1) + " in Economy Class.\n";
	}
	
}
