import java.util.Scanner;
public class VowelConsonant{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input an alphabet: ");
		String letter = input.next();
		
		switch(letter.toLowerCase()){
			case "a": case "e": case "i": case "o": case "u":
				System.out.println("Input letter is a Vowel");
				break;
			case "b": case "c": case "d": case "f": case "g":
			case "h": case "j": case "k": case "l": case "m":
			case "n": case "p": case "q": case "r": case "s":
			case "t": case "v": case "w": case "x": case "y":
			case "z":
				System.out.println("Input letter is a Consonant");
				break;
			default:
				System.out.println("Input is not an alphabeth letter, try again.");
		}
	}
}
