import java.util.Scanner;

public class MensturalApp{
  static Scanner input = new Scanner(System.in);
  
  public static void main(){
    String welcomeMessage = """
              Welcome to The Menstural App
        Your personalised Menstural cycle tracker
    """;
    boolean isRegistered = false;
    String mainMenu = """
    Menu:
      1. Register To Track your Cycle
      2. See Your Current Menstural Cycle
      3. Search For A Date In Future (Menstural Time Machine)
      4. Learn About Menstural Cycle
      0. Exit
    """;
    System.out.println(welcomeMessage);
    
    boolean sentinel = true;
    while (sentinel){
      System.out.println(mainMenu);
      System.out.print("Select an option:\n>>> ");
      int choice = input.nextInt();
      switch(choice){
        case 1:
          register();
          break;
        case 2:
          displayCurrentMensturalCycleInfo();
          break;
        case 3:
          searchMensturalTimeMachine();
          break;
        case 4:
          displayLearnMore();
          break;
        case 0:
          sentinel = false;
          break;
        default:
          System.out.println("Invalid input, try again! ");
      }
    }
    
    public static void register(){
      Sysyem.out.print()
    
    }
    
    displayCurrentMensturalCycleInfo()
    searchMensturalTimeMachine()
    displayLearnMore()
    
    
  }












}
