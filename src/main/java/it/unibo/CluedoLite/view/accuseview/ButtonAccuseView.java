package it.unibo.CluedoLite.view.accuseview;

import javax.swing.*;

import it.unibo.CluedoLite.controller.accuseandsuspectcontroller.impl.AccusationController;

/**
 * This class represents the button that triggers the accusation phase in the game screen.
 * It belongs to the VIEW layer of the MVC pattern.
 *
 * Responsibilities:
 *  - displays a button always visible on the game screen
 *  - when clicked, delegates to the {@link AccusationController} to open the accusation view
 *
 * This class has no game logic: it only knows the controller and calls
 * {@link AccusationController#openAccusationView()} when the button is pressed.
 * It does not know anything about the model, the cards, or the accusation result.
 */
public class ButtonAccuseView extends JPanel {

    // The button that the player clicks to start the accusation phase
    private final JButton accusationButton;

    /**
     * Constructs the panel containing the accusation button.
     * The button is immediately added to the panel and ready to be placed
     * in the main game screen.
     *
     * @param controller the {@link AccusationController} that handles the accusation phase.
     *                   When the button is clicked, {@link AccusationController#openAccusationView()}
     *                   is called to create and display the accusation window.
     */
    public ButtonAccuseView(AccusationController controller) {

        // Create the accusation button with a descriptive label
        accusationButton = new JButton("Make an Accusation");

        // When clicked, delegate entirely to the controller:
        // the view does not handle any logic, it only triggers the controller
        accusationButton.addActionListener(e -> controller.openAccusationView());

        // Add the button to this panel so it can be embedded in the game screen
        add(accusationButton);
    }
}
