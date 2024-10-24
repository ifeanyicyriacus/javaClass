import java.util.Scanner;
public class DayMonthYear{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	
	System.out.print("Input a month number: ");
	int monthNumber = input.nextInt();
	System.out.print("Input a year: ");
	int year = input.nextInt();
	
	String monthName =""; int numberOfDays = 0;
	if (monthNumber == 1){monthName = "January";numberOfDays = 31;}
	else if(monthNumber == 2){monthName = "February";numberOfDays = 28;}
	else if(monthNumber == 3){monthName = "March";numberOfDays = 31;}
	else if(monthNumber == 4){monthName = "April";numberOfDays = 30;}
	else if(monthNumber == 5){monthName = "May";numberOfDays = 31;}
	else if(monthNumber == 6){monthName = "June";numberOfDays = 30;}
	else if(monthNumber == 7){monthName = "July";numberOfDays = 31;}
	else if(monthNumber == 8){monthName = "August";numberOfDays = 31;}
	else if(monthNumber == 9){monthName = "September";numberOfDays = 30;}
	else if(monthNumber == 10){monthName = "October";numberOfDays = 31;}
	else if(monthNumber == 11){monthName = "November";numberOfDays = 30;}
	else if(monthNumber == 12){monthName = "December";numberOfDays = 31;}

	if (year % 4 == 0 && monthNumber == 2){
		numberOfDays = 29;
	}
	System.out.printf("%s %d has %d days\n", monthName, year, numberOfDays);
	
	
	
	
	
	
	
	
	
	}
}
