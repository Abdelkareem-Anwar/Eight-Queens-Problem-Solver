package eightqueen;

import javax.swing.JFrame;

public class SolveQueen implements Runnable {

    static int[][] board;
    static int col;
    static JFrame frame;

    public SolveQueen(JFrame frame, int[][] board, int col) {
        this.frame = frame;
        SolveQueen.board = board;
        SolveQueen.col = col;
    }

    public static boolean solveNQ(JFrame frame, int[][] board, int col) {
        // base case: all queen placed return true
        if (col >= 8) {
            return true;
        }

        // looking for column and putting queen in each row
        for (int i = 0; i < 8; i++) {
            // Check if the queen can be placed on board[i][col] 
            if (CheckBoard.isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                frame.setContentPane(new UI(board).myPanel());
                frame.setVisible(true);
                // recur to place rest of the queens 
                if (solveNQ(frame, board, col + 1) == true) {
                    return true;
                }
                frame.setContentPane(new UI(board).myPanel());
                frame.setVisible(true);
                // if queen can't be placed even in col or row then do backtrack
                board[i][col] = 0; // BACKTRACK
            }
        }

        // all queen can't be placed return false
        return false;
    }

    @Override
    public void run() {
        if (solveNQ(frame, board, 0) == true) {
            PrintSolution.printSolution(board);
        }
    }
}
