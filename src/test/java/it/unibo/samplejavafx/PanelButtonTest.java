/*package it.unibo.samplejavafx;

import javax.swing.JFrame;
import it.unibo.CluedoLite.model.gameflow.impl.GameImpl;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.view.gamebutton.ButtonGamePanel;

public class PanelButtonTest {

    public static void main(final String[] args) {

        // crea una partita in corso
        final Game game = new GameImpl(3);
        game.enterLobby();
        game.setPlayer(0, new PlayerImpl("Player 1"));
        game.setPlayer(1, new PlayerImpl("Player 2"));
        game.setPlayer(2, new PlayerImpl("Player 3"));
        game.assignCharacterToPlayer(0, game.getAvailableCharacters().get(0));
        game.assignCharacterToPlayer(1, game.getAvailableCharacters().get(0));
        game.assignCharacterToPlayer(2, game.getAvailableCharacters().get(0));
        game.startGame();

        // frame temporaneo per vedere il pannello
        final JFrame frame = new JFrame("Test ButtonGamePanel");
        frame.add(new ButtonGamePanel(game));
        frame.setSize(200, 600); // stretto e lungo come sarà nel gioco
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}*/