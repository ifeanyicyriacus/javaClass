public class Diamond{
	public static void main(String[] args){
		
		int counterA = 5;
		int counterB = 1;
		int counterC = 5;
		while(counterA >= 0 ){
			System.out.print(" ".repeat(counterC));
			System.out.print("*".repeat(counterB));
			counterC -= 1;
			counterB += 2;
		  System.out.println();
			counterA--;		
		}
		counterC = 1; counterB = 9;
		while(counterA >= -5 ){
	    System.out.print(" ".repeat(counterC));
	    System.out.print("*".repeat(counterB));
	    counterC += 1;
      System.out.println();
	    counterB -= 2;
	    counterA--;		
    }
	}
}
