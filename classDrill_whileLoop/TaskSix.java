public class TaskSix{
	public static void main(String[] args){
		int i = 1;
		while(i <= 10){
      int k = 1; int j = 1;
		  while (j <= 5){
			  if (i%4 == 0){
				  System.out.print((int)Math.pow(i, k)+" ");
				  k += 1;
			  }	  
			  j += 1;
      }
      i += 1;
		}
		System.out.println();
	}
}
