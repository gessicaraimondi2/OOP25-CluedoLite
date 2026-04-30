package it.unibo.CluedoLite.controller.buttonflowcontroller.impl;

import javax.swing.JOptionPane;
import it.unibo.CluedoLite.controller.buttonflowcontroller.api.QuitButtonController;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.view.menuview.StartView;
import it.unibo.CluedoLite.controller.menucontroller.impl.StartControllerImpl;

/**
 * Controller for the QUIT button
 * Returns to the main menu
 */
public class QuitButtonControllerImpl implements QuitButtonController {

    private final Game game;

    /**
     * Creates the controller with the game model
     */
    public QuitButtonControllerImpl(final Game game) {
        this.game = game;
    }

    /**
     * Called when the user clicks QUIT
     */
    @Override
    public void onQuitClicked() {
        final int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to quit to the main menu?",
            "Quit",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            game.quitToMenu();
            final StartControllerImpl startController = new StartControllerImpl(game);
            new StartView(startController);
        }
    }
}