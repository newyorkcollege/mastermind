/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.Color;

/**
 * Logical representation of a cell on the game board.
 * @author gprok
 */
public class Cell {
    
    private Color color;
    
    public Cell() {
        color = null;
    }
    
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
}
