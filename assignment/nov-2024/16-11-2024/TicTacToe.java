import java.util.Scanner;
public class TicTacToe{
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    final int NO_OF_CELLS_IN_BOARD = 9;
    final int MIN_NO_OF_MOVES_FOR_A_WIN = 5;
    final String X = "  \033[1;31mX  \033[0m";
    final String O = "  \033[1;32mO  \033[0m";
    String[][] ticTacToeBoard = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    String token;
    
    System.out.println("Tic-Tac-Toe Game");
    System.out.println("Enter Row(1-3) and column(1-3) number.\nGAME ON");
    
    for (int index = 1; index <= NO_OF_CELLS_IN_BOARD; index += 1){
      System.out.println(displayBoard(ticTacToeBoard));
      if (index % 2 == 0){
        token = X;
        collectNextMove(ticTacToeBoard, token, input);
      } else {
        token = O;
        collectNextMove(ticTacToeBoard, token, input);
      }
      
      if (index >= MIN_NO_OF_MOVES_FOR_A_WIN && checkForWinner(ticTacToeBoard) == true){
        System.out.println(displayBoard(ticTacToeBoard));
        System.out.printf("GAME OVER\nPlayer-%s Wins\n", token );
        break;//playAgain
      }else if (index == 9){
        System.out.println(displayBoard(ticTacToeBoard));
        System.out.println("GAME OVER\nDRAW!!!");
        break;//playAgain
      }
    }
    
  }
  
  public static void playAgain(String[][] board){
  
    //swap who starts // i might need to make X and O an object so that i could swap their reference before game begin
  }
  
  public static void collectNextMove(String[][] board, String token, Scanner input){
    int retry = 0;
    int row; int column;
    do{
      if (retry != 0){ System.out.println("Position has been filled, try again!"); }
      System.out.printf("Player %s: enter row >> ", token );
      row = collectRowOrColumn(input);
      System.out.printf("Player %s: enter column >> ", token );
      column = collectRowOrColumn(input);
      retry += 1;
    }while(!addToken(board, token, row, column));
  }

  public static boolean addToken(String[][] board, String token, int row, int column){
    if (board[row - 1][column - 1].equals("")){
      board[row - 1][column - 1] = token;
      return true;
    }else { return false; }
  }
  
  public static int collectRowOrColumn(Scanner input){
    int number = 0;
    do{
      if (number != 0){ System.out.print("Invalid input, try again!>> ");}
      number = input.nextInt();
    }while(number < 1 || number > 3);
    return number;
  }
  
  public static boolean checkForWinner(String[][] board){
    if (!board[0][0].equals("") && board[0][0] == board[0][1] && board[0][1] == board[0][2]){
      highlightWinCells(board, 0,0,0,1,0,2); 
      return true; }
    else if (!board[1][0].equals("") && board[1][0] == board[1][1] && board[1][1] == board[1][2]){
      highlightWinCells(board, 1,0,1,1,1,2); 
      return true; }
    else if (!board[2][0].equals("") && board[2][0] == board[2][1] && board[2][1] == board[2][2]){
      highlightWinCells(board, 2,0,2,1,2,2); 
      return true; }   
      
    else if (!board[0][0].equals("") && board[0][0] == board[1][0] && board[1][0] == board[2][0]){
      highlightWinCells(board, 0,0,1,0,2,0); 
      return true; }
    else if (!board[0][1].equals("") && board[0][1] == board[1][1] && board[1][1] == board[2][1]){
      highlightWinCells(board, 0,1,1,1,2,1); 
      return true; }
    else if (!board[0][2].equals("") && board[0][2] == board[1][2] && board[1][2] == board[2][2]){
      highlightWinCells(board, 0,2,1,2,2,2); 
      return true; }
    
    else if (!board[0][0].equals("") && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
      highlightWinCells(board, 0,0,1,1,2,2); 
      return true; }
    else if (!board[0][2].equals("") && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
      highlightWinCells(board, 0,2,1,1,2,0); 
      return true; }
    else { return false; } 
  }
  
  public static void highlightWinCells(String[][] board, int row1, int col1, int row2, int col2, int row3, int col3 ){
    board[row1][col1] = "\033[47m" + board[row1][col1];
    board[row2][col2] = "\033[47m" + board[row2][col2];
    board[row3][col3] = "\033[47m" + board[row3][col3];
  }
  
  
  public static String displayBoard(String[][] board){
    return String.format("      col 1 col 2 col 3 %n     +-----+-----+-----+%nrow 1|%5s|%5s|%5s|%n     +-----+-----+-----+%nrow 2|%5s|%5s|%5s|%n     +-----+-----+-----+%nrow 3|%5s|%5s|%5s|%n     +-----+-----+-----+%n",
    board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
  }
  
  
  
}


