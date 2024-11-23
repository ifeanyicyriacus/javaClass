public class PatternABCD{
	public static void main(String[] args){
	  System.out.println("Pattern A\tPattern B\t Pattern C\tPattern D");
	  for (int counterB = 1; counterB <= 6; counterB++){
	    for(int counterA = 1; counterA <= 4; counterA++){
	      if(counterA <= 1){
	        System.out.print("* ".repeat(counterB));
	        System.out.print("  ".repeat(6 - counterB));
	      } else if (counterA <= 2){
	        System.out.print("* ".repeat(7 - counterB));
	        System.out.print("  ".repeat(counterB - 1));
	      } else if (counterA <= 3){
	        System.out.print("  ".repeat(6 - counterB));
	        System.out.print(" *".repeat(counterB));
	      } else{
	        System.out.print("  ".repeat(counterB - 1));
	        System.out.print(" *".repeat(7 - counterB));
	      }
	      System.out.print("\t");
	    }
      System.out.println();
	  }
	}
}
