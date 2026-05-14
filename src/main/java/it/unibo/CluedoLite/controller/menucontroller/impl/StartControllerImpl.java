package it.unibo.CluedoLite.controller.menucontroller.impl;

import it.unibo.CluedoLite.controller.menucontroller.api.StartController;
import it.unibo.CluedoLite.view.menuview.LobbyView;
import it.unibo.CluedoLite.view.menuview.StartView;

/*
*  Controller that manages the start screen
 */
public class StartControllerImpl implements StartController{

    public StartControllerImpl() {
        
    }

    // Method executed when Start is clicked
   @Override
    public void onStartClicked(StartView view) {
        view.dispose();  
        final LobbyControllerImpl lobbyController = new LobbyControllerImpl();
        new LobbyView(lobbyController);      
    }
}
