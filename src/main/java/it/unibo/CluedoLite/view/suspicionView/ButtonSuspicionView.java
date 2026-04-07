package it.unibo.CluedoLite.view.suspicionview;

import javax.swing.*;

import it.unibo.CluedoLite.controller.accuseandsuspectcontroller.impl.SuspicionController;

/**
 * This class represents the button that triggers the suspicion phase in the game screen.
 * It belongs to the VIEW layer of the MVC pattern.
 *
 * Responsibilities:
 *  - displays a button always visible on the game screen
 *  - when clicked, delegates to the {@link SuspicionController} to open the suspicion view
 *
 * This class has no game logic: it only knows the controller and calls
 * {@link SuspicionController#openSuspicionView()} when the button is pressed.
 * It does not know anything about the model, the cards, or the suspicion result.
 */
public class ButtonSuspicionView extends JPanel {

    // The button that the player clicks to start the suspicion phase
    private final JButton suspicionButton;

    /**
     * Constructs the panel containing the suspicion button.
     * The button is immediately added to the panel and ready to be placed
     * in the main game screen.
     *
     * @param controller the {@link SuspicionController} that handles the suspicion phase.
     *                   When the button is clicked, {@link SuspicionController#openSuspicionView()}
     *                   is called to create and display the suspicion window.
     */
    public ButtonSuspicionView(SuspicionController controller) {

        // Create the suspicion button with a descriptive label
        suspicionButton = new JButton("Make a Suspicion");

        // When clicked, delegate entirely to the controller:
        // the view does not handle any logic, it only triggers the controller
        suspicionButton.addActionListener(e -> controller.openSuspicionView());

        // Add the button to this panel so it can be embedded in the game screen
        add(suspicionButton);
    }
}