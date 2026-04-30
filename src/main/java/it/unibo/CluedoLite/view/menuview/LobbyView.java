package it.unibo.CluedoLite.view.menuview;

import javax.swing.*;

import it.unibo.CluedoLite.controller.menucontroller.api.LobbyController;
import it.unibo.CluedoLite.view.AppColorFont;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LobbyView extends JFrame {

    private JComboBox<Integer> numPlayersBox; // menu for the number of player
    private JPanel playersPanel;
    private List<JComboBox<String>> characterBoxes; //list of player 

    private static final String[] CHARACTERS = {
        "Miss Scarlet",
        "Colonel Mustard",
        "Mrs. White",
        "Mr. Green",
        "Mrs. Peacock",
        "Professor Plum"
    };

    public LobbyView(final LobbyController controller) {
        setTitle("Cluedo Lite - Lobby");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(AppColorFont.BACKGROUND_MEDIUM);

        characterBoxes = new ArrayList<>();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Numero giocatori
        JPanel numPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numPanel.setBackground(AppColorFont.BACKGROUND_MEDIUM);
        JLabel numLabel = new JLabel("Select Players:");
        numLabel.setFont(AppColorFont.FONT_LABEL);
        numLabel.setForeground(AppColorFont.TEXT_PRIMARY);
        numPlayersBox = new JComboBox<>(new Integer[]{3, 4, 5, 6});
        numPlayersBox.setBackground(AppColorFont.DROPDOWN_BACKGROUND);
        numPlayersBox.setForeground(AppColorFont.DROPDOWN_FOREGROUND);
        numPlayersBox.setFont(AppColorFont.FONT_DROPDOWN);
        numPanel.add(numLabel);
        numPanel.add(numPlayersBox);
        gbc.gridy = 1;
        add(numPanel, gbc);

        // Pannello giocatori
        playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setBackground(AppColorFont.BACKGROUND_MEDIUM);
        gbc.gridy = 2;
        add(playersPanel, gbc);

        // Bottone START PLAY
        final JButton StartButton = new JButton("START PLAY");
        StartButton.setFont(AppColorFont.FONT_BUTTON);
        StartButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        StartButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        StartButton.setPreferredSize(new Dimension(300, 60));
        StartButton.setFocusPainted(false);
        StartButton.setBorderPainted(false);
        StartButton.addActionListener(e -> controller.onPlayClicked(this));
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(StartButton, gbc);

        // Aggiorna righe quando cambia il numero
        numPlayersBox.addActionListener(e -> updatePlayersPanel());

        // Inizializza con 3 giocatori
        updatePlayersPanel();

        setVisible(true);
    }

    /*
     * Updates the players panel based on the selected number of players.
     */
    private void updatePlayersPanel() {
        playersPanel.removeAll();
        characterBoxes.clear();

        int num = (int) numPlayersBox.getSelectedItem();

        for (int i = 0; i < num; i++) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setBackground(AppColorFont.BACKGROUND_DARK);
            row.setBorder(BorderFactory.createLineBorder(AppColorFont.BORDER, 1));

            JLabel playerLabel = new JLabel("Player " + (i + 1));
            playerLabel.setFont(AppColorFont.FONT_BODY);
            playerLabel.setForeground(AppColorFont.TEXT_PRIMARY);
            playerLabel.setPreferredSize(new Dimension(70, 20));

            JComboBox<String> characterBox = new JComboBox<>(CHARACTERS);
            characterBox.setBackground(AppColorFont.DROPDOWN_BACKGROUND);
            characterBox.setForeground(AppColorFont.DROPDOWN_FOREGROUND);
            characterBox.setFont(AppColorFont.FONT_DROPDOWN);

            row.add(playerLabel);
            row.add(characterBox);

            characterBoxes.add(characterBox);
            playersPanel.add(row);
        }

        playersPanel.revalidate();
        playersPanel.repaint();
    }

    /* Returns the selected number of players. */
    public int getNumPlayers() {
        return (int) numPlayersBox.getSelectedItem();
    }

    /* Returns the selected character name for a given player index. */
    public String getSelectedCharacter(int index) {
        return (String) characterBoxes.get(index).getSelectedItem();
    }

    /* Returns the number of players dropdown so the controller can attach a listener. */
    public JComboBox<Integer> getNumPlayersBox() {
        return numPlayersBox;
    }
}