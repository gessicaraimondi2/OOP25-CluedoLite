package it.unibo.CluedoLite.controller.menucontroller.api;

/*
 * Defines the contract for the LobbyController
 * Manages the interactions of the lobby screen
 * and handles the character assignment before the game starts
 */
public interface LobbyController {

    /**
     * Attaches listeners to the buttons in the view
     * Must be called once when the controller is created
     */
    void addListeners();

    /**
     * Called when the user clicks PLAY
     * Checks for duplicate characters, assigns them to players
     * and starts the game
     */
    void onPlayClicked();

}
