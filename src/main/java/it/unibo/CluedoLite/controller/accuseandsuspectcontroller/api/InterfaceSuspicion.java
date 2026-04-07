package it.unibo.CluedoLite.controller.accuseandsuspectcontroller.api;

public class InterfaceSuspicion {
    /**
     * Opens the suspicion view and prepares the UI for user interaction.
     */
    void openSuspicionView();

    /**
     * Handles the confirmation logic when the user submits a suspicion.
     * Reads selections, delegates to the model, and triggers the callback.
     */
    void handleConfirm()
}
