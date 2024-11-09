import java.util.Scanner;
public class DessertMenu{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    

    String message1 = """
    Please Select your dessert choice:
    1. Ice cream
    2. Sundea
    3. Shake
    >>>""";
    String message2= """
    Please Select your flavour choice:
    1. Chocolate
    2. Vanilla
    3. Strawberry
    >>> """;
    int dessert;
    int flavour;
    
    System.out.print(message1);
    dessert = input.nextInt();
    switch(dessert){
		case 1:
			System.out.print(message2);
			flavour = input.nextInt();
		    switch(flavour){
				case 1:
					System.out.println("You have selected the yummy Chocolate flavoured Ice cream");
					break;
			  	case 2:
			  		System.out.println("You have selected the yummy Vanilla flavoured Ice cream");
					break;
				case 3:
					System.out.println("You have selected the yummy Strawberry flavoured Ice cream");
					break;
				default:
					System.out.println("Wrong flavour input, Try agin.");
			  }
        break;
	  	case 2:
  			System.out.print(message2);
		  	flavour = input.nextInt();
		  	switch(flavour){
				case 1:
					  System.out.println("You have selected the delightfull Chocolate flavoured Shake");
					  break;
			    	case 2:
			    		System.out.println("You have selected the delightfull Vanilla flavoured Shake");
					  break;
				  case 3:
					  System.out.println("You have selected the delightfull Strawberry flavoured Shake");
					  break;
				  default:
					  System.out.println("Wrong flavour input, Try agin.");
			  }
        break;
		  case 3:
			  System.out.print(message2);
			  flavour = input.nextInt();
			  switch(flavour){
				  case 1:
					  System.out.println("You have selected the fabulous Chocolate flavoured Shake");
					  break;
			    	case 2:
			    		System.out.println("You have selected the fabulous Vanilla flavoured Shake");
					  break;
				  case 3:
					  System.out.println("You have selected the fabulous Strawberry flavoured Shake");
					  break;
				  default:
					  System.out.println("Wrong flavour input, Try agin.");
			  }
        break;
		  default:
			  System.out.println("Wrong Department input, Try agin.");
    }
    
    
    
    
    
  }
}
