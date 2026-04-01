package it.unibo.CluedoLite.view.suspicionView;

import javax.swing.*;
import java.awt.*;

import it.unibo.CluedoLite.model.creationCards.impl.Card;

/**
 * This class represents the Swing VIEW for the suspicion phase of the CluedoLite game.
 *
 * Responsibilities:
 * - displays to the player:
 *      - the room they are currently in (not editable, determined by the game)
 *      - a dropdown list of selectable characters
 *      - a dropdown list of selectable weapons
 *  - exposes getter methods so the controller can read the player's choices
 *  - exposes the confirm button so the controller can attach the confirmation logic
 *
 * This class contains NO game logic: it only handles presentation and input collection.
 * It does not know what happens after the player confirms — that is the controller's responsibility.
 */
public class SuspicionView extends JFrame {

    private static final Color BG_DARK    = new Color(30, 0, 0);
    private static final Color DD_COLOR  = new Color(100, 15, 15);
    private static final Color BTN_COLOR  = new Color(90, 25, 25);
    private static final Color TEXT_WHITE = Color.WHITE;

    // JComboBox for the selection of the suspected character
    private final JComboBox<Card> characterBox;
    // JComboBox for the selection of the suspected weapon
    private final JComboBox<Card> weaponBox;
    // JTextField for displaying the current room (not editable by the player)
    private final JTextField roomField;
    // JButton for confirming the suspicion, exposed to the controller via getConfirmButton()
    private JButton confirmButton;

    /**
     * Constructs the suspicion view and initializes all its components.
     * The view receives all data ready from the controller — it does not
     * fetch or compute anything on its own.
     * 
     * @param characters array of {@link Card} objects representing the available characters
     * @param weapons    array of {@link Card} objects representing the available weapons
     * @param room       {@link Card} representing the room where the player is currently located
     */
    public SuspicionView(Card[] characters, Card[] weapons, Card room) {

        // Title of the suspicion window
        setTitle("Make Your Suspicion:");
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

        // Row 3: room display (read-only)
        JLabel roomLabel = new JLabel("The Room is:");
        roomLabel.setForeground(TEXT_WHITE);
        roomLabel.setFont(new Font("Serif", Font.BOLD, 30));
        panel.add(roomLabel);
        roomField = new JTextField(room.getName());
        roomField.setEditable(false);
        roomField.setBackground(DD_COLOR);
        roomField.setForeground(TEXT_WHITE);
        roomField.setFont(new Font("Serif", Font.BOLD, 15));
        panel.add(roomField);

        // Botton to confirm the suspicion, placed in the south region of the BorderLayout
        confirmButton = new JButton("Confirm your Suspicion");
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