/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * Controls the game execution 
 * @author gprok
 */
public class GameController implements ActionListener, MouseListener {
    
    public static final int ROWS = 12;
    public static final int TOTAL_COLORS = 6;
    
    private GameFrame gameFrame;
    private BoardPanel gameBoardPanel;
    private ButtonsPanel btnsPanel;
    
    private Board gameBoard;
    
    private Color currentColor;
    
    private int round;
    
    public GameController() {
        currentColor = null;
        round = ROWS - 1; // reduce by one to match array rows
        
        gameFrame = new GameFrame();
        gameBoardPanel = new BoardPanel(this);
        btnsPanel = new ButtonsPanel(this);
        
        gameBoard = new Board();
        
        gameFrame.addBoardPanel(gameBoardPanel);
        gameFrame.addButtonsPanel(btnsPanel);
        
        gameFrame.setVisible(true);
    }
    
    
    public static void main(String [] args) {
        GameController game = new GameController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        JButton actionBtn = (JButton)e.getSource();
        
        System.out.println(action);
        
        if(action.equals("Guess")) {
            
            round--;
            System.out.println("Round now is " + round);
            
            btnsPanel.disableGuessBtn();
        }
        else {
            btnsPanel.setSelectedColorBtn(actionBtn);
            setColor(action);
        }
    }
    
    
    
    public void setColor(String clr) {
        if(clr.equals("RED")) {
            currentColor = Color.RED;
        }
        else if(clr.equals("ORANGE")) {
            currentColor = Color.ORANGE;
        }
        else if(clr.equals("YELLOW")) {
            currentColor = Color.YELLOW;
        }
        else if(clr.equals("GREEN")) {
            currentColor = Color.GREEN;
        }
        else if(clr.equals("BLUE")) {
            currentColor = Color.BLUE;
        }
        else if(clr.equals("PURPLE")) {
            currentColor = new Color(128, 0, 128);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        CellLabel label = (CellLabel)e.getSource();
        int row = label.getRow(); 
        int col = label.getColumn();
        String text = row + " - " + col;
        if(row == round) {
            System.out.println(text);
            
            gameBoard.setCellColor(currentColor, row, col);
            gameBoardPanel.setLabelColor(row, col, gameBoard.getCellAt(row, col).getColor());
            
            if(gameBoard.isRowCompleted(row)) {
                btnsPanel.enableGuessBtn();
            }
        }
        else {
            System.out.println(text + " not in current round");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }

    
    
}
