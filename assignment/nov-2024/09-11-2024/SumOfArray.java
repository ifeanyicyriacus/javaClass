public class SumOfArray{
	public static void main(String[] args){
		int[] ages = {32, 45, 65, 77, 34, 54, 96, 86, 83, 82, 21, 46, 52, 84, 81};
		int sum = 0;
		int counter = 0;
		
		System.out.print("[");
		while(counter < (ages.length)){
			sum += ages[counter];
			System.out.print(ages[counter]+ ", ");
			counter += 1;
		}
		System.out.println("]");
		
		System.out.printf("The sum of the array integers is: %d%n", sum);
		
	}
}
