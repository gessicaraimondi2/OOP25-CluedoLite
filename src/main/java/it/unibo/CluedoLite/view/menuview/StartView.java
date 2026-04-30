package it.unibo.CluedoLite.view.menuview;

import javax.swing.*;

import it.unibo.CluedoLite.controller.menucontroller.api.StartController;
import it.unibo.CluedoLite.view.AppColorFont;

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
    public StartView(final StartController controller) {
        setTitle("Cluedo Lite");
        setSize(700, 720);
        setLocationRelativeTo(null); //center the window on screen
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(AppColorFont.BACKGROUND_MEDIUM);

        //Use to center components
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; //same column
        gbc.insets = new Insets(80, 0, 10, 0);

        // Title lable
        JLabel title = new JLabel("CLUEDO LITE", SwingConstants.CENTER);
        title.setFont(AppColorFont.FONT_TITLE);
        title.setForeground(AppColorFont.TEXT_PRIMARY);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        add(title, gbc);

        // NEW GAME Button 
        startButton = new JButton("NEW GAME");
        startButton.setFont(AppColorFont.FONT_BUTTON);
        startButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        startButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        startButton.setPreferredSize(new Dimension(350, 60));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.addActionListener(e -> controller.onStartClicked());
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(startButton, gbc);

        //Label showing the number of players allowed
        JLabel players = new JLabel("3 - 6 players", SwingConstants.CENTER);
        players.setFont(AppColorFont.FONT_BODY);
        players.setForeground(AppColorFont.TEXT_PRIMARY);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(players, gbc);

        setVisible(true);
    }
}