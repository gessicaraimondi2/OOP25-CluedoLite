package it.unibo.CluedoLite.controller.menucontroller.api;
/*
 * Defines the contract for the StartController
 * Handles the interactions of the main menu screen
 */
public interface StartController {
    
    /*
     * Attaches listeners to the buttons in the view
     * Must be called once when the controller is created
     */
    void addListeners();

    /*
     * Called when the user clicks NEW GAME
     * Transitions the game state
     * closes the main menu screen and opens the lobby screen
     */
    void onStartClicked() ;
}