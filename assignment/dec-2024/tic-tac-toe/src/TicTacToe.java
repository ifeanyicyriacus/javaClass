import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private final        int          NO_OF_PLAYERS;
    private final        String       X      = CellValues.X.value;
    private final        String       O      = CellValues.O.value;
    private final        String[][][] GAME_BOARD;
    private final static Scanner      INPUT  = new Scanner(System.in);
    private final static Random       RANDOM = new Random();

    private final int NO_OF_CELLS_IN_BOARD;
    private final int MIN_NO_OF_MOVES_FOR_A_WIN;
    private final int LENGTH_OF_BOARD_SIDES;
    private final int LAYERS_OF_BOARD;
//    private final int[][] WINNER_START_TO_STOP_COORDINATES = new int[2][3];

    public TicTacToe(int noOfPlayers, int difficultLevel) {
        this.NO_OF_PLAYERS = noOfPlayers;
        this.GAME_BOARD = switch (difficultLevel) {
            case 1 -> BoardTypes.EASY.board;
            case 2 -> BoardTypes.HARD.board;
            case 3 -> BoardTypes.EXTREME.board;
            case 4 -> BoardTypes.DANGEROUS.board;
            default -> throw new IllegalStateException("Unexpected value: " + difficultLevel);
        };
        this.LAYERS_OF_BOARD = this.GAME_BOARD.length;
        this.LENGTH_OF_BOARD_SIDES = this.GAME_BOARD[0].length;
        this.NO_OF_CELLS_IN_BOARD = (int) (this.LAYERS_OF_BOARD * Math.pow(LENGTH_OF_BOARD_SIDES, 2));
        this.MIN_NO_OF_MOVES_FOR_A_WIN = (this.LENGTH_OF_BOARD_SIDES * 2) - 1;
    }

    private enum BoardTypes {
        EASY(1),
        HARD(2),
        EXTREME(3),
        DANGEROUS(4);

        private final String[][][] board;

        BoardTypes(int i) {
            this.board = switch (i) {
                case 1 -> new String[1][3][3];
                case 2 -> new String[1][4][4];
                case 3 -> new String[3][3][3];
                case 4 -> new String[4][4][4];
                default -> throw new IllegalStateException("Unexpected value for board type: " + i);
            };
        }
    }

    private enum CellValues {
        X("\033[1;31m  X  \033[0m"),
        O("\033[1;32m  O  \033[0m"),
        EMPTY("");

        private final String value;

        CellValues(String value) {
            this.value = value;
        }
    }

    public void startGame() {
        reset(GAME_BOARD);
        String token;

        for (int index = 1; index <= NO_OF_CELLS_IN_BOARD; index += 1) {
            System.out.println(displayBoard());
            if (index % 2 != 0) {
                token = X;
                if (NO_OF_PLAYERS == 1) {
                    collectComputerNextMove(token);
                } else {
                    collectHumanNextMove(token);
                }
            } else {
                token = O;
                collectHumanNextMove(token);
            }

            if (index >= MIN_NO_OF_MOVES_FOR_A_WIN && checkForWinner()) {
                System.out.println(displayBoard());

                System.out.printf("GAME OVER\n%s%s Wins\n", ((index % 2 != 0 && NO_OF_PLAYERS == 1) ? "Computer" : "Player"), token);
                break;
            } else if (index == NO_OF_CELLS_IN_BOARD) {
                System.out.println(displayBoard());
                System.out.println("GAME OVER\nDRAW!!!");
                break;
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

    public void collectHumanNextMove(String token) {
        int retry = 0;
        int row;
        int column;
        int layer = 1;
        do {
            if (retry != 0) {
                System.out.println("Position has been filled, try again!");
            }
            if (LAYERS_OF_BOARD > 1) {
                System.out.printf("Player %s: enter board layer (A, B, C%s) >> ", token, (LAYERS_OF_BOARD == 4)?", D1":"");
                layer = collectLayer();
            }
            System.out.printf("Player %s: enter row >> ", token);
            row = collectRowOrColumn();
            System.out.printf("Player %s: enter column >> ", token);
            column = collectRowOrColumn();
            retry += 1;
        } while (!addToken(token, layer, row, column));
    }

    public void collectComputerNextMove(String token) {
        int layer;
        int row;
        int col;
        do {
            layer = (LAYERS_OF_BOARD == 1) ? 1 : RANDOM.nextInt(1, LAYERS_OF_BOARD + 1);
            row = RANDOM.nextInt(LENGTH_OF_BOARD_SIDES) + 1;
            col = RANDOM.nextInt(LENGTH_OF_BOARD_SIDES) + 1;
        } while (!addToken(token, layer, row, col));
    }

    public boolean addToken(String token, int layer, int row, int column) {
        if (GAME_BOARD[layer - 1][row - 1][column - 1].equals(CellValues.EMPTY.value)) {
            GAME_BOARD[layer - 1][row - 1][column - 1] = token;
            return true;
        } else {
            return false;
        }
    }

    private int collectLayer() {
        int number = 0;
        do {
            String layer = INPUT.next();
            switch (layer.toUpperCase()) {
                case "A" -> number = 1;
                case "B" -> number = 2;
                case "C" -> number = 3;
                default -> {
                    if (LAYERS_OF_BOARD == 4 && layer.equalsIgnoreCase("D")) {
                        number = 4;
                    } else {
                        System.out.printf("Invalid INPUT, Enter (A, B, %s try again!\n>> ",
                                (LAYERS_OF_BOARD == 3) ? "or C" : "C, or D)");
                    }
                }
            }
        } while (number == 0);
        return number;
    }

    public int collectRowOrColumn() {
        int number = 0;
        do {
            if (number != 0) {
                System.out.print("Invalid INPUT, try again!>> ");
            }
            number = INPUT.nextInt();

        } while (number < 1 || number > this.LENGTH_OF_BOARD_SIDES);
        return number;
    }

    public boolean checkForWinner() {
        if (LAYERS_OF_BOARD == 1) {
            return checkIndividualBoardsForWinner(0);
        } else {
            for (int layer = 0; layer < LAYERS_OF_BOARD; layer++) {
                if (checkIndividualBoardsForWinner(layer)) {
                    return true;
                }
            }
            for (int row = 0; row < LENGTH_OF_BOARD_SIDES; row += 1) {
                for (int col = 0; col < LENGTH_OF_BOARD_SIDES; col += 1) {
                    if (checkTopToBottomVerticals(row, col)) {
                        return true;
                    }
                }
            }

            for (int col = 0; col < LENGTH_OF_BOARD_SIDES; col += 1) {
                if (checkTopEdgeToBottomEdgeForwardDiagonalOnYAxis(col)) {
                    return true;
                }
                if (checkTopEdgeToBottomEdgeBackwardDiagonalOnYAxis(col)) {
                    return true;
                }
            }

            for (int row = 0; row < LENGTH_OF_BOARD_SIDES; row += 1) {
                if (checkTopEdgeToBottomEdgeForwardDiagonalOnXAxis(row)) {
                    return true;
                }
                if (checkTopEdgeToBottomEdgeBackwardDiagonalOnXAxis(row)) {
                    return true;
                }
            }
            return checkCornerToCornerDiagonals();
        }
    }

    private boolean checkCornerToCornerDiagonals() {//do not support iteration yet
        if (!GAME_BOARD[0][0][0].equals(CellValues.EMPTY.value) && GAME_BOARD[0][0][0].equals(GAME_BOARD[1][1][1])
                && GAME_BOARD[0][0][0].equals(GAME_BOARD[2][2][2]) && GAME_BOARD[0][0][0].equals(GAME_BOARD[3][3][3])) {
            highlightWinCells(0, LAYERS_OF_BOARD - 1, 0, 3, 0, 3, true);
            return true;
        } else if (!GAME_BOARD[0][3][3].equals(CellValues.EMPTY.value) && GAME_BOARD[0][3][3].equals(GAME_BOARD[1][2][2])
                && GAME_BOARD[0][3][3].equals(GAME_BOARD[2][1][1]) && GAME_BOARD[0][3][3].equals(GAME_BOARD[3][0][0])) {
            highlightWinCells(0, LAYERS_OF_BOARD - 1, 3, 0, 3, 0, true);
            return true;
        } else if (!GAME_BOARD[0][0][3].equals(CellValues.EMPTY.value) && GAME_BOARD[0][0][3].equals(GAME_BOARD[1][1][2])
                && GAME_BOARD[0][0][3].equals(GAME_BOARD[2][2][1]) && GAME_BOARD[0][0][3].equals(GAME_BOARD[3][3][0])) {
            highlightWinCells(0, LAYERS_OF_BOARD - 1, 0, 3, 3, 0, true);
            return true;
        } else if (!GAME_BOARD[0][3][0].equals(CellValues.EMPTY.value) && GAME_BOARD[0][3][0].equals(GAME_BOARD[1][2][1])
                && GAME_BOARD[0][3][0].equals(GAME_BOARD[2][1][2]) && GAME_BOARD[0][3][0].equals(GAME_BOARD[3][0][3])) {
            highlightWinCells(0, LAYERS_OF_BOARD - 1, 3, 0, 0, 3, true);
            return true;
        }
        return false;
    }

    private boolean checkTopEdgeToBottomEdgeBackwardDiagonalOnXAxis(int row) {
        if (GAME_BOARD[0][row][LENGTH_OF_BOARD_SIDES - 1].equals(CellValues.EMPTY.value)) {
            return false;
        }

        for (int layer = 1, col = (LENGTH_OF_BOARD_SIDES - 2); layer < LAYERS_OF_BOARD; layer += 1, col -= 1) {
            if (!GAME_BOARD[0][row][LENGTH_OF_BOARD_SIDES - 1].equals(GAME_BOARD[layer][row][col])) {
                return false;
            }
        }
        highlightWinCells(0, LAYERS_OF_BOARD - 1, row, row, LENGTH_OF_BOARD_SIDES - 1, 0, true);
        return true;
    }

    private boolean checkTopEdgeToBottomEdgeForwardDiagonalOnXAxis(int row) {
        if (GAME_BOARD[0][row][0].equals(CellValues.EMPTY.value)) {
            return false;
        }
        for (int layer = 1, col = 1; layer < LAYERS_OF_BOARD; layer += 1, col += 1) {
            if (!GAME_BOARD[0][row][0].equals(GAME_BOARD[layer][row][col])) {
                return false;
            }
        }
        highlightWinCells(0, LAYERS_OF_BOARD - 1, row, row, 0, LENGTH_OF_BOARD_SIDES - 1, true);
        return true;
    }

    private boolean checkTopEdgeToBottomEdgeForwardDiagonalOnYAxis(int col) {
        if (GAME_BOARD[0][0][col].equals(CellValues.EMPTY.value)) {
            return false;
        }
        for (int layer = 1, row = 1; layer < LAYERS_OF_BOARD; layer += 1, row += 1) {
            if (!GAME_BOARD[0][0][col].equals(GAME_BOARD[layer][row][col])) {
                return false;
            }
        }
        highlightWinCells(0, LAYERS_OF_BOARD - 1, 0, LENGTH_OF_BOARD_SIDES - 1, col, col, true);
        return true;
    }

    private boolean checkTopEdgeToBottomEdgeBackwardDiagonalOnYAxis(int col) {
        if (GAME_BOARD[0][LENGTH_OF_BOARD_SIDES - 1][col].equals(CellValues.EMPTY.value)) {
            return false;
        }
        for (int layer = 1, row = (LENGTH_OF_BOARD_SIDES - 2); layer < LAYERS_OF_BOARD; layer += 1, row -= 1) {
            if (!GAME_BOARD[0][LENGTH_OF_BOARD_SIDES - 1][col].equals(GAME_BOARD[layer][row][col])) {
                return false;
            }
        }
        highlightWinCells(0, LAYERS_OF_BOARD - 1, LENGTH_OF_BOARD_SIDES - 1, 0, col, col, true);
        return true;
    }

    private boolean checkTopToBottomVerticals(int row, int col) {
        if (GAME_BOARD[0][row][col].equals(CellValues.EMPTY.value)) {
            return false;
        }
        for (int layer = 1; layer < LAYERS_OF_BOARD; layer += 1) {
            if (!GAME_BOARD[0][row][col].equals(GAME_BOARD[layer][row][col])) {
                return false;
            }
        }
        highlightWinCells(0, LAYERS_OF_BOARD - 1, row, row, col, col, false);
        return true;
    }

    private boolean checkIndividualBoardsForWinner(int layer) {
        String[][] columns = transpose(GAME_BOARD[layer]);
        String[] backwardSlashDiagonal = extractDiagonals(GAME_BOARD[layer])[0];
        String[] forwardSlashDiagonal = extractDiagonals(GAME_BOARD[layer])[1];

        for (int row = 0; row < LENGTH_OF_BOARD_SIDES; row += 1) {
            if (checkRowForComplete(GAME_BOARD[layer][row])) {
                highlightWinCells(layer, layer, row, row, 0, LENGTH_OF_BOARD_SIDES - 1, false);
                return true;
            }
        }

        for (int col = 0; col < LENGTH_OF_BOARD_SIDES; col += 1) {
            if (checkRowForComplete(columns[col])) {
                highlightWinCells(layer, layer, 0, LENGTH_OF_BOARD_SIDES - 1, col, col, false);
                return true;
            }
        }
        if (checkRowForComplete(forwardSlashDiagonal)) {
            return true;
        }
        return checkRowForComplete(backwardSlashDiagonal);
    }

    private String[][] transpose(String[][] board) {
        String[][] result = new String[LENGTH_OF_BOARD_SIDES][LENGTH_OF_BOARD_SIDES];
        for (int i = 0; i < LENGTH_OF_BOARD_SIDES; i++) {
            for (int j = 0; j < LENGTH_OF_BOARD_SIDES; j++) {
                result[j][i] = board[i][j];
            }
        }
        return result;
    }

    private String[][] extractDiagonals(String[][] board) {
        String[][] diagonals = new String[2][LENGTH_OF_BOARD_SIDES];
        int index = 0;
        for (String[] row : board) {
            diagonals[0][index] = row[index];
            diagonals[1][index] = row[(LENGTH_OF_BOARD_SIDES - 1) - index];
            index += 1;
        }
        return diagonals;
    }

    private boolean checkRowForComplete(String[] column) {
        String[] rowOfXs = new String[LENGTH_OF_BOARD_SIDES];
        Arrays.fill(rowOfXs, X);
        String[] rowOfOs = new String[LENGTH_OF_BOARD_SIDES];
        Arrays.fill(rowOfOs, O);

        return Arrays.equals(rowOfXs, column) || Arrays.equals(rowOfOs, column);
    }

    public void highlightWinCells(int startLayer, int stopLayer, int startRow, int stopRow, int startColumn, int stopColumn, boolean isDiagonal) {
        for (int layer = startLayer; layer <= stopLayer; layer++) {
            for (int row = startRow; row <= stopRow; row++) {
                for (int column = startColumn; column <= stopColumn; column++) {
                    if (true) {//if (!isDiagonal){
                        GAME_BOARD[layer][row][column] = "\033[47m" + GAME_BOARD[layer][row][column] + "\033[0m";
                    }
                }
            }
        }
    }

    public String displayBoard() {
        char boardCount = 'A';
        StringBuilder boardsString = new StringBuilder();
        System.out.print("\033[2J");
        for (String[][] board : GAME_BOARD) {
            if (LAYERS_OF_BOARD > 1) {
                boardsString.append("Board ").append(boardCount++).append(":\n");
            }
            boardsString.append(displayOneBoard(board)).append("\n");
        }
        return boardsString.toString();
    }

    public String displayOneBoard(String[][] board) {
        StringBuilder boardString = new StringBuilder("     |");

        for (int row = 0; row < LENGTH_OF_BOARD_SIDES; row += 1) {
            for (int col = 0; row == 0 && col < LENGTH_OF_BOARD_SIDES; col += 1) {
                boardString.append("col ").append(col + 1).append("|");
                if (col == LENGTH_OF_BOARD_SIDES - 1) {
                    demarcateBoardRows(boardString);
                }
            }

            for (int col = 0; col < LENGTH_OF_BOARD_SIDES; col += 1) {
                if (col == 0) {
                    boardString.append("row ").append(row + 1).append("|");
                }
                boardString.append(String.format("%5s|", board[row][col]));
            }
            demarcateBoardRows(boardString);
        }
        return boardString.toString();
    }

    private void demarcateBoardRows(StringBuilder boardString) {
        boardString.append("\n").append("-----+".repeat(LENGTH_OF_BOARD_SIDES + 1)).append("\n");
    }


}


