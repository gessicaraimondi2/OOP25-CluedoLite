package it.unibo.CluedoLite.view.menuview;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LobbyView extends JFrame {

    private JComboBox<Integer> numPlayersBox; // menu for the number of player
    private JPanel playersPanel;
    private JButton StartButton;
    private List<JComboBox<String>> characterBoxes; //list of player 

    private static final String[] CHARACTERS = {
        "Miss Scarlet",
        "Colonel Mustard",
        "Mrs. White",
        "Mr. Green",
        "Mrs. Peacock",
        "Professor Plum"
    };

    public LobbyView() {
        setTitle("Cluedo Lite - Lobby");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(160, 28, 28));

        characterBoxes = new ArrayList<>();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Numero giocatori
        JPanel numPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numPanel.setBackground(new Color(251, 234, 240));
        JLabel numLabel = new JLabel("Select Players:");
        numLabel.setFont(new Font("Serif", Font.BOLD, 35));
        numLabel.setForeground(new Color(120,0,0));
        numPlayersBox = new JComboBox<>(new Integer[]{3, 4, 5, 6});
        numPlayersBox.setBackground(Color.WHITE);
        numPlayersBox.setForeground(Color.BLACK);
        numPanel.add(numLabel);
        numPanel.add(numPlayersBox);
        gbc.gridy = 1;
        add(numPanel, gbc);

        // Pannello giocatori
        playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setBackground(new Color(168, 28, 28));
        gbc.gridy = 2;
        add(playersPanel, gbc);

        // Bottone AVVIA
        StartButton = new JButton("START PLAY");
        StartButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        StartButton.setBackground(new Color(100 ,10 ,10));
        StartButton.setForeground(Color.WHITE);
        StartButton.setPreferredSize(new Dimension(200, 45));
        StartButton.setFocusPainted(false);
        StartButton.setBorderPainted(false);
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
            row.setBackground(Color.WHITE);
            row.setBorder(BorderFactory.createLineBorder(new Color(244, 192, 209), 1));

            JLabel playerLabel = new JLabel("Player " + (i + 1));
            playerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
            playerLabel.setForeground(new Color(120,0,0));
            playerLabel.setPreferredSize(new Dimension(70, 20));

            JComboBox<String> characterBox = new JComboBox<>(CHARACTERS);
            characterBox.setBackground(new Color(251, 234, 240));
            characterBox.setForeground(new Color(114, 36, 62));
            characterBox.setFont(new Font("SansSerif", Font.PLAIN, 15));

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

    /* Returns the Start button so the controller can attach a listener. */
    public JButton getStartButton() {
        return StartButton;
    }

    /* Returns the number of players dropdown so the controller can attach a listener. */
    public JComboBox<Integer> getNumPlayersBox() {
        return numPlayersBox;
    }
}