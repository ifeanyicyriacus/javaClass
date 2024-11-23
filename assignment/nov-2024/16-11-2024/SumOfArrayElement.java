public class SumOfArrayElement {
	public static void main(String[] args){
		int[] sample = {23, 32, 45, 76, 32, 32, 87, 87, 100, 32, 10};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
    
    int sum = getSum(sample);
		System.out.printf("The Sum of the Array is: %d%n", sum);
	}
	
	public static int getSum(int[] intList){
		int sum = 0;
		for(int number: intList){
			sum += number;
		}
		return sum;
	}
	
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
