/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

/**
 * Logical representation of a single cell
 * Cells can be of 4 types:
 * PLAYABLE, SECRET, FEEDBACK, and DUMMY
 * @author gprok
 */
public class Cell {
    
    public static final int DUMMY = 0;
    public static final int PLAYABLE = 1;
    public static final int SECRET = 2;
    public static final int FEEDBACK = 3;
    
    public static final int TRANSPARENT = 0;
    public static final int RED = 1;
    public static final int ORANGE = 2;
    public static final int YELLOW = 3;
    public static final int GREEN = 4;
    public static final int BLUE = 5;
    public static final int PURPLE = 6;
    
    
    private CellObserver observer;
    
    
    /** Indicates the cell type */
    private int type;
    
    /** Indicates the cell color */
    private int color;
    
    /** Indicates how many white feedback pins are on this feedback cell */
    private int whites;
    
    /** Indicates how many red feedback pins are on this feedback cell */
    private int reds;
    
    private int row;
    
    private int col;
    
    
    public Cell(int type, int row, int col) {
        setType(type);
        color = TRANSPARENT;
        whites = reds = 0;
        observer = null;
        this.row = row;
        this.col = col;
    }
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        updateObserver();
    }

    public int getWhites() {
        return whites;
    }

    public void setWhites(int whites) {
        this.whites = whites;
        updateObserver();
    }

    public int getReds() {
        return reds;
    }

    public void setReds(int reds) {
        this.reds = reds;
        updateObserver();
    }
    
    public void setRedsAndWhites(int reds, int whites) {
        this.reds = reds;
        this.whites = whites;
        updateObserver();
    }

    public void setObserver(CellObserver observer) {
        this.observer = observer;
    }
      
    
    public void updateObserver() {
        if (observer != null) {
            observer.update();
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    
}
