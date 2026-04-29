package it.unibo.CluedoLite.controller.bottonflowcontroller.impl;

import javax.swing.JOptionPane;

import it.unibo.CluedoLite.controller.bottonflowcontroller.api.GameFlowController;
import it.unibo.CluedoLite.model.gameflow.api.Game;
import it.unibo.CluedoLite.view.bottonflowview.GameFlowView;
import it.unibo.CluedoLite.view.menuview.LobbyView;
import it.unibo.CluedoLite.view.menuview.StartView;

public class GameFlowControllerImpl implements GameFlowController{

    private final GameFlowView view;
    private final Game game;

    public GameFlowControllerImpl(final GameFlowView view, final Game game) {
        this.view = view;
        this.game = game;
        addListeners();
    }

    public void addListeners() {
        view.getResetButton().addActionListener(e -> onResetClicked());
        view.getQuitButton().addActionListener(e -> onQuitClicked());
    }

    public void onResetClicked() {
        final int confirm = JOptionPane.showConfirmDialog(
            view,
            "Are you sure you want to restart?",
            "Reset",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            game.resetGame();
            new LobbyView();
        }
    }

    public void onQuitClicked() {
        final int confirm = JOptionPane.showConfirmDialog(
            view,
            "Are you sure you want to quit to the main menu?",
            "Quit",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            game.quitToMenu();
            new StartView();
        }
    }
}
