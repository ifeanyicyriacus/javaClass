public class TaskNine{
	public static void main(String[] args){
		int sum = 0;
		for(int i = 1; i <= 10; i += 1){
      int k = 1; 
      
		  for (int j = 1; j <= 5; j += 1){
			  if (i%4 == 0){
				  sum += (int)Math.pow(i, k);
				  k += 1;
			  }
      }
      
		}
		long sumSquared = (long)Math.pow(sum, 2);
    System.out.println(sumSquared);
	}
}
