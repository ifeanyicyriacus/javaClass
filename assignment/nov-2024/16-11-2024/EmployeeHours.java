public class EmployeeHours{
	public static void main(String[] args){
		int[][] employeesHourArray = {
	    {2, 4, 3, 4, 5, 8, 8},
	    {7, 3, 4, 3, 3, 4, 4},
	    {3, 3, 4, 3, 3, 2, 2},
	    {9, 3, 4, 7, 3, 4, 1},
	    {3, 5, 4, 3, 6, 3, 8},
	    {3, 4, 4, 6, 3, 4, 4},
	    {3, 7, 4, 8, 3, 8, 4},
	    {6, 3, 5, 9, 2, 7, 9}
    };
		System.out.println("Original employee's time sheet:");
    System.out.print(display(employeesHourArray));
    
    int size = employeesHourArray.length;
    int[][] totalArray = new int[size][2];
    
    for(int index = 0; index < size; index += 1){
      int sum = 0;
      for(int hours: employeesHourArray[index]){
        sum += hours;
      }
      totalArray[index][0] = index;
      totalArray[index][1] = sum;
    }
    
    for(int indexA = 0; indexA < size; indexA += 1){
      for(int indexB = indexA; indexB < size; indexB += 1){
        if (totalArray[indexA][1] < totalArray[indexB][1]){
          int[] temp = totalArray[indexB];
          int[] tempArray = employeesHourArray[indexB];
          
          totalArray[indexB] = totalArray[indexA];
          employeesHourArray[indexB] = employeesHourArray[indexA];
          
          totalArray[indexA] = temp;
          employeesHourArray[indexA] = tempArray;
          
          indexA = 0;
        }
        
      }
    }
		System.out.println("\nEmployee's time sheet ordered my total hour:");
    System.out.print(display(employeesHourArray, totalArray));
	}
	
	public static String display(int[][] intList){
		String list ="\t\tSu  M   T   W   Th  F   Sa\n";
    int size = intList.length;
		for(int index = 0; index < size; index += 1){
		  list += "Employee "+ index + "\t";
		  for(int number: intList[index]){
			  list += (number+ "   ");
		  }
		  list += "\n";
		}
		return list;
	}

	public static String display(int[][] intList, int[][] total){
		String list ="\t\tSu  M   T   W   Th  F   Sa  Total\n";
    int size = intList.length;
		for(int index = 0; index < size; index += 1){
		  list += "Employee "+ total[index][0] + "\t";
		  for(int number: intList[index]){
			  list += (number+ "   ");
		  }
		  list += total[index][1] +"\n";
		}
		return list;
	}
}
