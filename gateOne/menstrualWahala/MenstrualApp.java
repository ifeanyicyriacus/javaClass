import java.util.Scanner;
import java.time.LocalDate;

public class MenstrualApp{
  static final int AVERAGE_CYCLE_DURATION = 29;
  static final int AVERAGE_PERIOD_DURATION = 5;
  
  static Scanner input = new Scanner(System.in);
  static LocalDate lastPeriodStartDate;
  static boolean isRegistered = false;
  static int userAveragePeriodDuration = AVERAGE_PERIOD_DURATION;
  static int userAverageCycleDuration = AVERAGE_CYCLE_DURATION;
  
  public static void main(String[] args){
    String welcomeMessage = """
              \033[1mWelcome to The Menstural App
        Your personalised Menstural cycle tracker\033[0m
    """;
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
          if(isRegistered){
            System.out.println(displayCurrentMensturalCycleInfo());
          }else{System.out.println("\033[31m------Complete registration first-----\033[0m");}
          break;
        case 3:
          searchMensturalTimeMachine();
          break;
        case 4:
          System.out.println(displayLearnMore());
          break;
        case 0:
          sentinel = false;
          break;
        default:
          System.out.println("Invalid input, try again! ");
      }
    }
    

  }


    public static void register(){
      System.out.print("Enter your year of birth (yyyy): ");
      int yearOfBirth = input.nextInt();
      System.out.print("When did your last period start (dd-mm-yyyy)? ");
      String lastPeriodStartDateString = input.next();
      
      System.out.print("Do you experence regular days of period flow (yes/no)? ");
      boolean isPeriodRegular = input.next().equalsIgnoreCase("yes");
      if (isPeriodRegular){
        System.out.print("What is you average period flow length? ");
        userAveragePeriodDuration = input.nextInt();
      }
      System.out.print("Do you experence regular menstural cycle (yes/no)? ");
      boolean isCycleRegular = input.next().equalsIgnoreCase("yes");
      if (isCycleRegular){
        System.out.print("What is you average menstural cycle length? ");
        userAverageCycleDuration = input.nextInt();
      }
      
      String[] lastPeriodStartDateArray = lastPeriodStartDateString.split("-");
      int day = Integer.valueOf(lastPeriodStartDateArray[0]);
      int month = Integer.valueOf(lastPeriodStartDateArray[1]);
      int year = Integer.valueOf(lastPeriodStartDateArray[2]);
      lastPeriodStartDate = LocalDate.of(year, month, day);
      
      isRegistered = true;

    }
    
    public static String displayCurrentMensturalCycleInfo(){
      final int averageMaxPeriodDays = 7;
      final int averageFertileStageDuration= 11;
      final int averagePrePeriodStageDuration= 11;
      int ovulationDay = userAverageCycleDuration - 14;

      int periodDaysDuration = (int)Math.round((averageMaxPeriodDays * userAverageCycleDuration) / (double)AVERAGE_CYCLE_DURATION);
      int preFertileStageDuration = periodDaysDuration - userAveragePeriodDuration;
      int fertileStageDuration = (int)Math.round((averageFertileStageDuration * userAverageCycleDuration) / (double)AVERAGE_CYCLE_DURATION);
      int prePeriodStageDuration = (int)Math.round((averagePrePeriodStageDuration * userAverageCycleDuration) / (double)AVERAGE_CYCLE_DURATION);
      
      LocalDate periodStartDate = lastPeriodStartDate.plusDays(userAverageCycleDuration);
      LocalDate periodEndDate = periodStartDate.plusDays(userAveragePeriodDuration);
      
      LocalDate preFertileStageStartDate = periodEndDate.plusDays((preFertileStageDuration > 0)?1:0);
      LocalDate preFertileStageEndDate = preFertileStageStartDate.plusDays(preFertileStageDuration);
      
      LocalDate fertileDaysStartDate = preFertileStageEndDate.plusDays(1);
      LocalDate fertileDaysEndDate = fertileDaysStartDate.plusDays(fertileStageDuration);
      LocalDate ovulation = periodStartDate.plusDays(ovulationDay);
      
      LocalDate prePeriodDaysStartDate = fertileDaysEndDate.plusDays(1);
      LocalDate prePeriodDaysEndDate = prePeriodDaysStartDate.plusDays(prePeriodStageDuration);
      
      
      
      String currentMensturalCycleInfo = "";
      currentMensturalCycleInfo += String.format("\033[1m\033[4mMenstural Cycle length: %d days\033[0m%n", userAverageCycleDuration);
      currentMensturalCycleInfo += String.format("\033[31m\033[1mPeriod:🩸\033[0m%n");
      currentMensturalCycleInfo += String.format("Duration: %d days%n", userAveragePeriodDuration); 
      currentMensturalCycleInfo += String.format("From: %s to %s%n%n", (periodStartDate), (""+periodEndDate));
      
      if(preFertileStageDuration > 0){
        currentMensturalCycleInfo += String.format("\033[34m\033[1mSafe Period (Pre-Fertile days):\033[0m%n");
        currentMensturalCycleInfo += String.format("Duration: %d days%n", preFertileStageDuration);
        currentMensturalCycleInfo += String.format("From: %s to %s%n%n", (""+preFertileStageStartDate), (""+preFertileStageEndDate));
      }
      
      currentMensturalCycleInfo += String.format("\033[32m\033[1mFertile days: 👩‍❤️‍👨\033[0m%n");
      currentMensturalCycleInfo += String.format("Duration: %d days%n", fertileStageDuration);
      currentMensturalCycleInfo += String.format("From: %s to %s%n", (""+fertileDaysStartDate), (""+fertileDaysEndDate));
      currentMensturalCycleInfo += String.format("\033[35m\033[1mOvulation:🌸 %s\033[0m%n%n", (""+ovulation));
      
      currentMensturalCycleInfo += String.format("\033[34m\033[1mSafe Period (Pre-Period):\033[0m%n");
      currentMensturalCycleInfo += String.format("Duration: %d days%n", prePeriodStageDuration); 
      currentMensturalCycleInfo += String.format("From: %s to %s%n%n", (""+prePeriodDaysStartDate), (""+prePeriodDaysEndDate));
      
      
      return currentMensturalCycleInfo;
    }
    
    
    public static void searchMensturalTimeMachine(){
    
    }
    
    
    public static String displayLearnMore(){
      String learnMore = "";
    
      return learnMore;
    }

    
    









}
