/* package it.unibo.samplejavafx;

import javax.swing.SwingUtilities;
import it.unibo.CluedoLite.model.gameflow.impl.GameImpl;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.controller.menucontroller.impl.StartControllerImpl;
import it.unibo.CluedoLite.controller.menucontroller.impl.LobbyControllerImpl;
import it.unibo.CluedoLite.view.menuview.StartView;
import it.unibo.CluedoLite.view.menuview.LobbyView;

public class MenuViewTest {

    public static void main(String[] args) {

        // Test 1: StartView
        System.out.println("Test 1: StartView");
        SwingUtilities.invokeLater(() -> {
            final Game game = new GameImpl(3);
            final StartControllerImpl startController = new StartControllerImpl(game);
            new StartView(startController);
        });

        // Test 2: LobbyView
        System.out.println("Test 2: LobbyView");
        SwingUtilities.invokeLater(() -> {
            final LobbyControllerImpl lobbyController = new LobbyControllerImpl();
            new LobbyView(lobbyController);
        });
    }
} */