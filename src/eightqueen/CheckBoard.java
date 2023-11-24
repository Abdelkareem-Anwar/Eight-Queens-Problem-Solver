package eightqueen;

public class CheckBoard implements Runnable {

    static int[][] board;
    static int row;
    static int col;

    public CheckBoard(int board[][], int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;

    }

    public static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check row from left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal from left side 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal from left side
        for (i = row, j = col; j >= 0 && i < 8; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {
        isSafe(board, row, col);
    }

}
