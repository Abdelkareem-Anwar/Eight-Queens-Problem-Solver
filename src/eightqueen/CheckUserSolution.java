package eightqueen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class CheckUserSolution {

    static int[][] board;
    static int row;
    static int col;

    public CheckUserSolution(int[][] board, int row, int col) {
        this.board = board;
        this.row = row;
        this.col = col;
    }

    public static boolean isSafe(int[][] board, int row, int col) throws InterruptedException {
        ExecutorService exService = Executors.newFixedThreadPool(2);
        Runnable process1 = new CheckUserRowColumn(board);
        Runnable process2 = new CheckDiagonal(board);
        exService.execute(process1);
        exService.execute(process2);
        exService.shutdown();
        exService.awaitTermination(10, TimeUnit.SECONDS);
        while (!exService.isTerminated()) { // if executor is still running, it will stuck here until finishing

        }
        if (CheckUserRowColumn.check == 1) {
            return true;
        }
        if (CheckDiagonal.check == 1) {
            return true;
        } else {
            return false;
        }

    }

    // for not going out of boundaries
    public static boolean valid(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return true;
        } else {
            return false;
        }
    }
}
