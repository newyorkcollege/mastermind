package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 * Label used for the user's guess.
 * It is necessary to know the position of the label and the color allocated 
 * to it by the user.
 */
public class CellLabel extends JLabel implements CellObserver {
    
    
    private Cell cell;
    
    
    /**
     * Class constructor
     */
    public CellLabel(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
    
    
    
    public Color findColor(int clr) {
        if(clr == 1) {
            return Color.RED;
        }
        else if(clr == 2) {
            return Color.ORANGE;
        }
        else if(clr == 3) {
            return Color.YELLOW;
        }
        else if(clr == 4) {
            return Color.GREEN;
        }
        else if(clr == 5) {
            return Color.BLUE;
        }
        else if(clr == 6) {
            return Color.MAGENTA;
        }
        else { // shouldn't reach this point
            return Color.WHITE;
        }
    }

    public void update() {
        this.repaint();
    }
    
    
    public void paintComponent(Graphics g) {
        
        int width = this.getWidth();
        int height = this.getHeight();
        
        if (cell.getType() == Cell.PLAYABLE && cell.getColor() == Cell.TRANSPARENT) {
            g.setColor(Color.BLACK);
            g.fillOval(width/2-2, height/2-2, 4, 4);
        }
        else if (cell.getType() == Cell.PLAYABLE) {
            g.setColor(findColor(cell.getColor()));
            g.fillOval(width/2-10, height/2-10, 20, 20);
        }
        else if(cell.getType() == Cell.FEEDBACK) {
            g.setColor(Color.RED);
            int col = 10;
            for(int i = 0; i < cell.getReds(); i++) {
                g.fillOval(col, 8, 7, 7);
                col += 10;
            }
            g.setColor(Color.WHITE);
            col = 10;
            for(int i = 0; i < cell.getWhites(); i++) {
                g.fillOval(col, 18, 7, 7);
                col += 10;
            }
        }
    }
    
}

