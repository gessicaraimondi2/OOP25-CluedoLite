package it.unibo.CluedoLite.controller.buttonflowcontroller.impl;

import java.util.function.Supplier;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import it.unibo.CluedoLite.controller.buttonflowcontroller.api.QuitButtonController;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.view.menuview.StartView;
import it.unibo.CluedoLite.controller.menucontroller.impl.StartControllerImpl;

/**
 * Controller for the QUIT button.
 * Returns to the main menu and closes the game window.
 */
public class QuitButtonControllerImpl implements QuitButtonController {

    private final Game game;
    private final Supplier<JFrame> frameSupplier;

    /**
     * Creates the controller with the game model and the game window reference.
     */
    public QuitButtonControllerImpl(final Game game, final Supplier<JFrame> frameSupplier) {
        this.game = game;
        this.frameSupplier = frameSupplier;
    }

    /**
     * Called when the user clicks QUIT.
     */
    @Override
    public void onQuitClicked() {
        final JFrame currentFrame = frameSupplier.get();
        final int confirm = JOptionPane.showConfirmDialog(
            currentFrame,
            "Are you sure you want to quit to the main menu?",
            "Quit",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            game.quitToMenu();
            new StartView(new StartControllerImpl());
            currentFrame.dispose();
        }
    }
}