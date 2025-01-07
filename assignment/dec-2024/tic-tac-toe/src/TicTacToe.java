import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private final        int          noOfPlayers;
    private final        int          difficultLevel;
    private final        String       X     = CellValues.X.value;
    private final        String       O     = CellValues.O.value;
    private final        String[][][] gameBoard;
    private final static Scanner      input = new Scanner(System.in);

    private final int NO_OF_CELLS_IN_BOARD;
    private final int MIN_NO_OF_MOVES_FOR_A_WIN;
    private final int LENGTH_OF_BOARD_SIDE;
    private final int LAYERS;

    public TicTacToe(int noOfPlayers, int difficultLevel) {
        this.noOfPlayers = noOfPlayers;
        this.difficultLevel = difficultLevel;
        this.gameBoard = switch (difficultLevel) {
            case 1 -> BoardTypes.EASY.board;
            case 2 -> BoardTypes.HARD.board;
            case 3 -> BoardTypes.DANGEROUS.board;
            default -> throw new IllegalStateException("Unexpected value: " + difficultLevel);
        };
        this.LAYERS = this.gameBoard.length;
        this.LENGTH_OF_BOARD_SIDE = this.gameBoard[0].length;
        this.NO_OF_CELLS_IN_BOARD = (int) (this.LAYERS * Math.pow(LENGTH_OF_BOARD_SIDE, 2));
        this.MIN_NO_OF_MOVES_FOR_A_WIN = (this.LENGTH_OF_BOARD_SIDE * 2) - 1;
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
        reset(gameBoard);
        String token;

        for (int index = 1; index <= NO_OF_CELLS_IN_BOARD; index += 1) {
            System.out.println(displayBoard(gameBoard));
            if (index % 2 == 0) {
                token = X;
                collectNextMove(gameBoard, token);
            } else {
                token = O;
                collectNextMove(gameBoard, token);
            }

            if (index >= MIN_NO_OF_MOVES_FOR_A_WIN && checkForWinner(gameBoard)) {
                System.out.println(displayBoard(gameBoard));
                System.out.printf("GAME OVER\nPlayer%s Wins\n", token);
                break;
            } else if (index == NO_OF_CELLS_IN_BOARD) {
                System.out.println(displayBoard(gameBoard));
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

    public void collectNextMove(String[][][] board, String token) {
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

    public boolean addToken(String[][][] board, String token, int layer, int row, int column) {
        if (board[layer - 1][row - 1][column - 1].equals(CellValues.EMPTY.value)) {
            board[layer - 1][row - 1][column - 1] = token;
            return true;
        }else {
            return false;
        }
    }

    private int collectLayer() {
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

    public int collectRowOrColumn() {
        int number = 0;
        do {
            if (number != 0) {
                System.out.print("Invalid input, try again!>> ");
            }
            number = input.nextInt();
        } while (number < 1 || number > this.LENGTH_OF_BOARD_SIDE);
        return number;
    }

    public boolean checkForWinner(String[][][] boards) {
        if (boards.length == 1){
            return checkBoardForComplete(boards[0]);
        } else {
            for (String[][] board : boards) {
                if (checkBoardForComplete(board)) { return true; }
            }
            for (int i = 0; i < LENGTH_OF_BOARD_SIDE; i += 1) {
                for (int j = 0; j < LENGTH_OF_BOARD_SIDE; j += 1) {
                    if(checkUpDownVerticals(boards, i, j)) { return true; }
                }
            }

            if(checkSidesDiagonalsOnYAxis(boards)) { return true; }
            if(checkSidesDiagonalsOnXAxis(boards)) { return true; }

//            if(checkEdgeDiagonals(boards)) { return true; }

        }

//        transposing a cube
        return false;
    }

    private boolean checkSidesDiagonalsOnYAxis(String[][][] boards) {
        boolean backwardSlash =
                boards[0][0][0].equals(boards[1][1][0]) &&
                boards[0][0][0].equals(boards[2][2][0]) &&
                boards[0][0][0].equals(boards[3][3][0]);

        boolean forwardSlash =
                boards[0][3][0].equals(boards[1][2][1]) &&
                boards[0][3][0].equals(boards[2][1][1]) &&
                boards[0][3][0].equals(boards[3][0][1]);

        return backwardSlash || forwardSlash;
    }


    private boolean checkSidesDiagonalsOnXAxis(String[][][] boards) {
        boolean backwardSlash = boards[0][0][1].equals(boards[1][1][1]) &&
                boards[0][0][0].equals(boards[2][2][1]) &&
                boards[0][0][0].equals(boards[3][3][1]);

        boolean forwardSlash = boards[0][3][1].equals(boards[1][2][1]) &&
                boards[0][3][1].equals(boards[2][1][1]) &&
                boards[0][3][1].equals(boards[3][0][1]);

        return backwardSlash || forwardSlash;
    }


//    todo
//    todo too good that you cant be ignored
//    todo self assessment - log book doc
//    todo draft a plan for January target -> ensure to plan it today to avoid time spilling
//    todo do it like an Excel sheet
//    todo battle procrastination
//    todo dont be too conformable with a single language, avoid preference
//    todo three idiot money will pursuit excellence - pants down

    private boolean checkUpDownVerticals(String[][][] boards, int row, int col) {
        return  boards[0][row][col].equals(boards[1][row][col]) &&
                boards[0][row][col].equals(boards[2][row][col]) &&
                boards[0][row][col].equals(boards[3][row][col]);
    }

    private boolean checkBoardForComplete(String[][] board) {
        String[][] columns = transpose(board);
        String[] backwardSlashDiagonal = extractDiagonals(board)[0];
        String[] forwardSlashDiagonal = extractDiagonals(board)[1];

        for (String[] row : board) {
            if (checkRowForComplete(row)){ return true; }
        }
        for (String[] column: columns) {
            if (checkRowForComplete(column)){ return true; }
        }
        if (checkRowForComplete(forwardSlashDiagonal)){ return true; }
        return checkRowForComplete(backwardSlashDiagonal);
    }

    private String[][] transpose(String[][] board) {
        String[][] result = new String[LENGTH_OF_BOARD_SIDE][LENGTH_OF_BOARD_SIDE];
        for (int i = 0; i < LENGTH_OF_BOARD_SIDE; i++) {
            for (int j = 0; j < LENGTH_OF_BOARD_SIDE; j++) {
                result[j][i] = board[i][j];
            }
        }
        return result;
    }

    private String[][] extractDiagonals(String[][] board) {
        String[][] diagonals = new String[2][LENGTH_OF_BOARD_SIDE];
        int index = 0;
        for (String[] row : board) {
            diagonals[0][index] = row[index];
            diagonals[1][index] = row[(LENGTH_OF_BOARD_SIDE - 1) - index];
            index += 1;
        }
        return diagonals;
    }

    private boolean checkRowForComplete(String[] column) {
        String[] rowOfXs = new String[LENGTH_OF_BOARD_SIDE];
        Arrays.fill(rowOfXs, X);
        String[] rowOfOs = new String[LENGTH_OF_BOARD_SIDE];
        Arrays.fill(rowOfOs, O);

        return Arrays.equals(rowOfXs, column) || Arrays.equals(rowOfOs, column);
    }

//    public void highlightWinCells(String[][][] board,
//                                  int row1, int col1,//level1
//                                  int row2, int col2,//level2
//                                  int row3, int col3) {//level3
//        board[row1][col1] = "\033[47m" + board[row1][col1];
//        board[row2][col2] = "\033[47m" + board[row2][col2];
//        board[row3][col3] = "\033[47m" + board[row3][col3];
//    }



    public String displayBoard(String[][][] boards) {
        char boardCount = 'A';
        StringBuilder boardsString = new StringBuilder();
        System.out.print("\033[2J");
        for (String[][] board : boards) {
            if (LAYERS > 1){
                boardsString.append("Board ").append(boardCount++).append(":\n");
            }
            boardsString.append(displayOneBoard(board)).append("\n");
        }
        return boardsString.toString();
    }

    public String displayOneBoard(String[][] board) {
        if (LENGTH_OF_BOARD_SIDE == 3){
            return String.format(
                    "      col 1 col 2 col 3 %n" +
                            "     +-----+-----+-----+%n" +
                            "row 1|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+%n" +
                            "row 2|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+%n" +
                            "row 3|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+%n",
                    board[0][0], board[0][1], board[0][2],
                    board[1][0], board[1][1], board[1][2],
                    board[2][0], board[2][1], board[2][2]
            );
        } else if (LENGTH_OF_BOARD_SIDE == 4) {
            return String.format(
                    "      col 1 col 2 col 3 col 4 %n" +
                            "     +-----+-----+-----+-----+%n" +
                            "row 1|%5s|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+-----+%n" +
                            "row 2|%5s|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+-----+%n" +
                            "row 3|%5s|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+-----+%n" +
                            "row 4|%5s|%5s|%5s|%5s|%n" +
                            "     +-----+-----+-----+-----+%n",
                    board[0][0], board[0][1], board[0][2], board[0][3],
                    board[1][0], board[1][1], board[1][2], board[1][3],
                    board[2][0], board[2][1], board[2][2], board[2][3],
                    board[3][0], board[3][1], board[3][2], board[3][3]
            );
        }
        return "Board of (`"+ LENGTH_OF_BOARD_SIDE + " X " + LENGTH_OF_BOARD_SIDE + ") not supported. Yet!";
    }


}


