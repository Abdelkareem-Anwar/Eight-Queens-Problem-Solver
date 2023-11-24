
package eightqueen;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CheckSolutionUI extends JPanel {

    char Queen = 'Q';
    JButton[] btn = new JButton[8];

    public CheckSolutionUI() {
        setLayout(new GridLayout(8, 8));
        initializeButtons();
    }

    public void initializeButtons() {
        for (int i = 0; i < 8; i++) {
            btn[i] = new JButton();
            btn[i].setText("-");
            btn[i].setBackground(Color.white);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btnClicked = (JButton) e.getSource();// get the button which clicked
                    btnClicked.setText(String.valueOf(Queen));
                    if (Queen == 'Q') {
                        btnClicked.setBackground(Color.CYAN);
                    }
                    displayVector();
                }
            });
            add(btn[i]);
        }
    }

    public void displayVector() {
        //if (checkUserSolutiom == true) {
            
      //  }
    }
}
