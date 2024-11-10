import java.util.Scanner;
public class MBTIPersonalityTest{
	public static void main(String[] args){
	  final int A = 0;
	  final int B = 1;
	  Scanner input = new Scanner(System.in);
	  
	  int[] answers = new int[20];
	  String[][] questions = {{"A. expend energy, enjoy groups", "B. conserve energy, enjoy one-on-one"},
	    {"A. interpret literally", "B. look for meaning and possibilities"},
	    {"A. logical, thinking, questioning", "B. empathetic, feeling, accommodating"},
	    {"A. organized, orderly", "B. flexible, adaptable"},
	    {"A. more outgoing, think out loud", "B. more reserved, think to yourself"},
	    {"A. practical, realistic, experiential", "B. imaginative, innovative, theoretical"},
	    {"A. candid, straight forward, frank", "B. tactful, kind, encouraging"},
	    {"A. plan, schedule", "B. unplanned, spontaneous"},
	    {"A. seek many tasks, public activities, interaction with others", "B. seek private, solitary activities with quiet to concentrate"},
	    {"A. standard, usual, conventional", "B. different, novel, unique"},
	    {"A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate"},
	    {"A. regulated, structured", "B. easygoing, \"live\" and \"let live\""},
	    {"A. external, communicative, express yourself", "B. internal, reticent, keep to yourself"},
	    {"A. focus on here-and-now", "B. look to the future, global perspective, \"big picture\""},
	    {"A. tough-minded, just", "B. tender-hearted, merciful"},
	    {"A. preparation, plan ahead", "B. go with the flow, adapt as you go"},
	    {"A. active, initiate", "B. reflective, deliberate"},
	    {"A. facts, things, \"what is\"", "B. ideas, dreams, \"what could be,\" philosophical"},
	    {"A. matter of fact, issue-oriented", "B. sensitive, people-oriented, compassionate"},
	    {"A. control, govern", "B. latitude, freedom"}};
	  

	  
	  System.out.println("The Myers-Briggs Type Indicator (MBTI) Personality Test");
    System.out.println("Only 10 minutes to get a “freakishly accurate” description of who you are and why you do things the way you do.");
	  System.out.print("What is your Full name? ");
	  String fullName = input.nextLine();
    System.out.printf("%nHello %s, In this test, you will be presented with a series of 20 questions, and you must select the option (A or B) that best describes your personality.%n", (fullName.split(" ")[0]));
	  System.out.println("-".repeat(60));
	  
	   
	  for(int index = 0; index < answers.length; ){
	    System.out.printf("%s\n%s\n", questions[index][0], questions[index][1]);
	    if (index != 0){
	      System.out.println("0. previous question");
	    }
	    System.out.print("\n>>> ");
	    String answer = input.next();
	    System.out.println();
	    switch(answer.toUpperCase()){
	    case "A":
	      answers[index] = A;
	      index += 1;
	      break;
	    case "B":
	      answers[index] = B;
	      index += 1;
	      break;
	    case "0":
	      if (index != 0) {index -= 1;}
	    default:
	      System.out.println("The expected response was A or B; I realise this is an error. Please try again.");
	      break;
	    }
	  }
	  
	  String personalityType = "";
	  //make BOLD Extroverted(A) vs Introverted (B):
	  //make ITALIC How you focus your attention and energy.
    String[] personalityGroup = {
      "\033[4mExtroverted(A) vs Introverted (B): How you focus your attention and energy.\033[0m",
      "\033[4mSensing(A) vs Intuititive(B): How you perceive and process information.\033[0m",
      "\033[4mThinking(A) vs Feeling(B): How you make decisions.\033[0m",
      "\033[4mJudging(A) vs Perceptive(B): How you approach structure and planning.\033[0m"
    };
    char[][] personalityPreferences = {{'E', 'I'}, {'S', 'N'}, {'T', 'F'}, {'J', 'P'}};
    
	  int[] totalAnswerInGroup = new int[4];

	  System.out.printf("Hello %s, you selected these options:%n", fullName);
	  for (int groupIndex = 0; groupIndex <= 3; groupIndex += 1){
	    System.out.printf("For %s you selected: %n", personalityGroup[groupIndex]);
	    
	    for (int answerIndex = groupIndex; answerIndex < answers.length; answerIndex += 4){
	      totalAnswerInGroup[groupIndex] += answers[answerIndex];
	      if (answers[answerIndex] == A){
	        System.out.println(questions[answerIndex][A]);
	      }else{
	        System.out.println(questions[answerIndex][B]);
	      }
	    }
      System.out.printf("Number of A selected: %d%n", (5 - totalAnswerInGroup[groupIndex]));
      System.out.printf("Number of B selected: %d%n", (totalAnswerInGroup[groupIndex]));
      System.out.println();
      
      
      personalityType += (totalAnswerInGroup[groupIndex] <= 2 && groupIndex == 0)?
        personalityPreferences[groupIndex][0]:
        personalityPreferences[groupIndex][1];
	  }
	  
	  MBTIPersonalityInformation summary = new MBTIPersonalityInformation();
	  System.out.println(summary.getPersonalityTypeSummary(personalityType));
    System.out.println(summary.getSources());
	  
	
	
	
	}
}
