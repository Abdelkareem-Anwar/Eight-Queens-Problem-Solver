package eightqueen;

import static eightqueen.CheckUserSolution.valid;

/**
 *
 * @author Lenovo
 */
public class CheckDiagonal implements Runnable {

    static int[][] board;
    static int check = 0;

    public CheckDiagonal(int board[][]) {
        this.board = board;
    }

    static public int checkDiagonal(int board[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    for (int m = 1; m < 8; m++) {
                        int tmp1, tmp2;
                        // right under
                        tmp1 = i + m;
                        tmp2 = j + m;
                        if (valid(tmp1, tmp2)) {
                            if (board[tmp1][tmp2] == 1) {
                                return check;
                            }

                            //left upper
                            tmp1 = i - m;
                            tmp2 = j - m;
                            if (valid(tmp1, tmp2)) {
                                if (board[tmp1][tmp2] == 1) {
                                    return check;
                                }
                            }
                            //right upper
                            tmp1 = i - m;
                            tmp2 = j + m;
                            if (valid(tmp1, tmp2)) {
                                if (board[tmp1][tmp2] == 1) {
                                    return check;
                                }
                            }
                            // left down
                            tmp1 = i + m;
                            tmp2 = j - m;
                            if (valid(tmp1, tmp2)) {
                                if (board[tmp1][tmp2] == 1) {
                                    return check;
                                }
                            }
                        }

                    }
                }
            }
        }
        check = 1;
        return check;
    }

    @Override
    public void run() {
        checkDiagonal(board);
    }
}
