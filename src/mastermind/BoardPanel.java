/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Handles a the board UI
 * @author gprok
 */
public class BoardPanel extends JPanel {
    
    private CellLabel [][] cellLabels;
    private CellLabel [] secretLabels;
    
    private JPanel secretPanel;
    private JPanel mainPanel;
    
    public BoardPanel(MouseListener listener, Board board) {
        mainPanel = new JPanel(new GridLayout(GameController.ROWS + 1, 5, 2, 2));
        
        this.setLayout(new BorderLayout());
        
        
        cellLabels = new CellLabel[GameController.ROWS+1][5];
        
        for(int r = 0; r < GameController.ROWS + 1; r++) {
            for(int c = 0; c < 5; c++) {
                
                Cell cell = board.getCellAt(r, c);
                
                cellLabels[r][c] = new CellLabel(cell);
                    
                if(cell.getType() == Cell.SECRET) { 
                    cellLabels[r][c].setBackground(Color.RED);
                }
                else if(cell.getType() == Cell.DUMMY) { 
                    // no action
                }
                else if(cell.getType() == Cell.FEEDBACK) {
                    // no action
                }
                else {
                    cellLabels[r][c].addMouseListener(listener);
                }
                
                cellLabels[r][c].setBorder(BorderFactory.createEtchedBorder());
                mainPanel.add(cellLabels[r][c]);
            }
        }
        
        this.add(mainPanel, BorderLayout.CENTER);
    }
    
}

