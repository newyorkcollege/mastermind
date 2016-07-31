/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.util.Random;

/**
 * Logical representation of the game board.
 * Consists of cells. 
 * Has one more row of cells for the secret (row 0) and 
 * one more column for the feedback (col 4)
 * @author gprok
 */
public class Board {
    
    /** The board of the game */
    private Cell board[][];
    
    
    public Board() {
        board = new Cell[13][5];
        
        for(int r = 0; r < 13; r++) {
            for(int c = 0; c < 5; c++) {
                if(r == 0 && c < 4) { 
                    board[r][c] = new Cell(Cell.SECRET, r, c);
                    // cellLabels[r][c].setBackground(Color.RED);
                }
                else if(r == 0 && c == 4) { 
                    board[r][c] = new Cell(Cell.DUMMY, r, c);
                }
                else if(c == 4) {
                    board[r][c] = new Cell(Cell.FEEDBACK, r, c);
                }
                else {
                    board[r][c] = new Cell(Cell.PLAYABLE, r, c);
                    // cellLabels[r][c].addMouseListener(listener);
                }
                // cellLabels[r][c].setBorder(BorderFactory.createEtchedBorder());
                // mainPanel.add(cellLabels[r][c]);
            }
        }
    }
    
    
    
    public Cell getCellAt(int row, int col) {
        return board[row][col];
    }
    
    
    public boolean isRowCompleted(int row) {
        for(int i = 0; i < 4; i++) {
            if(board[row][i].getColor() == Cell.TRANSPARENT) {
                return false;
            }
        }
        return true;
    }
    
    
    
    public void setSecretComination() {
        Random rnd = new Random();
        
        System.out.println("=== SECRET COMBINATION ===");
        
        for(int i = 0; i < 4; i++) {
            boolean colorSet;
            do {
                colorSet = true;
                int color = rnd.nextInt(6) + 1; // Get random value 1 - 6
                board[0][i].setColor(color);
                for(int j = 0; j < i; j++) {
                    if(board[0][i].getColor() == board[0][j].getColor()) {
                        // Color already selected
                        colorSet = false;
                        break;
                    }
                }              
            } while(!colorSet);
            
            System.out.print(board[0][i].getColor() + " ");
        }
        
        System.out.println("=== END OF SECRET COMBINATION ===");
    }
    
    
    int getWhiteFeedback(int row) {
        int total = 0;
        
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i != j && getCellAt(row, i).getColor() == getCellAt(0, j).getColor()) {
                    total++;
                }
            }
        }
        
        return total;
    }
    
    int getRedFeedback(int row) {
        int total = 0;
        
        for(int i = 0; i < 4; i++) {
            if(getCellAt(row, i).getColor() == getCellAt(0, i).getColor()) {
                total++;
            }
        }
        
        return total;
    }
    
}
