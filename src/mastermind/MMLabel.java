package mastermind;

import javax.swing.JLabel;

/**
 * Label used for the user's guess.
 * It is necessary to know the position of the label and the color allocated 
 * to it by the user.
 */
public class MMLabel extends JLabel {
    
    /** Row where the label lies */
    private int row;
    
    /** Column where the label lies */
    private int column;
    
    /** Color allocated to the label. Initially none */
    private int color;
    
    
    /**
     * Class constructor
     * @param r The row of the label
     * @param c The column of the label 
     */
    public MMLabel(int r, int c) {
        row = r;
        column = c;
        color = -1;
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
    public int getColor() {
        return color;
    }

    
    /**
     * Color mutator
     * @param color The value for color 
     */
    public void setColor(int color) {
        this.color = color;
    }
    
}
