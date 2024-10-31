public class TaskNine{
	public static void main(String[] args){
		int sum = 0; int i = 1;
		while(i <= 10){
      int k = 1; int j = 1; 
		  while (j <= 5){
			  if (i%4 == 0){
				  sum += (int)Math.pow(i, k);
				  k += 1;
			  }
			  j += 1;
      }
      i += 1;
		}
		long sumSquared = (long)Math.pow(sum, 2);
    System.out.println(sumSquared);
	}
}
