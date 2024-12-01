import java.util.Scanner;
public class PizzaWahala{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    
    String[] pizzaTypes = {"Sapa size", "Small Money", "Big boys", "Odogwu"};
    int[] noOfSlices = {4, 6, 8, 12};
    double[] pricesPerBox = {2500, 2900, 4000, 5200};
    int pizzaTypeIndex = 0;
    int noOfGuest;
    String pizzaType;
    System.out.print("\033[2J");
    do{
	    if (pizzaTypeIndex == -1){
	      System.out.println("\033[2J\033[31mWrong input: select pizza type from menu and guests number must be at least 1, try Again\033[0m");
	    }
	    System.out.println(generatePizzaMenu(pizzaTypes, noOfSlices, pricesPerBox));
	    System.out.print("Enter the number of guest: ");
	    noOfGuest = input.nextInt();
	    System.out.print("Enter the type of pizza: ");
	    input.nextLine();
	    pizzaType = input.nextLine();

	    pizzaTypeIndex = getIndexOfPizzaType(pizzaTypes, pizzaType);
    }while(pizzaTypeIndex == -1);
    
    int slicePerPack = noOfSlices[pizzaTypeIndex];
    double pricePerPack = pricesPerBox[pizzaTypeIndex];
    int numberOfBox = determineNumberOfPack(noOfGuest, slicePerPack);
    String output = prepareOutput(pizzaType, slicePerPack, numberOfBox, pricePerPack, noOfGuest);
    System.out.print(output);
    
  }
  
  private static String generatePizzaMenu(String[] pizzaTypes, int[] noOfSlices, double[] pricesPerBox){
    String message = "\033[33m\033[1m\t\tIya Moses Pizza joint Ajegunle\n";
    message += String.format("| %15s | %15s | %15s |\n","Pizza type", "Number of Slices", "Price per box");
		message += String.format("+ %15s + %16s + %15s +\n", "-".repeat(15),"-".repeat(15),"-".repeat(15));
	  
	  for (int index = 0; index < pizzaTypes.length; index += 1){
		  message += String.format("| %15s | %16d | %15.2f |\n", pizzaTypes[index], noOfSlices[index], pricesPerBox[index]);
		  message += String.format("+ %15s + %16s + %15s +\n", "-".repeat(15),"-".repeat(15),"-".repeat(15));
		}
	  return message + "\033[0m";
  }

  private static String prepareOutput(String pizzaType, int slicePerPack, int numberOfBox, double pricePerPack, int noOfGuest){
	  int totalSlices = slicePerPack * numberOfBox;
	  double totalPrice = pricePerPack * numberOfBox;
	  int remainingSlice = totalSlices - noOfGuest;

	  String numberOfBoxText = numberOfBox + ((numberOfBox > 1) ? " boxes" : " box");
	  String numberOfGuestText = noOfGuest + ((noOfGuest > 1) ? " persons" : " person");
	  String remainingSliceText = remainingSlice + ((remainingSlice > 1) ? " slices" : " slice");
	  String slicesServedText = noOfGuest + ((noOfGuest > 1) ? " slices" : " slice");

	  String output = String.format("\n>>> Number of boxes of pizza to buy = %s ", numberOfBoxText);
	  output += String.format("\n(explaination: %s size contains %d slices per box, %s should be sufficient for %s as it would contain %d slices in all)\n", pizzaType, slicePerPack, numberOfBoxText, numberOfGuestText, totalSlices); 

	  output += String.format("\n>>> Number left over slices after serving = %s \n(explanation: After serving %s, you should have %s left)\n", remainingSliceText, slicesServedText, remainingSliceText);
	  output += String.format("\n>>> Price = %.2f \n(explanation: %.2f per box for %s)\n", totalPrice, pricePerPack, numberOfBoxText);
	  return output;
	}
  
  private static int getIndexOfPizzaType(String[] pizzaTypes, String pizzaType){
    for (int index = 0; index < pizzaTypes.length; index += 1){
		  if (pizzaTypes[index].equalsIgnoreCase(pizzaType)){
			  return index;
			}
		}
		return -1;
	}

  private static int determineNumberOfPack(int noOfGuest, int slicePerPack){
    return (int) (Math.ceil(noOfGuest / (double) slicePerPack));
  }
	
}
