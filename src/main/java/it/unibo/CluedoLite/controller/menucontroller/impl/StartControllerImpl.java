package it.unibo.CluedoLite.controller.menucontroller.impl;

import it.unibo.CluedoLite.controller.menucontroller.api.StartController;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.view.menuview.LobbyView;

/*
*  Controller that manages the start screen
 */
public class StartControllerImpl implements StartController{
    private final Game game;

    // Creates the controller, saves the view and the model, and connects the buttons
    public StartControllerImpl(final Game game) {
        this.game = game;
    }
    // Method executed when Start is clicked
    public void onStartClicked() {
        game.enterLobby();
        final LobbyControllerImpl lobbyController = new LobbyControllerImpl();
        new LobbyView(lobbyController);
    }
}
