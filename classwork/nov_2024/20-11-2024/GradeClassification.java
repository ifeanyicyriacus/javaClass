import java.util.Scanner;
public class GradeClassification{
  public static void main(String[] args){
    int score;
    do{
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the student grade: ");
      score = input.nextInt();
    }while(!(score >= 0 && score <= 100));
    
    String classification;
    
    if (score >= 0 && score <= 33)
      classification = "Fail";
    else if (score <= 39)
      classification = "Pass";
    else if (score <= 59)
      classification = "Second class";
    else if (score <= 79)
      classification = "First class";
    else
      classification = "Distintion";
      
    System.out.printf("You got a %s.\n", classification);
    
  }
  
}
