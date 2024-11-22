import java.util.Scanner;
public class TicTacToe{
  static final int NO_OF_CELLS_IN_BOARD = 9;
  static Scanner input = new Scanner(System.in);
  static int row;
  static int column;
  static String token;
  static String[][] ticTacToeBoard = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
  
  public static void main(String[] args){
    System.out.println("Tic-Tac-Toe Game");
    System.out.println("Enter Row(1-3) and column(1-3) number.\nGAME ON");
    
    for (int index = 1; index <= NO_OF_CELLS_IN_BOARD; index += 1){
      System.out.println(displayBoard(ticTacToeBoard));
      if (index % 2 == 0){
        token = "\033[1;31mX\033[0m";
        collectNextMove(token);
      } else {
        token = "\033[1;32mO\033[0m";
        collectNextMove(token);
      }
      
      if (index >= 5){
        if (checkForWinner(ticTacToeBoard) == false && index == 9){
          System.out.println(displayBoard(ticTacToeBoard));
          System.out.println("GAME OVER\n DRAW!!!");
          break;
        }else if (checkForWinner(ticTacToeBoard) == true){
          System.out.println(displayBoard(ticTacToeBoard));
          System.out.printf("GAME OVER\n%s Player Wins\n", token );
          break;
        }
      }
    }
  }
  
  public static void collectNextMove(String token){
    System.out.printf("Player %s: enter row >> ", token );
    row = collectRowOrColumn();
    System.out.printf("Player %s: enter column >> ", token );
    column = collectRowOrColumn();
    addToken(ticTacToeBoard, row, column, token );
  }
  
  public static int collectRowOrColumn(){
    int number = 0;
    do{
      if (number != 0){ System.out.print("Invalid input, try again!>> ");}
      number = input.nextInt();
    }while(number < 1 || number > 3);
    return number;
  }
  
  public static boolean checkForWinner(String[][] board){
    if (!board[0][0].equals(" ") && board[0][0] == board[0][1] && board[0][1] == board[0][2]){ return true;}
    else if (!board[1][0].equals(" ") && board[1][0] == board[1][1] && board[1][1] == board[1][2]){ return true;}
    else if (!board[2][0].equals(" ") && board[2][0] == board[2][1] && board[2][1] == board[2][2]){ return true;}
    
    else if (!board[0][0].equals(" ") && board[0][0] == board[1][0] && board[1][0] == board[2][0]){ return true;}
    else if (!board[0][1].equals(" ") && board[0][1] == board[1][1] && board[1][1] == board[2][1]){ return true;}
    else if (!board[0][2].equals(" ") && board[0][2] == board[1][2] && board[1][2] == board[2][2]){ return true;}
    
    else if (!board[0][0].equals(" ") && board[0][0] == board[1][1] && board[1][1] == board[2][2]){ return true;}
    else if (!board[0][2].equals(" ") && board[0][2] == board[1][1] && board[1][1] == board[2][0]){ return true;}
    else { return false;} 
  }
  
  public static void addToken(String[][] board, int row, int column, String token){
    if (board[row - 1][column - 1].equals(" "))
      board[row - 1][column - 1] = token;
    else do{
        System.out.println("Position has been filled, try again!");
        System.out.printf("Player %s: enter row >> ", token);
        row = input.nextInt();
        System.out.printf("Player %s: enter column >> ", token);
        column = input.nextInt();
        addToken(board, row, column, token);
      }while(board[row - 1][column - 1].equals(" "));
  }
  
  public static String displayBoard(String[][] board){
    return String.format("      col 1 col 2 col 3 %n     +-----+-----+-----+%nrow 1|  %s  |  %s  |  %s  |%n     +-----+-----+-----+%nrow 2|  %s  |  %s  |  %s  |%n     +-----+-----+-----+%nrow 3|  %s  |  %s  |  %s  |%n     +-----+-----+-----+%n",
    board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
  }
  
  
  
}


