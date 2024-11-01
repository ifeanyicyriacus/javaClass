import java.util.Scanner;
public class LanguageGreetingUsingSwitch{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String availableLanguages = "Can i greet\nPlease choose one of the option\n1. English\n2. Igbo\n3. Hausa\n4. Yoruba\n>>>> ";
    System.out.print(availableLanguages);
    int languageChoice = input.nextInt(); 
    String greetings;
    int greetingsChoice;
    
    switch(languageChoice){
      case 1:
        System.out.println("\nYou have selected English");
        greetings = "Hello! There, enter:\n1. Morning\n2. Afternon\n3. Evening\n>>>> ";
        System.out.print(greetings);
        greetingsChoice = input.nextInt();
        switch(greetingsChoice){
          case 1:
            System.out.println("Good morning");
            break;
          case 2:
            System.out.println("Good afternoon");
            break;
          case 3:
            System.out.println("Good evening");
            break;
          default:
            System.out.println("Wrong input");
            break;
          }
        break;
        
      case 2:
        System.out.println("\nỊ họrọla Igbo");
        greetings = "Nnọọ! Ebe ahụ, pịa:\n1. Ututu\n2. N'ehihie\n3. Mgbede\n>>>> ";
        System.out.print(greetings);
        greetingsChoice = input.nextInt();
        switch(greetingsChoice){
          case 1:
            System.out.println("Ụtụtụ ọma");
            break;
          case 2:
            System.out.println("Ehihie ọma");
            break;
          case 3:
            System.out.println("Mgbede ọma");
            break;
          default:
            System.out.println("Ntinye ezighi ezi");
            break;
          }
        break;
      case 3:
        System.out.println("\nKun zabi Hausa");
        greetings = "Sannu! can, danna:\n1. Safiya\n2. Safiya\n3. Maraice\n>>>> ";
        System.out.print(greetings);
        greetingsChoice = input.nextInt();
        switch(greetingsChoice){
          case 1:
            System.out.println("Barka da safiya");
            break;
          case 2:
            System.out.println("Barka da safiya");
            break;
          case 3:
            System.out.println("Barka da safiya");
            break;
          default:
            System.out.println("Shigar da ba daidai ba");
            break;
        }
        break;
      case 4:
        System.out.print("\nO ti yan Yoruba");
        greetings = "Pẹlẹ o! Nibẹ, tẹ:\n1. Owurọ\n2. Ọsan\n3. Irọlẹ\n>>>> ";
        System.out.print(greetings);
        greetingsChoice = input.nextInt();
        switch(greetingsChoice){
          case 1:
            System.out.println("E kaaro");
            break;
          case 2:
            System.out.println("E kaasan");
            break;
          case 3:
            System.out.println("Ka a ale");
            break;
          default:
            System.out.println("Iṣawọle ti ko tọ");
            break;
        }
        break;
      default:
        System.out.print("Hello! there\nNnọọ! Ebe ahụ\nPẹlẹ o! Nibẹ\nSannu! can\n");
        break;
    }
  }
}
