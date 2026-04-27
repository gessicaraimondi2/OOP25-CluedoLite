package it.unibo.CluedoLite.controller.bottonflowcontroller.api;

/**
 * Defines the contract for the GameFlowController
 * Manages the RESET and QUIT actions during the game
 */
public interface GameFlowController {

    /**
     * Attaches listeners to the RESET and QUIT buttons in the view
     * Must be called once when the controller is created
     */
    void addListeners();

    /**
     * Called when the user clicks RESET
     * Asks for confirmation before restarting the game with the same players
     */
    void onResetClicked();

    /**
     * Called when the user clicks QUIT
     * Asks for confirmation before returning to the main menu
     */
    void onQuitClicked();
}
