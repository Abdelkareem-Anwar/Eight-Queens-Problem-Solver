package eightqueen;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EightQueen {

    public static void main(String[] args) throws InterruptedException {
        String name;
        name = JOptionPane.showInputDialog("Enter 1 to solve the board , Enter 2 to check your board ");
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(name);
        ExecutorService exService = Executors.newFixedThreadPool(1);
        if (number == 1) {
            JFrame frame = new JFrame();
            frame.setSize(700, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("8 QUEENS PROBLEM");
            frame.setVisible(true);
            int board[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
            };
            Runnable process1 = new SolveQueen(frame, board, 0);
            exService.execute(process1);
            exService.shutdown();
            while (!exService.isTerminated()) { // if executor is still running, it will stuck here until finishing

            }
        } else {
            CheckUserGUI.main(args);
        }
    }
}
