/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Handles the main window of the game
 * @author gprok
 */
public class GameFrame extends JFrame {
    
    public GameFrame() {
        this.setSize(320, 600);
        this.setTitle("MASTERMIND");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void addBoardPanel(BoardPanel bp) {
        this.add(bp, BorderLayout.CENTER);
    }
    
    public void addButtonsPanel(ButtonsPanel bp) {
        this.add(bp, BorderLayout.SOUTH);
    }
    
}
