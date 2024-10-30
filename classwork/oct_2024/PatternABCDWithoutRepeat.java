public class PatternABCDWithoutRepeat{
	public static void main(String[] args){
	  System.out.println("Pattern A\tPattern B\t Pattern C\tPattern D");
	  for (int counterB = 1; counterB <= 6; counterB++){
	    String tempText = "";
	    for(int counterA = 1; counterA <= 4; counterA++){
	      if(counterA <= 1){
	        tempText = "";
	        for (int i = counterB; i > 0; i -=1) {
	          tempText += "* ";
	        }
	        System.out.print(tempText);
	        tempText = "";
	        for (int i = (6 - counterB); i > 0; i -=1) {
	          tempText += "  ";
	        }
	        System.out.print(tempText);
	      } else if (counterA <= 2){
	        tempText = "";
	        for (int i = (7 - counterB); i > 0; i -=1) {
	          tempText += "* ";
	        }
	        System.out.print(tempText);
	        tempText = "";
	        for (int i = (counterB - 1); i > 0; i -=1) {
	          tempText += "  ";
	        }
	        System.out.print(tempText);
	      } else if (counterA <= 3){
	        tempText = "";
	        for (int i = (6 - counterB); i > 0; i -=1) {
	          tempText += "  ";
	        }
	        System.out.print(tempText);
	        tempText = "";
	        for (int i = counterB; i > 0; i -=1) {
	          tempText += " *";
	        }
	        System.out.print(tempText);
	      } else{
	        tempText = "";
	        for (int i = (counterB - 1); i > 0; i -=1) {
	          tempText += "  ";
	        }
	        System.out.print(tempText);
	        tempText = "";
	        for (int i = (7 - counterB); i > 0; i -=1) {
	          tempText += " *";
	        }
	        System.out.print(tempText);
	      }
	      System.out.print("\t");
	    }
      System.out.println();
	  }
	}
}
