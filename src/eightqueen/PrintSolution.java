package eightqueen;

public class PrintSolution {
    // print solution of 8 Queen

    public static void printSolution(int board[][]) {
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + board[i][j]
                        + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.println();
    }

}
