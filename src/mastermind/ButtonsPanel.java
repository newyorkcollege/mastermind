/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Handles the buttons of the application
 * @author gprok
 */
public class ButtonsPanel extends JPanel {
    
    private JButton playBtn;
    private JButton [] colorBtns;
    
    private JPanel btnPanel;
    
    private JButton selectedColor;
    
    public ButtonsPanel(ActionListener listener) {
        this.setLayout(new BorderLayout());
        
        selectedColor = null;
        
        playBtn = new JButton("Guess");
        playBtn.setActionCommand("Guess");
        playBtn.addActionListener(listener);
        playBtn.setEnabled(false);
        
        this.add(playBtn, BorderLayout.NORTH);
        
        btnPanel = new JPanel(new GridLayout(1, 6, 1, 1));
        
        colorBtns = new JButton[GameController.TOTAL_COLORS];
        
        for(int i = 0; i < GameController.TOTAL_COLORS; i++) {
            colorBtns[i] = new JButton(" ");
            if(i == 0) {
                colorBtns[i].setBackground(Color.red);
                colorBtns[i].setForeground(Color.red);
                colorBtns[i].setActionCommand("RED");
            }
            else if(i == 1) {
                colorBtns[i].setBackground(new Color(255, 165, 0)); // orange
                colorBtns[i].setForeground(new Color(255, 165, 0));
                colorBtns[i].setActionCommand("ORANGE");
            }
            else if(i == 2) {
                colorBtns[i].setBackground(Color.yellow);   
                colorBtns[i].setForeground(Color.yellow);
                colorBtns[i].setActionCommand("YELLOW");
            }
            else if(i == 3) {
                colorBtns[i].setBackground(Color.green);
                colorBtns[i].setForeground(Color.green);
                colorBtns[i].setActionCommand("GREEN");
            }
            else if(i == 4) {
                colorBtns[i].setBackground(Color.blue);
                colorBtns[i].setForeground(Color.blue);
                colorBtns[i].setActionCommand("BLUE");
            }
            else if(i == 5) {
                colorBtns[i].setBackground(new Color(128, 0, 128)); // purple
                colorBtns[i].setForeground(new Color(128, 0, 128));
                colorBtns[i].setActionCommand("PURPLE");
            }
            
            colorBtns[i].setOpaque(true);
            colorBtns[i].setBorderPainted(false);
            colorBtns[i].addActionListener(listener);
            
            btnPanel.add(colorBtns[i]);
        }
        
        this.add(btnPanel, BorderLayout.CENTER);
        
        this.add(new JLabel("(c) NYC 2016"), BorderLayout.SOUTH);
    }
    
    
    public void setSelectedColorBtn(JButton newColorBtn) {
        if(selectedColor != null) {
            selectedColor.setSelected(false);
        }
        selectedColor = newColorBtn;
        selectedColor.setSelected(true);
    }
    
    
    public void enableGuessBtn() {
        playBtn.setEnabled(true);
    }
    
    
    public void disableGuessBtn() {
        playBtn.setEnabled(false);
    }
    
}
