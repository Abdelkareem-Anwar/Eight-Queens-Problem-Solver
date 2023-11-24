package eightqueen;

public class CheckUserRowColumn implements Runnable {

    static int[][] board;
    static int check = 0;

    public CheckUserRowColumn(int board[][]) {
        this.board = board;
    }

    static public int CheckRowColumn(int board[][]) {
        int cnt1 = 0;
        // Moves on every row
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    cnt1++;
                }
            }
            if (cnt1 > 1) {
                return check;
            }
            cnt1 = 0;

        }
        // moves on every column
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[j][i] == 1) {
                    cnt1++;
                }
            }
            if (cnt1 > 1) {
                return check;
            }
            cnt1 = 0;

        }
        check = 1;
        return check;
    }

    @Override
    public void run() {
        CheckRowColumn(board);
    }
}
