package it.unibo.CluedoLite.view.menuview;

import javax.swing.*;
import java.awt.*;
/*
 * Main menu screen
*  this is the first thing the user sees when the game starts
 * It shows thetitle, a button to start a new game,
 * and players info
 */
public class StartView extends JFrame {

    // The button that starts a new game
    private JButton startButton;

    //Creates and displays the main menu screen
    public StartView() {
        setTitle("Cluedo Lite");
        setSize(480, 520);
        setLocationRelativeTo(null); //center the window on screen
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(160, 28, 28));

        //Use to center components
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; //same column
        gbc.insets = new Insets(80, 0, 10, 0);

        // Title lable
        JLabel title = new JLabel("CLUEDO LITE", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        add(title, gbc);

        // START Button 
        startButton = new JButton("NEW GAME");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        startButton.setBackground(new Color(100 ,10 ,10));
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(startButton, gbc);

        //Label showing the number of players allowed
        JLabel players = new JLabel("3 - 6 players", SwingConstants.CENTER);
        players.setFont(new Font("SansSerif", Font.PLAIN, 12));
        players.setForeground(Color.WHITE);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(players, gbc);

        setVisible(true);
    }
     /*
     * Returns the start button (used by controller)
     */
    public JButton getStartButton() {
        return startButton;
    }
}