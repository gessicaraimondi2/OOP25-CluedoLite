/*package it.unibo.samplejavafx;

import javax.swing.JFrame;
import javax.swing.JPanel;
import it.unibo.CluedoLite.model.gameflow.impl.GameImpl;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.controller.buttonflowcontroller.impl.ResetButtonControllerImpl;
import it.unibo.CluedoLite.controller.buttonflowcontroller.impl.QuitButtonControllerImpl;
import it.unibo.CluedoLite.view.buttonflowview.ResetButtonView;
import it.unibo.CluedoLite.view.buttonflowview.QuitButtonView;

public class ButtonTest {

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

        System.out.println("INITIAL STATE ");
        System.out.println("Game state: " + game.getState());
        printPlayers(game);

        // controller con stampe per RESET
        final ResetButtonControllerImpl resetController = new ResetButtonControllerImpl(game) {
            @Override
            public void onResetClicked() {
                System.out.println("BEFORE RESET");
                printPlayers(game);
                super.onResetClicked();
                System.out.println("AFTER RESET");
                System.out.println("Game state: " + game.getState());
                printPlayers(game);
            }
        };

        // controller con stampe per QUIT
        final QuitButtonControllerImpl quitController = new QuitButtonControllerImpl(game) {
            @Override
            public void onQuitClicked() {
                System.out.println("BEFORE QUIT");
                printPlayers(game);
                super.onQuitClicked();
                System.out.println("AFTER QUIT");
                System.out.println("Game state: " + game.getState());
                System.out.println("Players: " + game.getPlayers());
                System.out.println("Available characters: " + game.getAvailableCharacters().size());
            }
        };

        // frame temporaneo con entrambi i bottoni
        final JFrame frame = new JFrame("Test Buttons");
        final JPanel panel = new JPanel();
        panel.add(new ResetButtonView(resetController));
        panel.add(new QuitButtonView(quitController));
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // metodo di supporto per stampare i giocatori
    private static void printPlayers(final Game game) {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i) != null) {
                System.out.println("Player " + (i + 1)
                    + " → " + game.getPlayers().get(i).getName()
                    + " - character: " + game.getPlayers().get(i).getCharacter().getName());
            }
        }
    }
}*/