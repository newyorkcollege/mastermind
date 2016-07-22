package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 * Label used for the user's guess.
 * It is necessary to know the position of the label and the color allocated 
 * to it by the user.
 */
public class CellLabel extends JLabel {
    
    public enum LABEL_TYPE {PLAYABLE, SECRET, FEEDBACK, DUMMY};
    
    /** Row where the label lies */
    private int row;
    
    /** Column where the label lies */
    private int column;
    
    /** Color allocated to the label. Initially none */
    private Color color;
    
    /** Indicates if the label is selectable by the user or not, hidden, or feedback label */
    private LABEL_TYPE labelType;
    
    
    /**
     * Class constructor
     * @param r The row of the label
     * @param c The column of the label 
     */
    public CellLabel(int r, int c, LABEL_TYPE lType) {
        row = r;
        column = c;
        color = null;
        labelType = lType;
    }

    
    /**
     * Row accessor
     * @return The row of the label
     */
    public int getRow() {
        return row;
    }

    
    /**
     * Row mutator
     * @param row The value for the row
     */
    public void setRow(int row) {
        this.row = row;
    }

    
    /**
     * Column accessor
     * @return The column
     */
    public int getColumn() {
        return column;
    }

    
    /**
     * Column mutator
     * @param column The value for the column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    
    /**
     * Color accessor
     * @return The color
     */
    public Color getColor() {
        return color;
    }

    
    /**
     * Color mutator
     * @param color The value for color 
     */
    public void setColor(Color color) {
        this.color = color;
        System.out.println("New color " + color);
    }
    
    
    public void paintComponent(Graphics g) {
        
        int width = this.getWidth();
        int height = this.getHeight();
        
        if(labelType == LABEL_TYPE.PLAYABLE && color == null) {
            g.fillOval(width/2-2, height/2-2, 4, 4);
        }
        else if(labelType == LABEL_TYPE.PLAYABLE) {
            g.setColor(color);
            g.fillOval(width/2-10, height/2-10, 20, 20);
        }
    }
    
}
