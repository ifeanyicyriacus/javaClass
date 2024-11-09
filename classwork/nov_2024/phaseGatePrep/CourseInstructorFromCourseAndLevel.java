import java.util.Scanner;
public class CourseInstructorFromCourseAndLevel{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    

    String message1 = """
    Please Select your course:
    1. Math
    2. Science
    3. History
    >>>""";
    String message2= """
    Please Select your grade level:
    1. Freshman
    2. Sophomore
    3. Junior
    4. Senior
    >>> """;
    int course;
    int level;
    
    System.out.print(message1);
    course = input.nextInt();
    switch(course){
		case 1:
			System.out.print(message2);
			level = input.nextInt();
		  switch(level){
				case 1:
					System.out.println("For Freshman in taking Math your instructor is Mr. Chibuzor");
					break;
			  	case 2:
			  		System.out.println("For Sophomore in taking Math your instructor is Mr. Chibuzor");
					break;
				case 3:
					System.out.println("For Junior in taking Math your instructor is Mr. Asa");
					break;
				case 4:
					System.out.println("For Senior in taking Math your instructor is Mr. Sam");
					break;
				default:
					System.out.println("Wrong grade level input, Try agin.");
			}
        	break;
	  	case 2:
	    	System.out.print(message2);
			  level = input.nextInt();
			switch(level){
				case 1:
					System.out.println("For Freshman in taking Science your instructor is Mr. Ifeanyi");
					break;
			  	case 2:
			  		System.out.println("For Sophomore in taking Science your instructor is Mr. Chibuzor");
					break;
				case 3:
					System.out.println("For Junior in taking Science your instructor is Mr. Alfred");
					break;
				case 4:
					System.out.println("For Senior in taking Science your instructor is Mr. Sam");
					break;
				default:
					System.out.println("Wrong grade level input, Try agin.");
			}
        	break;
		  case 3:
			  System.out.print(message2);
			  level = input.nextInt();
			switch(level){
				case 1:
					System.out.println("For Freshman in taking History your instructor is Mr. Chibuzor");
					break;
			  	case 2:
			  		System.out.println("For Sophomore in taking History your instructor is Miss. Jeneffer");
					break;
				case 3:
					System.out.println("For Junior in taking History your instructor is Miss. Kim");
					break;
				case 4:
					System.out.println("For Senior in taking History your instructor is Mrs. Ashley");
					break;
				default:
					System.out.println("Wrong grade level input, Try agin.");
			}
        	break;
		default:
			System.out.println("Wrong course input, Try agin.");
    }
    
    
    
    
    
  }
}
