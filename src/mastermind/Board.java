/*
 * This project is open source, under the MIT licence.
 */
package mastermind;

import java.awt.Color;
import java.util.Random;

/**
 * Logical representation of the game board
 * @author gprok
 */
public class Board {
    
    private Cell [][] board;
    private Cell [] secretBoard;
    
    public Board() {
        board = new Cell[GameController.ROWS][4];
        for(int r = 0; r < GameController.ROWS; r++) {
            for(int c = 0; c < 4; c++) {
                board[r][c] = new Cell();
            }
        }
        secretBoard = new Cell[4];
        for(int i = 0; i < 4; i++) {
            secretBoard[i] = new Cell();
        }
    }
    
    public void setSecretComination() {
        Random rnd = new Random();
        
        for(int i = 0; i < 4; i++) {
            boolean colorSet;
            do {
                colorSet = true;
                int color = rnd.nextInt(GameController.TOTAL_COLORS);
                System.out.println(color);
                secretBoard[i].setColor(getColorValue(rnd.nextInt(6)));
                for(int j = 0; j < i; j++) {
                    if(secretBoard[i].getColor() == secretBoard[j].getColor()) {
                        // Color already selected
                        colorSet = false;
                        break;
                    }
                }              
            } while(!colorSet);
        }
    }
    
    
    public Color getColorValue(int c) {
        if(c == 0) {
            return Color.RED;
        }
        else if(c == 1) {
            return Color.ORANGE;
        }
        else if(c == 2) {
            return Color.YELLOW;
        }
        else if(c == 3) {
            return Color.GREEN;
        }
        else if(c == 4) {
            return Color.BLUE;
        }
        else if(c == 5) {
            return new Color(128, 0, 128);
        }
        
        return null;
        
    }
    
    public Cell getCellAt(int row, int col) {
        return board[row][col];
    }
    
    
    public void setCellColor(Color color, int row, int col) {
        board[row][col].setColor(color);
    }
    
    public boolean isRowCompleted(int row) {
        for(int i = 0; i < 4; i++) {
            if(getCellAt(row, i).getColor() == null) {
                return false;
            }
        }
        return true;
    }
    
}
