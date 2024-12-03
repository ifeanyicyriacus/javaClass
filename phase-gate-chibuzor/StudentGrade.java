import java.util.Scanner;
import java.util.Arrays;

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
	  
	  System.out.println();
	  System.out.println(displayTheScoreSheet(scoreSheet, numberOfSubject));
	  System.out.println(displaySubjectSummary(scoreSheet, numberOfSubject));
	  System.out.println(displayClassSummary(scoreSheet, numberOfSubject));
	
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
	  int positionCol = scoreSheet[0].length - 1;
	  int averageCol = scoreSheet[0].length - 2;
	  double[] averages = pluckDoubleColumn(scoreSheet, averageCol);

	  int[] posRank = getRanks(averages);
	  for (int index = 0; index < scoreSheet.length; index += 1){
	    scoreSheet[index][positionCol] = posRank[index];
	  }
	}
	
	public static int[] getRanks(double[] numbers){
	  double[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
	  Arrays.sort(sortedNumbers);
	  int rank = numbers.length;
	  int[] result = new int[numbers.length];
	  for (int indexSorted = 0; indexSorted < sortedNumbers.length; indexSorted += 1){
	    for(int indexOriginal = 0; indexOriginal < numbers.length; indexOriginal += 1){
	      if (sortedNumbers[indexSorted] == numbers[indexOriginal]){
	        result[indexOriginal] = rank--;
	      }
	    }
	  }
	  return result;
	}
	
	public static String displaySubjectSummary(double[][] scoreSheet, int numberOfSubject){
	  String result = "SUBJECT SUMMARY\n";
	  int PASS_MARK = 50;

	    for (int index = 0; index < numberOfSubject; index += 1){
	      double[] subjectScores = pluckDoubleColumn(scoreSheet, index);
	      int highestSubjectIndex = getIndexOfHighest(subjectScores);
	      int lowestSubjectIndex = getIndexOfLowest(subjectScores);
	      double totalSubjectScore = getSumOfList(subjectScores, 0, subjectScores.length);
	      double subjectAverage = getAverageOf(subjectScores, 0, subjectScores.length);
	      int numberThatPasses = getNumbersThatPassed(subjectScores, PASS_MARK);
	      int numberThatFails = (subjectScores.length) - numberThatPasses;
	      double highestSubjectScore = scoreSheet[highestSubjectIndex][index];
	      double lowestSubjectScore = scoreSheet[lowestSubjectIndex][index];
	      
	      result += String.format("Subject %d%n", (index+1));
	      result += String.format("Highest scoring student is: Student %d scoring %.0f%n", (highestSubjectIndex + 1), highestSubjectScore);
	      result += String.format("Highest scoring student is: Student %d scoring %.0f%n", (lowestSubjectIndex + 1), lowestSubjectScore);
	      result += String.format("The total score is: %.0f%n", totalSubjectScore);
	      result += String.format("Average Score is: %.0f%n", totalSubjectScore);
	      result += String.format("Number of passes: %d%n", numberThatPasses);
	      result += String.format("Number of fails: %d%n%n", numberThatFails);
	    }
	  return result;
	}
	
	public static int getIndexOfHighest(double[] column){//TODO
	  return 1;
	}
	
	public static int getIndexOfLowest(double[] column){//TODO
	  return 1;
	}
		public static int getIndexOfHighest(int[] column){//TODO
	  return 1;
	}
	
	public static int getIndexOfLowest(int[] column){//TODO
	  return 1;
	}
	
	public static int getNumbersThatPassed(double[] column, int passMark){
	  int passCount = 0;
	  for (double value: column){
	    if (value >= passMark){ passCount += 1; }
	  }
	  return passCount;
	}
	
	public static double[] pluckDoubleColumn(double[][] table, int columnNumber){
	  double[] result = new double[table.length];
	  for (int index = 0; index < table.length; index += 1){
	    result[index] = table[index][columnNumber];
	  }
	  return result;
	}
	
	
	public static String displayClassSummary(double[][] scoreSheet, int numberOfSubject){
	
	  int hardestSubjectIndex = getHardestSubject(scoreSheet, numberOfSubject);
	  int easiestSubjectIndex = getEasiestSubject(scoreSheet, numberOfSubject);
    int[] passes = subjectToPassList(scoreSheet, numberOfSubject);
    int hardestSubjectFails = numberOfSubject - passes[hardestSubjectIndex];
	  int easiestSubjectPasses = passes[easiestSubjectIndex];
	  
	  
	  //let the overall function return a 1x3 array
	  //overallHighestScore
	  //overallHighestScoreSubject
	  //overallHighestScoreStudent
	  //overallLowestScore
	  //overall lowest scote subject
	  //overall lowest score student
	  
	
	  
	  String result = String.format("The hardest subject is Subject %d with %d failures%n", (hardestSubjectIndex+1), hardestSubjectFails);
	  result += String.format("The easiest subject is Subject %d with %d passes%n", easiestSubjectIndex, easiestSubjectPasses);
	  result += String.format("The overall Highest score is scored by student %d in");
	  
	  return "";
	}
	
	
	
	public static double[][] flipTable(double[][] table, int startRow, int stopRow, int startCol, int stopCol){
	  double[][] flippedTable = new double[startCol - stopCol][stopRow - startRow];
	  int flipRowIndex = 0; int flipColIndex = 0;
	  for (int rowIndex = startRow; rowIndex < stopRow; rowIndex += 1){
	    for (int colIndex = startCol; colIndex < stopCol; stopCol += 1){
	      flippedTable[flipColIndex][flipRowIndex] = table[rowIndex][colIndex];
	      flipRowIndex += 1;
	    }
	    flipColIndex += 1;
	  }
	  return flippedTable;
	}
	
	public static int getHardestSubject(double[][] scoreSheet, int numberOfSubject){
	  int[] passes = subjectToPassList(scoreSheet, numberOfSubject);
	  return getIndexOfLowest(passes);
	}
	
	public static int getEasiestSubject(double[][] scoreSheet, int numberOfSubject){    
	  int[] passes = subjectToPassList(scoreSheet, numberOfSubject);
	  return getIndexOfHighest(passes);
	}
	
	public static int[] subjectToPassList(double[][] scoreSheet, int numberOfSubject){
	  int numberOfStudent = scoreSheet.length;
	  double[][] flippedTable = flipTable(scoreSheet, 0, numberOfSubject, 0, numberOfSubject);
	  int[] passes = new int[numberOfSubject];
	  int index = 0;
	  for (double[] subjectScores : flippedTable){
	    passes[index++] = getNumbersThatPassed(subjectScores, 50);
	  }
	  return passes;
	}
	
	public static int getBestStudentIndex(double[][] scoreSheet, int colIndex){
	  double[] totalsColumn = pluckDoubleColumn(scoreSheet, colIndex);
	  return getIndexOfHighest(totalsColumn);
	}
	
	public static int getWorstStudentIndex(double[][] scoreSheet, int colIndex){
	  double[] totalsColumn = pluckDoubleColumn(scoreSheet, colIndex);
	  return getIndexOfLowest(totalsColumn);
	}
	
	public static double getClassTotalScore(double[][] scoreSheet, int colIndex){
	  double[] totalsColumn = pluckDoubleColumn(scoreSheet, colIndex);
	  return getSumOfList(totalsColumn, 0, totalsColumn.length);
	}
	
	public static double getClassAverageScore(double[][] scoreSheet, int colIndex){
	  double[] averageColumn = pluckDoubleColumn(scoreSheet, colIndex);
	  return getAverageOf(averageColumn, 0, averageColumn.length);
	}	
	
	
	
}
