package eightqueen;

import javax.swing.*;
import java.awt.*;

public class UI extends JPanel {

    int[][] board;

    public UI(int[][] board) {
        this.board = board;
    }

    public JPanel myPanel() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        boolean evenRow = true;
        ImageIcon icon;
        JButton btn;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    icon = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\NQueen\\EightQueen\\src\\eightqueen\\queen.png");
                    if (icon.getImageLoadStatus() != 4) {
                        btn = new JButton(icon);
                    } else {
                        btn = new JButton("");
                    }

                } else {
                    btn = new JButton("");
                }

                btn.setPreferredSize(new Dimension(64, 64));
                btn.setFocusPainted(false);
                btn.setEnabled(false);
                if (evenRow == true) {
                    if (j == 8 - 1) {
                        evenRow = false;
                    }
                    if (j % 2 == 0) {
                        btn.setBackground(Color.WHITE);
                        panel.add(btn);
                    } else {
                        btn.setBackground(Color.BLACK);
                        panel.add(btn);
                    }

                } else {
                    if (j == 8 - 1) {
                        evenRow = true;
                    }
                    if (j % 2 == 0) {
                        btn.setBackground(Color.BLACK);
                        panel.add(btn);
                    } else {
                        btn.setBackground(Color.WHITE);
                        panel.add(btn);
                    }
                }
            }

        }
        return panel;
    }
}
