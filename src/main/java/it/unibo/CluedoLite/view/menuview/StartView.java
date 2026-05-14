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
        setLocationRelativeTo(null); //center the window on screen
        getContentPane().setBackground(AppColorFont.BACKGROUND_MEDIUM);

        //Use to center components
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; //same column
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Title lable
        JLabel title = new JLabel("CLUEDO LITE", SwingConstants.CENTER);
        title.setFont(AppColorFont.FONT_TITLE);
        title.setForeground(AppColorFont.TEXT_PRIMARY);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(title, gbc);

        final JButton rulesButton = new JButton("RULES");
        rulesButton.setFont(AppColorFont.FONT_BUTTON);
        rulesButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        rulesButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        rulesButton.setFocusPainted(false);
        rulesButton.setBorderPainted(false);
       rulesButton.addActionListener(e -> JOptionPane.showMessageDialog(
            null,
            "CLUEDO LITE RULES:\n\n" +
            "OBJECTIVE:\n" +
            "Find out who committed the crime, with which weapon and in which room\n\n" +
            "TURN:\n" +
            "1. Move to an adjacent room\n" +
            "2. Make a suspicion OR a final accusation\n" +
            "3. Click 'End Turn' to pass to the next player\n\n" +
            "PLAYERS:\n" +
            "- A game can be played by 3 to 6 players\n" +
            "- A player can choose only one character\n" +
            "- A character can be chosen by only one player\n\n" +
            "SUSPICION:\n" +
            "- You can only suspect in the room where you are\n" +
            "- Choose a character and a weapon\n" +
            "- Other players show a card to disprove if they have one\n\n" +
            "ACCUSATION:\n" +
            "- Choose character, weapon AND room\n" +
            "- Correct: you win!\n" +
            "- Wrong: you are eliminated!\n\n" +
            "NOTE:\n" +
            "You must make a suspicion or accusation before ending your turn",
            "Rules",
            JOptionPane.INFORMATION_MESSAGE
        ));
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 30, 0);
        add(rulesButton, gbc);

        // NEW GAME Button 
        startButton = new JButton("NEW GAME");
        startButton.setFont(AppColorFont.FONT_BUTTON);
        startButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        startButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        startButton.setPreferredSize(new Dimension(350, 60));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.addActionListener(e -> controller.onStartClicked(this));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(startButton, gbc);

        //Label showing the number of players allowed
        JLabel players = new JLabel("3 - 6 players", SwingConstants.CENTER);
        players.setFont(AppColorFont.FONT_BODY);
        players.setForeground(AppColorFont.TEXT_PRIMARY);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(players, gbc);

        setVisible(true);
    }
}