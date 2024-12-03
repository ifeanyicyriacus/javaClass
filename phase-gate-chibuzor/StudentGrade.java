public class StudentGrade{
	public static void main(String[] args){
		Scanner input = new Scanner()
		int NUMBER_OF_COLUMN_NEEDED = 3; 
		System.out.println("Lagbaja Schools");
		
		System.out.print("Enter number of students");
		int numberOfStudent = input.nextInt();
		System.out.print("Enter number of subjects");
		int numberOfSubject = input.nextInt();
		
		System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
		
		int[][] scoreSheet = new int[numberOfStudent][NUMBER_OF_COLUMN_NEEDED + numberOfSubject];
	  
	  for(int studentIndex = 0; studentIndex < numberOfStudent; studentIndex += 1){
	    for(int subjectIndex = 0; subjectIndex < numberOfSubject; subjectIndex += 1){
	      System.out.printf("Entering score for student %d\n", (studentIndex + 1));
	      System.out.printf("Enter score for subject %d: \n", (subjectIndex + 1));
	      scoreSheet[studentIndex][subjectIndex] = input.nextInt();
	      System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
	    }
	  }
	  
	  println(displayTheScoreSheet(scoreSheet, numberOfSubject));
	  
	
	
	}
	
	public static String displayTheScoreSheet(int[][] scoreSheet, int numberOfSubject){
	  //addTotalToSheet();
	  //addAverageToSheet();
	  addPositionToSheet();
	  
    output += String.format("%s%n", "=".repeat(50));
	  output += String.format("%15s", "STUDENT")
	  for(int index = 1; index <= numberOfSubject; index += 1){
	    output += String.format("%5s","SUB "+index);
	  }
	  output += String.format("%5s%5s%5s%n", "TOT", "AVE", "POS");
    output += String.format("%s%n", "=".repeat(50));
	  
	  
	  for(int studentIndex = 0; studentIndex < scoreSheet.length; studentIndex += 1){
	    output += String.format("%15s", ("Student "+ studentIndex+1));
	    for(int subjectIndex = 0; studentIndex < scoreSheet[].length; studentIndex += 1){
	      output += String.format("%5d", scoreSheet[studentIndex][subjectIndex]);
	    }
	    output += "\n";
	  }
    output += String.format("%s%n", "=".repeat(50));
    output += String.format("%s%n", "=".repeat(50));
	  return output;
	}
	
	

}
