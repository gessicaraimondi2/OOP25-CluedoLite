package it.unibo.CluedoLite.controller.accuseandsuspectcontroller.impl;

import java.util.function.Consumer;

import it.unibo.CluedoLite.model.accuseandsuspect.impl.*;
import it.unibo.CluedoLite.model.creationcards.impl.Card;
import it.unibo.CluedoLite.view.accuseview.AccuseView;
import it.unibo.CluedoLite.controller.accuseandsuspectcontroller.api.*;

public class AccusationController implements InterfaceAccusation {

    private final AccuseManager accuseManager;
    private final Consumer<Boolean> accusationResultCallback;

    private final Card[] characters;
    private final Card[] weapons;
    private final Card[] rooms;

    public AccusationController(
            AccuseManager accuseManager,
            Card[] characters,
            Card[] weapons,
            Card[] rooms,
            Consumer<Boolean> accusationResultCallback
    ) {
        this.accuseManager = accuseManager;
        this.accusationResultCallback = accusationResultCallback;
        this.characters = characters;
        this.weapons = weapons;
        this.rooms = rooms;
    }

    /**
     * Opens the accusation view. Each call creates a fresh instance of the view,
     * avoiding stale references if the window is opened more than once.
     */
    @Override
    public void openAccusationView() {
        AccuseView view = new AccuseView(characters, weapons, rooms);
        setupListeners(view);
        view.setVisible(true);
    }

    /**
     * Attaches the confirm button listener to the given view instance.
     * The view is passed explicitly so there is no shared mutable state.
     *
     * @param view the {@link AccuseView} instance to attach the listener to
     */
    private void setupListeners(AccuseView view) {
        view.getConfirmButton().addActionListener(e -> handleConfirm(view));
    }

    /**
     * Handles the confirmation of the accusation:
     * 1. Disables the confirm button immediately to prevent double-clicks.
     * 2. Reads the player's selections from the view.
     * 3. Builds a Suspicion and checks it against the secret solution.
     * 4. Passes the result to the main controller via the callback.
     * 5. Closes the accusation window.
     *
     * @param view the {@link AccuseView} instance that triggered the confirmation
     */
    private void handleConfirm(AccuseView view) {

        // Point 5: disable the button immediately to prevent double-clicks
        view.getConfirmButton().setEnabled(false);

        Card selectedCharacter = view.getSelectedCharacter();
        Card selectedWeapon    = view.getSelectedWeapon();
        Card selectedRoom      = view.getSelectedRoom();

        // Build the suspicion from the player's selections
        Suspicion suspicion = new Suspicion(selectedCharacter, selectedWeapon, selectedRoom);

        // Check the accusation against the secret solution
        boolean result = accuseManager.checkAccuse(suspicion);

        // Pass the result back to the main controller
        accusationResultCallback.accept(result);

        // Close the accusation window
        view.dispose();
    }
}