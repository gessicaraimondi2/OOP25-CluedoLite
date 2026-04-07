package it.unibo.CluedoLite.view.accuseview;

import javax.swing.*;
import it.unibo.CluedoLite.model.creationcards.impl.Card;
import java.awt.*;

/**
 * This class represents the Swing VIEW for the accusation phase of the CluedoLite game.
 *
 * Responsibilities:
 * - displays to the player:
 *      - a dropdown list of selectable characters
 *      - a dropdown list of selectable weapons
 *      - a dropdown list of selectable rooms
 *  - exposes getter methods so the controller can read the player's choices
 *  - exposes the confirm button so the controller can attach the confirmation logic
 *
 * This class contains NO game logic: it only handles presentation and input collection.
 * It does not know what happens after the player confirms — that is the controller's responsibility.
 */
public class AccuseView extends JFrame {

    private static final Color BG_DARK    = new Color(30, 0, 0);
    private static final Color DD_COLOR  = new Color(100, 15, 15);
    private static final Color BTN_COLOR  = new Color(90, 25, 25);
    private static final Color TEXT_WHITE = Color.WHITE;

    // JComboBox for the selection of the suspected character
    private final JComboBox<Card> characterBox;
    // JComboBox for the selection of the suspected weapon
    private final JComboBox<Card> weaponBox;
    // JComboBox for the selection of the suspected room
    private final JComboBox<Card> roomBox;
    // JButton for confirming the accusation, exposed to the controller via getConfirmButton()
    private JButton confirmButton;

    /**
     * Constructs the accusation view and initializes all its components.
     * The view receives all data ready from the controller — it does not
     * fetch or compute anything on its own.
     * 
     * @param characters array of {@link Card} objects representing the available characters
     * @param weapons    array of {@link Card} objects representing the available weapons
     * @param room       {@link Card} representing the room where the player is currently located
     */
    public AccuseView(Card[] characters, Card[] weapons, Card[] room) {

        // Title of the accusation window
        setTitle("Make Your Accusation:");
        // Fixed window size: wide enough to display all components clearly
        setSize(700, 550);
        // Center the window on the screen
        setLocationRelativeTo(null);
        // Closing the window only disposes this frame, without terminating the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(BG_DARK);
        add(panel, BorderLayout.CENTER);

        // Row 1: character selection
        JLabel charLabel = new JLabel("Choose the Character:");
        charLabel.setForeground(TEXT_WHITE);
        charLabel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.add(charLabel);
        characterBox = new JComboBox<>(characters);
        characterBox.setBackground(DD_COLOR);
        characterBox.setForeground(TEXT_WHITE);
        characterBox.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(characterBox);

        // Row 2: weapon selection
        JLabel weapLabel = new JLabel("Choose the Weapon:");
        weapLabel.setForeground(TEXT_WHITE);
        weapLabel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.add(weapLabel);
        weaponBox = new JComboBox<>(weapons);
        weaponBox.setBackground(DD_COLOR);
        weaponBox.setForeground(TEXT_WHITE);
        weaponBox.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(weaponBox);

        // Row 3: room selection
        JLabel roomLabel = new JLabel("Choose the Room:");
        roomLabel.setForeground(TEXT_WHITE);
        roomLabel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.add(roomLabel);
        roomBox = new JComboBox<>(room);
        roomBox.setBackground(DD_COLOR);
        roomBox.setForeground(TEXT_WHITE);
        roomBox.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(roomBox);

        // Botton to confirm the accusation, placed in the south region of the BorderLayout
        confirmButton = new JButton("Confirm your Accusation");
        confirmButton.setBackground(BTN_COLOR);
        confirmButton.setForeground(TEXT_WHITE);
        confirmButton.setFont(new Font("Serif", Font.BOLD, 30));
        confirmButton.setPreferredSize(new Dimension(0, 80));
        JPanel south = new JPanel(new BorderLayout());
        south.setBackground(BG_DARK);
        south.setBorder(BorderFactory.createEmptyBorder(2, 10, 4, 10));
        south.add(confirmButton, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        // Prevent the player from resizing the window
        setResizable(false);
    }

    /**
     * Returns the character card currently selected by the player in the dropdown.
     * Called by the controller when the confirm button is pressed.
     *
     * @return the {@link Card} representing the suspected character
     */
    public Card getSelectedCharacter() {
        return (Card) characterBox.getSelectedItem();
    }

    /**
     * Returns the weapon card currently selected by the player in the dropdown.
     * Called by the controller when the confirm button is pressed.
     *
     * @return the {@link Card} representing the suspected weapon
     */
    public Card getSelectedWeapon() {
        return (Card) weaponBox.getSelectedItem();
    }

    /**
     * Returns the room card currently selected by the player in the dropdown.
     * Called by the controller when the confirm button is pressed.
     *
     * @return the {@link Card} representing the suspected room
     */
    public Card getSelectedRoom() {
        return (Card) roomBox.getSelectedItem();
    }   

    /**
     * Exposes the confirm button to the controller.
     * The controller uses this method to attach the action listener that handles
     * the suspicion confirmation logic. The view itself does not attach any listener
     * to this button — that is entirely the controller's responsibility.
     *
     * @return the {@link JButton} used to confirm the suspicion
     */
    public JButton getConfirmButton() {
        return confirmButton;
    }
}