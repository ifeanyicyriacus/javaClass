import java.util.Scanner;

public class StudentGrade{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int NUMBER_OF_COLUMN_NEEDED = 3; 
		System.out.println("Lagbaja Schools");
		
		System.out.print("Enter number of students: ");
		int numberOfStudent = input.nextInt();
		System.out.print("Enter number of subjects: ");
		int numberOfSubject = input.nextInt();
		
		System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
		
		double[][] scoreSheet = new double[numberOfStudent][NUMBER_OF_COLUMN_NEEDED + numberOfSubject];
	  
	  for(int studentIndex = 0; studentIndex < numberOfStudent; studentIndex += 1){
	    for(int subjectIndex = 0; subjectIndex < numberOfSubject; subjectIndex += 1){
	      System.out.printf("Entering score for student %d\n", (studentIndex + 1));
	      System.out.printf("Enter score for subject %d: \n", (subjectIndex + 1));
	      scoreSheet[studentIndex][subjectIndex] = input.nextDouble();
	      System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>\nSaved Succesfully");
	    }
	  }
	  
	  System.out.println(displayTheScoreSheet(scoreSheet, numberOfSubject));
	  
	
	
	}
	
	public static String displayTheScoreSheet(double[][] scoreSheet, int numberOfSubject){
	  addTotalToSheet(scoreSheet, numberOfSubject);
	  addAverageToSheet(scoreSheet, numberOfSubject);
	  addPositionToSheet(scoreSheet);
	  
    String output = String.format("%s%n", "=".repeat(50));
	  output += String.format("%15s  ", "STUDENT");
	  for(int index = 1; index <= numberOfSubject; index += 1){
	    output += String.format("%5s  ","SUB "+index);
	  }
	  output += String.format("%5s  %5s  %5s%n", "TOT", "AVE", "POS");
    output += String.format("%s%n", "=".repeat(50));
	  
	  
	  for(int studentIndex = 0; studentIndex < scoreSheet.length; studentIndex += 1){
	    output += String.format("%15s  ", ("Student "+ (studentIndex+1)));
	    
	    for(int subjectIndex = 0; subjectIndex <= numberOfSubject; subjectIndex += 1){
	      output += String.format("%5.0f  ", scoreSheet[studentIndex][subjectIndex]);
	    }
      int length = scoreSheet[studentIndex].length;
	    output += String.format("%5.2f  ", scoreSheet[studentIndex][length - 2]);
	    output += String.format("%5.0f  ", scoreSheet[studentIndex][length - 1]);
	    
	    output += "\n";
	  }
    output += String.format("%s%n", "=".repeat(50));
    output += String.format("%s%n", "=".repeat(50));
	  return output;
	}
	
	public static void addTotalToSheet(double[][] scoreSheet, int numberOfSubject){
	  int totalCol = numberOfSubject;
	  
	  for(double[] studentScores: scoreSheet){
	    double total = getSumOfList(studentScores, 0, numberOfSubject);
	    studentScores[totalCol] = total;
	  }
	}
	
	public static double getSumOfList(double[] list, int start, int stop){
	  double sum = 0;
	  for(int index = start; index < stop; index += 1){
	    sum += list[index];
	  }
	  return sum;
	}
	
	public static void addAverageToSheet(double[][] scoreSheet, int numberOfSubject){
	  int averageCol = numberOfSubject + 1;
		for(double[] studentScores: scoreSheet){
	    double average = getAverageOf(studentScores, 0, numberOfSubject);
	    studentScores[averageCol] = average;
	  }
	}
	
	public static double getAverageOf(double[] list, int start, int stop){
	  int noOfvalues = stop - start;
	  double sum = getSumOfList(list, start, stop);
	  return (sum / (double)noOfvalues);
	}
	
	public static void addPositionToSheet(double[][] scoreSheet){
	  //int positionCol = scoreSheet[0].length - 1;
	  
	  
	  for first student total
	    find position in an array of sorted totals
	  
	}
	
	
}
