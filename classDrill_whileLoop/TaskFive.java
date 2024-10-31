public class TaskFive{
	public static void main(String[] args){
		int i = 1; 
		while(i <= 10){
		  int j = 1;
		  while (j <= 5){
			  if (i%4 == 0){
				  System.out.print(i);
			  }
        j += 1;
      }
      if (i%4 == 0){System.out.print(" ");}
      i += 1;
		}
		System.out.println();
	}
}
