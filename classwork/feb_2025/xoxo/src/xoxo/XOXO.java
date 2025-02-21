package xoxo;

public class XOXO {
    private final char[][] board;

    public XOXO(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        char[][] result = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[i][j] = (board[i][j] == 'X') ? '1' : '0';
            }
        }
        return result;
    }

}
