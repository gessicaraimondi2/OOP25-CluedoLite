package it.unibo.CluedoLite.view.gamebutton;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import it.unibo.CluedoLite.view.AppColorFont;
import it.unibo.CluedoLite.view.buttonflowview.QuitButtonView;
import it.unibo.CluedoLite.view.buttonflowview.ResetButtonView;
import it.unibo.CluedoLite.controller.buttonflowcontroller.impl.ResetButtonControllerImpl;
import it.unibo.CluedoLite.controller.buttonflowcontroller.impl.QuitButtonControllerImpl;
import it.unibo.CluedoLite.model.gameflow.api.Game;

/**
 * Panel containing the RESET and QUIT buttons
 * The panel is vertical and the buttons are at the bottom
 */
public class ButtonGamePanel extends JPanel {

    /**
     * Creates the panel with RESET and QUIT buttons at the bottom
     * @param game the game model
     */
    public ButtonGamePanel(final Game game) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int panelWidth = screen.width / 4;
        final int panelHeight = screen.height;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(AppColorFont.BACKGROUND_MEDIUM);

        // spazio flessibile in cima che spinge i bottoni in basso
        add(Box.createVerticalGlue());

        // bottoni in basso
        final JPanel buttonsRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsRow.setBackground(AppColorFont.BACKGROUND_MEDIUM);
        final ResetButtonView resetButton = new ResetButtonView(new ResetButtonControllerImpl(game));
        final QuitButtonView quitButton = new QuitButtonView(new QuitButtonControllerImpl(game));

        
        add(resetButton);
        add(Box.createVerticalStrut(10)); // spazio tra i due bottoni
        add(quitButton);
    }
}