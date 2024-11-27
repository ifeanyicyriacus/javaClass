public class PanChecker{
	public boolean panChecker(String text){
	  text = text.toLowerCase();
	  if (text.length() < 26) { return false; }
	  
	  for (char letter = 'a'; letter <= 'z'; letter += 1) {
	    if (text.contains("" + letter) == false){
	      return false;
	    }
	  }
	  return true;
	}
	
}
