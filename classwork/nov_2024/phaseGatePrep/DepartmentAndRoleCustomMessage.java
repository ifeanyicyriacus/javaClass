import java.util.Scanner;
public class DepartmentAndRoleCustomMessage{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    

    String message1 = """
    Please Select your Department:
    1. IT
    2. HR
    3. Finance
    >>>""";
    String message2= """
    Please Select your Department:
    1. Manager
    2. Analyst
    3. Intern
    >>> """;
    int department;
    int role;
    
    System.out.print(message1);
    department = input.nextInt();
    switch(department){
		case 1:
			System.out.print(message2);
			role = input.nextInt();
		    switch(role){
				case 1:
					System.out.println("Good job as a Manager in IT department");
					break;
			  	case 2:
			  		System.out.println("Good job as a Analyst in IT department");
					break;
				case 3:
					System.out.println("Good job as a Intern in IT department");
					break;
				default:
					System.out.println("Wrong role input, Try agin.");
			}
        	break;
	  	case 2:
	  		System.out.print(message2);
			role = input.nextInt();
			switch(role){
				case 1:
					System.out.println("Good job as a Manager in HR department");
					break;
			  	case 2:
			  		System.out.println("Good job as a Analyst in HR department");
					break;
				case 3:
					System.out.println("Good job as a Intern in HR department");
					break;
				default:
					System.out.println("Wrong role input, Try agin.");
			}
        	break;
		case 3:
			System.out.print(message2);
			role = input.nextInt();
			switch(role){
				case 1:
					System.out.println("Good job as a Manager in Finance department");
					break;
			  	case 2:
			  		System.out.println("Good job as a Analyst in Finance department");
					break;
				case 3:
					System.out.println("Good job as a Intern in Finance department");
					break;
				default:
					System.out.println("Wrong role input, Try agin.");
			}
        	break;
		default:
			System.out.println("Wrong Department input, Try agin.");
    }
    
    
    
    
    
  }
}
