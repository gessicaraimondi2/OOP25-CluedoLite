package it.unibo.CluedoLite.controller;

import java.util.function.Consumer;
import javax.swing.JOptionPane;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.accuseAndSuspect.impl.*;
import it.unibo.CluedoLite.model.player.impl.Player;
import it.unibo.CluedoLite.view.suspicionView.SuspicionView;

/**
 * Controller for the suspicion phase of the CluedoLite game.
 * This class acts as the bridge between the VIEW ({@link SuspicionView})
 * and the MODEL ({@link SuspicionManager}), following the MVC pattern.
 *
 * Responsibilities:
 *  - stores the data needed to open the suspicion view (characters, weapons, room)
 *  - creates the {@link SuspicionView} only when the player clicks the suspicion button
 *  - attaches the confirm button listener to the view
 *  - reads the player's choices from the view and passes them to the model
 *  - delivers the resulting {@link Suspicion} to the rest of the game via a callback
 *
 * The use of a {@link Consumer} callback keeps this controller fully decoupled
 * from the rest of the game flow: it does not know who will use the suspicion,
 * it simply delivers it when confirmed.
 */
public class SuspicionController {

    // Model component responsible for creating Suspicion objects
    private SuspicionManager suspicionManager;
    // The player who is making the suspicion
    private Player player;
    // Callback invoked when the suspicion is confirmed, delivering the result to the game flow
    private Consumer<Suspicion> suspicionCallback;
    // The suspicion view, created only when openSuspicionView() is called
    private SuspicionView view;
    // Data passed to the view when it is opened
    private Card[] characters;
    private Card[] weapons;
    private Card room;

    /**
     * Constructs a {@link SuspicionController} with all the data needed for the suspicion phase.
     * The view is NOT created here: it is created lazily when {@link #openSuspicionView()} is called,
     * so that the window only appears when the player actually clicks the suspicion button.
     *
     * @param suspicionManager the model component that creates {@link Suspicion} objects
     * @param player           the player who is making the suspicion
     * @param characters       array of available character cards to display in the view
     * @param weapons          array of available weapon cards to display in the view
     * @param room             the card representing the room where the player currently is
     * @param suspicionCallback callback invoked with the created {@link Suspicion} when confirmed
     */
    public SuspicionController(
            SuspicionManager suspicionManager,
            Player player,
            Card[] characters,
            Card[] weapons,
            Card room,
            Consumer<Suspicion> suspicionCallback
    ) {
        this.suspicionManager = suspicionManager;
        this.player = player;
        this.suspicionCallback = suspicionCallback;
        this.characters = characters;
        this.weapons = weapons;
        this.room = room;
    }

    /**
     * Creates and displays the {@link SuspicionView}.
     * Called externally by the suspicion button in the game screen.
     * The view is created here (not in the constructor) so that it only appears
     * when the player explicitly requests to make a suspicion.
     */
    public void openSuspicionView() {
        // Create the view with the available data
        this.view = new SuspicionView(characters, weapons, room);
        // Attach the confirm button listener before making the view visible
        setupListeners();
        // Show the view only after listeners are attached
        view.setVisible(true);
    }

    /**
     * Attaches the action listener to the confirm button of the view.
     * Called internally after the view is created, ensuring the listener
     * is always in place before the user can interact with the view.
     */
    private void setupListeners() {
        view.getConfirmButton().addActionListener(e -> handleConfirm());
    }

    /**
     * Handles the confirmation of the suspicion.
     * This method is triggered when the player clicks the confirm button in the view.
     *
     * Flow:
     *  1. reads the selected character and weapon from the view
     *  2. passes them together with the current room to the model
     *  3. if the model returns null (player not in a room), shows an error dialog
     *  4. otherwise, delivers the {@link Suspicion} to the game via the callback
     *  5. closes the view
     */
    public void handleConfirm() {
        // Read the player's choices from the view
        Card selectedCharacter = view.getSelectedCharacter();
        Card selectedWeapon = view.getSelectedWeapon();

        // Pass the room directly from the controller: no need to retrieve it from the board,
        // since the controller already holds the current room of the player
        Suspicion suspicion = suspicionManager.makeSuspicion(player, selectedCharacter, selectedWeapon, this.room);

        // If the suspicion is null, the player is not in a room: show an error and stop
        if (suspicion == null) {
            JOptionPane.showMessageDialog(view,
                    "You cannot make a suspicion because you are not in a room.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Deliver the created Suspicion to the game flow via the callback
        suspicionCallback.accept(suspicion);

        // Close the suspicion view after confirmation
        view.dispose();
    }
}