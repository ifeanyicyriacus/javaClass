import java.util.Scanner;
public class MovieTicket{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome: select from the menu option below\n");
    Double ticketPrice = 0.0;
    int choice = 0;
    String choices;
    System.out.print("""
    Customer age group?
    1. Child  (+ $12)
    2. Adult  (+ $20)
    3. Senior (+ $15)
    >>>
    """);
    choice = input.nextInt();
    switch(choice){
      case 1:
        ticketPrice += 12.0;
        choices += "Child >";
        System.out.print("""
    Child > Day of week?
    1. Weekday  (+ $1)
    2. Weekend  (+ $4)
    >>>
    """);
        choice = input.nextInt();
        switch(choice){
          case 1:
            choices += "Weekday >";
            ticketPrice += 1;
            System.out.print("""
    Child > Weekday > Time of show?
    1. Morning  (+ $2)
    2. Evening  (+ $5)
    >>>
    """);
            choice = input.nextInt();
            switch(choice){
              case 1:
                choices += "Morning.";
                ticketPrice += 2;
                break;
              case 2:
                choices += "Evening.";
                ticketPrice += 5;
                break;
            }break;
            
          case 2:
            ticketPrice += 4;
            choices += "Weekend >";
            System.out.print("""
    Child > Weekend > Time of show?
    1. Morning  (+ $2)
    2. Evening  (+ $5)
    >>>
    """);
            choice = input.nextInt();
            switch(choice){
              case 1:
                choices += "Morning.";
                ticketPrice += 2;
                break;
              case 2:
                choices += "Evening.";
                ticketPrice += 5;
                break;
            }break;
        }break;
      
    
    
    }
    
    
    
  }
}
