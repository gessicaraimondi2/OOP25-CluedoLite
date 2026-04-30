package it.unibo.CluedoLite.view.buttonflowview;

import javax.swing.JButton;
import it.unibo.CluedoLite.view.AppColorFont;
import it.unibo.CluedoLite.controller.buttonflowcontroller.api.QuitButtonController;

/**
 * Button that quits the game and returns to the main menu
 */
public class QuitButtonView extends JButton {

    /**
     * Creates the QUIT button
     * @param controller the controller that handles the quit action
     */
    public QuitButtonView(final QuitButtonController controller) {
        setText("QUIT");
        setFont(AppColorFont.FONT_BUTTON);
        setBackground(AppColorFont.BUTTON_BACKGROUND);
        setForeground(AppColorFont.BUTTON_FOREGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        addActionListener(e -> controller.onQuitClicked());
    }
}