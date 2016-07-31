/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Controls the execution of the game.
 * @author gprok
 */
public class GameController implements ActionListener, MouseListener {
    
    public static final int ROWS = 12;
    
    private Board board;
    
    private GameFrame gameFrame;
    private BoardPanel gameBoardPanel;
    private ButtonsPanel btnsPanel;
    
    private int selectedColor;
    
    private int round;
    
    
    public GameController() {
        board = new Board();
        board.setSecretComination();
        
        selectedColor = Cell.TRANSPARENT;
        round = 12;
        
        gameFrame = new GameFrame();
        gameBoardPanel = new BoardPanel(this, board);
        btnsPanel = new ButtonsPanel(this);
        
        
        gameFrame.addBoardPanel(gameBoardPanel);
        gameFrame.addButtonsPanel(btnsPanel);
        
        gameFrame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        String action = e.getActionCommand();
        JButton actionBtn = (JButton)e.getSource();
        
        System.out.println(action);
        
        
        if(action.equals("Guess")) {
            
            int whiteFeedback = board.getWhiteFeedback(round);
            int redFeedback = board.getRedFeedback(round);
            
            board.getCellAt(round, 4).setRedsAndWhites(redFeedback, whiteFeedback);
            
            round--;
            
            btnsPanel.disableGuessBtn();
            
            gameBoardPanel.repaint();
            
            if (redFeedback == 4) {
                JOptionPane.showMessageDialog(gameFrame, "Congrats!");
                round = 0;
            }
            else if(round == 0) {
                JOptionPane.showMessageDialog(gameFrame, "Game over");
            }
        }
        else {
            btnsPanel.setSelectedColorBtn(actionBtn);
            selectedColor = Integer.parseInt(action);
            //setColor(action);
        }
       
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        CellLabel label = (CellLabel)e.getSource();
        Cell cell = label.getCell();
        
        System.out.println(cell.getRow() + " - " + cell.getCol());
         
        if(cell.getRow() == round) {
            cell.setColor(selectedColor);
            
            if(board.isRowCompleted(cell.getRow())) {
                btnsPanel.enableGuessBtn();
            }
        }
        else {
            System.out.println("Not in current round");
        }
       
        gameBoardPanel.repaint();
        /*
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
        
*/
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
