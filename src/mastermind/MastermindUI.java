package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * UI for the mastermind game
 */
public class MastermindUI extends JFrame implements ActionListener, MouseListener {
   
    
    /** Labels to display user guesses */
    private MMLabel [][] gameLabels;
    
    /** Buttons for color selection */
    private JButton [] colorButtons;
    
    /** Panel to display the game labels */
    private JPanel gamePanel;
    
    /** Panel to display the color selection buttons */
    private JPanel selectColorPanel;
    
    /** Button to ignite next user's guess */
    private JButton guessButton;
    
    
    
    /**
     * Class constructor. Sets up the UI
     */
    public MastermindUI() {
        
        createUI();
        
        buildPanels();
        
        this.add(gamePanel, BorderLayout.CENTER);
        
        this.add(guessButton, BorderLayout.SOUTH);
        
        this.add(selectColorPanel, BorderLayout.WEST);
           
        this.setVisible(true);
        
    }
    
    
    /**
     * Sets up the main UI
     */
    public void createUI() {
        this.setSize(220, 520); 
        this.setTitle("JMastermind");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(13, 5));
        
        selectColorPanel = new JPanel();
        selectColorPanel.setLayout(new GridLayout(6, 1));
        
        guessButton = new JButton("Guess");
    }
    
    
    /**
     * Builds the panels for the game. The central one with the labels and the 
     * secondary one with the color selection buttons.
     */
    public void buildPanels() {
        gameLabels = new MMLabel[13][5];
        
        for(int row = 0; row < 13; row++ ) {
            for(int col = 0; col < 5; col++) {
                gameLabels[row][col] = new MMLabel(row, col);
                if(row == 0) {
                    if(col != 4) {
                        gameLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                    }
                }
                else if(col == 4) {
                    gameLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.CYAN));
                }
                else {
                    gameLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                 
                    gameLabels[row][col].addMouseListener(this);
                }
                gamePanel.add(gameLabels[row][col]);
            }
        }
        
        colorButtons = new JButton[6];
        colorButtons[0] = new JButton("Red");
        colorButtons[0].setActionCommand("RED");
        colorButtons[1] = new JButton("Ora");
        colorButtons[1].setActionCommand("ORANGE");
        colorButtons[2] = new JButton("Yel");
        colorButtons[2].setActionCommand("YELLOW");
        colorButtons[3] = new JButton("Gre");
        colorButtons[3].setActionCommand("GREEN");
        colorButtons[4] = new JButton("Blu");
        colorButtons[4].setActionCommand("BLUE");
        colorButtons[5] = new JButton("Pur");
        colorButtons[5].setActionCommand("PURPLE");
        for(int i = 0; i < 6; i++) {
            colorButtons[i].addActionListener(this);
            selectColorPanel.add(colorButtons[i]);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println(action + " CLICKED!");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MMLabel label = (MMLabel)e.getSource();
        String text = label.getRow() + " - " + label.getColumn();
        System.out.println(text);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }
    
    /* Main method starting the program */
    public static void main(String [] args) {
        MastermindUI ui = new MastermindUI();
    }
    
}
