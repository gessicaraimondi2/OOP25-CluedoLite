package it.unibo.CluedoLite.controller.menucontroller.impl;

import it.unibo.CluedoLite.controller.menucontroller.api.StartController;
import it.unibo.CluedoLite.view.menuview.LobbyView;
import it.unibo.CluedoLite.view.menuview.StartView;
/*
*  Controller that manages the start screen
 */
public class StartControllerImpl implements StartController{
    private final StartView view;

    // Creates the controller, saves the view and the model, and connects the buttons
    public StartControllerImpl(StartView view) {
        this.view = view;
        addListeners();
    }
    // Connects actions to the view buttons
    public void addListeners() {
        view.getStartButton().addActionListener(e -> onStartClicked());
    }
    // Method executed when Start is clicked
    public void onStartClicked() {
        view.dispose();
        LobbyView lobbyView = new LobbyView(); // creation the LobbyView
        new LobbyControllerImpl(lobbyView); // creation the Lobby controller
    }
}
