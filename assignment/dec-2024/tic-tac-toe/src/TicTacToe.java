import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private final        int          noOfPlayers;
    private final        int          difficultLevel;
    private final        String       X     = CellValues.X.value;
    private final        String       O     = CellValues.O.value;
    private final        String[][][] gameBoard;
    private final static Scanner      input = new Scanner(System.in);


    public TicTacToe(int noOfPlayers, int difficultLevel) {
        this.noOfPlayers = noOfPlayers;
        this.difficultLevel = difficultLevel;
        this.gameBoard = switch (difficultLevel) {
            case 1 -> BoardTypes.EASY.board;
            case 2 -> BoardTypes.HARD.board;
            case 3 -> BoardTypes.DANGEROUS.board;
            default -> throw new IllegalStateException("Unexpected value: " + difficultLevel);
        };
    }

    private enum BoardTypes {
        EASY(1),
        HARD(2),
        DANGEROUS(3);

        private final String[][][] board;

        BoardTypes(int i) {
            this.board = switch (i) {
                case 1 -> new String[1][3][3];
                case 2 -> new String[1][4][4];
                case 3 -> new String[4][4][4];
                default -> throw new IllegalStateException("Unexpected value for board type: " + i);
            };
        }
    }

    private enum CellValues {
        X("  \033[1;31mX  \033[0m"),
        O("  \033[1;32mO  \033[0m"),
        EMPTY("");

        private final String value;

        CellValues(String value) {
            this.value = value;
        }
    }

    public void startGame() {
        final int NO_OF_CELLS_IN_BOARD = 9;
        final int MIN_NO_OF_MOVES_FOR_A_WIN = 5;

        reset(gameBoard);
        String token;
        System.out.println("""
                +-----------------------+
                |   Tic-Tac-Toe Game    |
                |       GAME ON!!       |
                +-----------------------+
                """);

        for (int index = 1; index <= NO_OF_CELLS_IN_BOARD; index += 1) {
            System.out.println(displayBoard(gameBoard));
            if (index % 2 == 0) {
                token = X;
                collectNextMove(gameBoard, token, input);
            } else {
                token = O;
                collectNextMove(gameBoard, token, input);
            }

            if (index >= MIN_NO_OF_MOVES_FOR_A_WIN && checkForWinner(gameBoard)) {
                System.out.println(displayBoard(gameBoard));
                System.out.printf("GAME OVER\nPlayer%s Wins\n", token);
                break;//playAgain
            } else if (index == 9) {
                System.out.println(displayBoard(gameBoard));
                System.out.println("GAME OVER\nDRAW!!!");
                break;//playAgain
            }
        }

    }

    private void reset(String[][][] gameBoard) {
        for (String[][] layer : gameBoard) {
            for (String[] row : layer) {
                Arrays.fill(row, CellValues.EMPTY.value);
            }
        }
    }


    public static void collectNextMove(String[][][] board, String token) {
        int retry = 0;
        int row;
        int column;
        int layer = 1;
        do {
            if (retry != 0) {
                System.out.println("Position has been filled, try again!");
            }
            if (board.length > 1) {
                System.out.printf("Player %s: enter board layer (A, B, C, D) >> ", token);
                layer = collectLayer();
            }
            System.out.printf("Player %s: enter row >> ", token);
            row = collectRowOrColumn();
            System.out.printf("Player %s: enter column >> ", token);
            column = collectRowOrColumn();
            retry += 1;
        } while (!addToken(board, token, layer, row, column));
    }

    public static boolean addToken(String[][][] board, String token, int layer, int row, int column) {
        if (board[layer - 1][row - 1][column - 1].equals(CellValues.EMPTY.value)) {
            board[layer - 1][row - 1][column - 1] = token;
            return true;
        }else {
            return false;
        }
    }

    private static int collectLayer() {
        int number = 0;
        do {
            String layer = input.next();
            switch (layer.toUpperCase()) {
                case "A" -> number = 1;
                case "B" -> number = 2;
                case "C" -> number = 3;
                case "D" -> number = 4;
                default -> System.out.print("Invalid input, Enter (A, B, C, or D) try again!\n>> ");
            }
        } while (number == 0);
        return number;
    }

    public static int collectRowOrColumn() {
        int number = 0;
        do {
            if (number != 0) {
                System.out.print("Invalid input, try again!>> ");
            }
            number = input.nextInt();
        } while (number < 1 || number > 3);
        return number;
    }

    public static boolean checkForWinner(String[][][] board) {
        if (!board[0][0].isEmpty() && board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
            highlightWinCells(board, 0, 0, 0, 1, 0, 2);
            return true;
        } else if (!board[1][0].isEmpty() && board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            highlightWinCells(board, 1, 0, 1, 1, 1, 2);
            return true;
        } else if (!board[2][0].isEmpty() && board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            highlightWinCells(board, 2, 0, 2, 1, 2, 2);
            return true;
        } else if (!board[0][0].isEmpty() && board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
            highlightWinCells(board, 0, 0, 1, 0, 2, 0);
            return true;
        } else if (!board[0][1].isEmpty() && board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
            highlightWinCells(board, 0, 1, 1, 1, 2, 1);
            return true;
        } else if (!board[0][2].isEmpty() && board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) {
            highlightWinCells(board, 0, 2, 1, 2, 2, 2);
            return true;
        } else if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            highlightWinCells(board, 0, 0, 1, 1, 2, 2);
            return true;
        } else if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            highlightWinCells(board, 0, 2, 1, 1, 2, 0);
            return true;
        } else {
            return false;
        }
    }

//    public static boolean checkForWinner4X4(String[][] board) {
//
//    }

    public static void highlightWinCells(String[][] board, int row1, int col1, int row2, int col2, int row3, int col3) {
        board[row1][col1] = "\033[47m" + board[row1][col1];
        board[row2][col2] = "\033[47m" + board[row2][col2];
        board[row3][col3] = "\033[47m" + board[row3][col3];
    }
  /*public static void highlightWinCells(
          String[][] board, int row1, int col1, int row2, int col2, int row3, int col3, int row4, int col4) {
    board[row1][col1] = "\033[47m" + board[row1][col1];
    board[row2][col2] = "\033[47m" + board[row2][col2];
    board[row3][col3] = "\033[47m" + board[row3][col3];
    board[row4][col4] = "\033[47m" + board[row4][col4];
  }*/


    public static String displayBoard(String[][][] board) {
        return String.format("      col 1 col 2 col 3 %n     +-----+-----+-----+%nrow 1|%5s|%5s|%5s|%n     +-----+-----+-----+%nrow 2|%5s|%5s|%5s|%n     +-----+-----+-----+%nrow 3|%5s|%5s|%5s|%n     +-----+-----+-----+%n",
                board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
    }


}


