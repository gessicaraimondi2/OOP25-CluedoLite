package it.unibo.CluedoLite.view.suspicionView;

import javax.swing.*;
import java.awt.*;

import it.unibo.CluedoLite.model.creationCards.impl.Card;

/**
 * This class represents the Swing VIEW for the suspicion phase of the CluedoLite game.
 *
 * Responsibilities:
 *  - displays to the player:
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

    // JComboBox for the selection of the suspected character
    private final JComboBox<Card> characterBox;
    // JComboBox for the selection of the suspected weapon
    private final JComboBox<Card> weaponBox;
    // JTextField for displaying the current room (not editable by the player)
    private final JTextField roomField;
    // JButton for confirming the suspicion, exposed to the controller via getConfirmButton()
    private final JButton confirmButton;

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
        setSize(500, 350);
        // Center the window on the screen
        setLocationRelativeTo(null);
        // Closing the window only disposes this frame, without terminating the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main panel with a grid layout: 4 rows, 2 columns, with horizontal and vertical padding between components
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        add(panel);

        // Row 1: character selection
        panel.add(new JLabel("Choose the Character:"));
        // JComboBox populated with the full array of character cards
        characterBox = new JComboBox<>(characters);
        panel.add(characterBox);

        // Row 2: weapon selection
        panel.add(new JLabel("Choose the Weapon:"));
        // JComboBox populated with the full array of weapon cards
        weaponBox = new JComboBox<>(weapons);
        panel.add(weaponBox);

        // Row 3: room display (read-only)
        panel.add(new JLabel("The Room is:"));
        // JTextField pre-filled with the name of the room where the player currently is
        roomField = new JTextField(room.getName());
        // The room is not editable: the player cannot change it, it is determined by their position on the board
        roomField.setEditable(false);
        panel.add(roomField);

        // Row 4: empty label for spacing + confirm button
        panel.add(new JLabel());
        // The confirm button is exposed via getConfirmButton() so the controller can attach its listener
        confirmButton = new JButton("Confirm your Suspicion");
        panel.add(confirmButton);

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