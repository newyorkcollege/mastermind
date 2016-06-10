package mastermind;

import java.util.Random;

/**
 * Logic of the mastermind game
 */
public class Mastermind {
    
    public enum Colors {RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE};
    public static final int TOTAL_COLORS = 6;
    
    /** Stores the secret code */
    private int [] secretCode;
    
    
    /**
     * Class constructor, performs intialization of member vars
     */
    public Mastermind() {
        secretCode = new int[4];
    }
    
    
    /**
     * Prepares a new game, generating a random secret code
     */
    public void newGame() {
        Random rnd = new Random();
        
        for(int i = 0; i < 4; i++) {
            boolean colorSet;
            do {
                colorSet = true;
                int color = rnd.nextInt(TOTAL_COLORS);
                System.out.println(color);
                secretCode[i] = color;
                for(int j = 0; j < i; j++) {
                    if(secretCode[i] == secretCode[j]) {
                        // Color already selected
                        colorSet = false;
                        break;
                    }
                }              
            } while(!colorSet);
        }
    }
    
    
    /**
     * Prints the secret code 
     */
    public void printCode() {
        for(int i = 0; i < 4; i++) {
            System.out.print(secretCode[i] + " ");
        }
        System.out.println();
    }

    
    /* Main provided just for testing current class */
    public static void main(String[] args) {
        // Start 100 games and print the secret code in order to check that it works
        Mastermind mm = new Mastermind();
        
        for(int i = 0; i < 100; i++) {
            mm.newGame();
            mm.printCode();
        }
    }
    
}
