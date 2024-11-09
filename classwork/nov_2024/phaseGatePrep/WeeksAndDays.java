public class WeeksAndDays{
	public static void main(String[] args){
		for(int index = 1; index <= 3; index += 1){
			System.out.printf("Week: %d%n", index);
			for(int index2 = 2; index2 <= 6; index2 += 2){
				System.out.printf("   Days: %d%n", index2);
			}
		}
		
	}
}
