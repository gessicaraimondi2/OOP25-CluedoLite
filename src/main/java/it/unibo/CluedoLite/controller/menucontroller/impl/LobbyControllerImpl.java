package it.unibo.CluedoLite.controller.menucontroller.impl;

import javax.swing.JOptionPane;

import it.unibo.CluedoLite.controller.menucontroller.api.LobbyController;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.model.gameflow.impl.GameImpl;
import it.unibo.CluedoLite.model.player.impl.CreationCharacterImpl;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.view.menuview.LobbyView;

/*
 * Controller for the LobbyView
 * Handles player setup and character assignment before the game starts
 */
public class LobbyControllerImpl implements LobbyController{

    // The lobby view
    private final LobbyView view;

    //Creates the controller and attaches listeners to the view
    public LobbyControllerImpl(LobbyView view) {
        this.view = view;
        addListeners();
    }

    // Conction action to the Botton
    public void addListeners() {
        view.getStartButton().addActionListener(e -> onPlayClicked());
    }

    /*
     * Called when the user click "START PLAY"
     * Creates players, assigns characters and starts the game
     */
    public void onPlayClicked() {
    int numPlayers = view.getNumPlayers();
    Game game = new GameImpl(numPlayers);

    // check if two player have the same characters
    for (int i = 0; i < numPlayers; i++) {
        for (int j = i + 1; j < numPlayers; j++) {
            if (view.getSelectedCharacter(i).equals(view.getSelectedCharacter(j))) {
                JOptionPane.showMessageDialog(view, "Two players have the same character");
                return;
            }
        }
    }

    // assign players and characters
    for (int i = 0; i < numPlayers; i++) {
        String selectedName = view.getSelectedCharacter(i);
        CreationCharacterImpl character = game.getAvailableCharacters().stream()
                .filter(c -> c.getName().equals(selectedName))
                .findFirst()
                .get();

        game.setPlayer(i, new PlayerImpl("Player " + (i + 1)));
        game.assignCharacterToPlayer(i, character);

        }
    }

    //game.GameBoard();
    
}
