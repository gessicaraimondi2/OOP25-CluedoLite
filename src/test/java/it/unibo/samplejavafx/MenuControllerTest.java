/*package it.unibo.samplejavafx;

import it.unibo.CluedoLite.model.gameflow.impl.GameImpl;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.model.player.impl.CreationCharacterImpl;
import it.unibo.CluedoLite.controller.menucontroller.impl.LobbyControllerImpl;
import it.unibo.CluedoLite.view.menuview.LobbyView;

public class MenuControllerTest {

    public static void main(final String[] args) {

        // create controller first
        final LobbyControllerImpl lobbyController = new LobbyControllerImpl() {
            @Override
            public void onPlayClicked(final LobbyView view) {
                final int numPlayers = view.getNumPlayers();
                final Game testGame = new GameImpl(numPlayers);
                testGame.enterLobby();

                // check if two player have the same character
                for (int i = 0; i < numPlayers; i++) {
                    for (int j = i + 1; j < numPlayers; j++) {
                        if (view.getSelectedCharacter(i).equals(view.getSelectedCharacter(j))) {
                            System.out.println("ERROR: Player " + (i + 1) + " and Player " + (j + 1) + " have the same character!");
                            return;
                        }
                    }
                }

                // test number of player
                System.out.println("Number of players selected: " + numPlayers);
                System.out.println("Expected: between 3 and 6 → " + (numPlayers >= 3 && numPlayers <= 6 ? "OK" : "ERROR"));

                // assign e print
                for (int i = 0; i < numPlayers; i++) {
                    final String selectedName = view.getSelectedCharacter(i);
                    final CreationCharacterImpl character = testGame.getAvailableCharacters().stream()
                            .filter(c -> c.getName().equals(selectedName))
                            .findFirst()
                            .get();
                    testGame.setPlayer(i, new PlayerImpl("Player " + (i + 1)));
                    testGame.assignCharacterToPlayer(i, character);
                }

                testGame.startGame();

                // risult 
                System.out.println("Game started! Players:");
                for (int i = 0; i < numPlayers; i++) {
                    System.out.println("Player " + (i + 1)
                        + " → " + testGame.getPlayers().get(i).getCharacter().getName()
                        + " [" + testGame.getPlayers().get(i).getCharacter().getColor() + "]");
                }
                System.out.println("Game state: " + testGame.getState());
            }
        };

        // create view with controller
        new LobbyView(lobbyController);
    }
} */