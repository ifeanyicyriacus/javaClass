public class AverageOfArray{
	public static void main(String[] args){
		double[] ages = {32, 45, 65, 77, 34, 54, 96, 86, 83, 82, 21, 46, 52, 84, 81};
		double sum = 0;
		int counter = 0;
		double average;
		
		System.out.print("[");
		while(counter < (ages.length-1)){
			sum += ages[counter];
			System.out.print(ages[counter]+ ", ");
			counter += 1;
		}
		System.out.println("]");
		
		average = sum / ages.length;
		System.out.printf("The average of this array integers is: %f%n", average);
		
	}
}
