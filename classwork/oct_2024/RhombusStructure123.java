import java.util.Scanner;
public class RhombusStructure123{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Input the number: ");
    int charNumber = input.nextInt();
    char charAlphabet = ('1' - 1);
    
    for (int i = 1; i <= charNumber; i += 1){
      System.out.print(" ".repeat(charNumber-i));
      int forward = i;
	    int reverse = ((i*2) - 1) - forward;
      
      while (forward > 0) {
        charAlphabet += 1;
        System.out.print(charAlphabet);
        forward -= 1;
      }

      while (reverse >= 0) {
        if (reverse != 0){
          charAlphabet -= 1;
          System.out.print(charAlphabet);
          reverse -= 1;
        } else{
          charAlphabet -= 1;
          break;
        }
      }
      System.out.println();
    }
    
    for (int i = (charNumber - 1); i >= 1; i -= 1){
      System.out.print(" ".repeat(charNumber-i));
      
      int forward = i;
	    int reverse = ((i*2) - 1) - forward;
      
      while (forward > 0) {
        charAlphabet += 1;
        System.out.print(charAlphabet);
        forward -= 1;
      }

      while (reverse >= 0) {
        if (reverse != 0){
          charAlphabet -= 1;
          System.out.print(charAlphabet);
          reverse -= 1;
        } else{
          charAlphabet -= 1;
          break;
        }
      }
      System.out.println();
    }
  }
}
