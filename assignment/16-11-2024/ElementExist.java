public class ElementExist{
	public static void main (String[] args){
		int[] sample = {23, 32, 45, 76, 32, 32, 87, 87, 100, 32, 10};
		int element = 77;
		String test = (isExist(sample, element)) ? "True" : "False";
		String sampleList = arrayToStringList(sample);
		System.out.printf("Does [%d] exist in: [%s]%n%s%n", element, sampleList, test);
	}
	
	public static boolean isExist(int[] intList, int element){
	  for (int number : intList){
	    if (number == element){
	      return true;
	    }
	  }
	  return false;
	}
	
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
