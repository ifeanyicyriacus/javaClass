public class TaskSix{
	public static void main(String[] args){
		
		for(int i = 1; i <= 10; i += 1){
      int k = 1;
		  for (int j = 1; j <= 5; j += 1){
			  if (i%4 == 0){
				  System.out.print((int)Math.pow(i, k)+" ");
				  k += 1;
			  }	  
      }
		}
		System.out.println();
	}
}