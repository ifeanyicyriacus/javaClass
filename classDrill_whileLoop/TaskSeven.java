public class TaskSeven{
	public static void main(String[] args){
		int i = 1; 
		while(i <= 10){
      int k = 1; int sum = 0;
      int j = 1;
		  while (j <= 5){
			  if (i%4 == 0){
				  sum += (int)Math.pow(i, k);
				  k += 1;
			  }
			  j += 1;
      }
      
      if (sum != 0){System.out.print(sum + " ");}
      sum = 0;
      i += 1;
		}
		System.out.println();
	}
}
