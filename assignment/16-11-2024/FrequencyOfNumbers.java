import java.util.Arrays;
import java.util.ArrayList;

public class FrequencyOfNumbers{
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int[] sample = {23, 32, 10, 45, 76, 32, 32, 87, 87, 100, 32, 10};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
		Arrays.sort(sample);
		System.out.println("Sorted array list:");
		System.out.println(arrayToStringList(sample));
		
		int previousElement = sample[0];
		int frequency = 1;
		for(int index = 1; index < sample.length; index += 1){
		  if (previousElement == sample[index]){
		    frequency += 1;
		  }else {
		    result.add(new ArrayList<Integer>(Arrays.asList(previousElement, frequency)));
		    frequency = 1;
		    previousElement = sample[index];
		  }
		}
			result.add(new ArrayList<Integer>(Arrays.asList(previousElement, frequency)));
		  
		  for(int index = 0; index < result.size(); index += 1){
		    int tempSample = result.get(index).get(0);
		    int tempFrequency = result.get(index).get(1);
		    if (tempFrequency > 1){
		      System.out.printf("%d occurs %d times%n", tempSample, tempFrequency);
		    }else{
		      System.out.printf("%d occur %d time%n", tempSample, tempFrequency);
		    }  
		  }

	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
