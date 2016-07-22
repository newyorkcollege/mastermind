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
    
    public BoardPanel(MouseListener listener) {
        mainPanel = new JPanel(new GridLayout(GameController.ROWS + 1, 5, 2, 2));
        
        this.setLayout(new BorderLayout());
        
        
        cellLabels = new CellLabel[GameController.ROWS+1][5];
        
        for(int r = 0; r < GameController.ROWS + 1; r++) {
            for(int c = 0; c < 5; c++) {
                if(r == 0 && c < 4) { 
                    cellLabels[r][c] = new CellLabel(-1, -1, CellLabel.LABEL_TYPE.SECRET);
                    cellLabels[r][c].setBackground(Color.RED);
                }
                else if(r == 0 && c == 4) { 
                    cellLabels[r][c] = new CellLabel(-1, -1, CellLabel.LABEL_TYPE.DUMMY);
                }
                else if(c == 4) {
                    cellLabels[r][c] = new CellLabel(r-1, c, CellLabel.LABEL_TYPE.FEEDBACK);
                }
                else {
                    cellLabels[r][c] = new CellLabel(r-1, c, CellLabel.LABEL_TYPE.PLAYABLE);
                    cellLabels[r][c].addMouseListener(listener);
                }
                cellLabels[r][c].setBorder(BorderFactory.createEtchedBorder());
                mainPanel.add(cellLabels[r][c]);
            }
        }
        
        this.add(mainPanel, BorderLayout.CENTER);
    }
    
    
    public void setLabelColor(int row, int col, Color color) {
        cellLabels[row+1][col].setColor(color);
        cellLabels[row+1][col].repaint();
        
        this.repaint();
    }
    
}
