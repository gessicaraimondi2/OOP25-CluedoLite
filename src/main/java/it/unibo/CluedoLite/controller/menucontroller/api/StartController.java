package it.unibo.CluedoLite.controller.menucontroller.api;

import it.unibo.CluedoLite.view.menuview.StartView;

/*
 * Defines the contract for the StartController
 * Handles the interactions of the main menu screen
 */
public interface StartController {

    /*
     * Called when the user clicks NEW GAME
     * Transitions the game state
     * closes the main menu screen and opens the lobby screen
     */
    void onStartClicked(StartView view);
}