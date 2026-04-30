package it.unibo.CluedoLite.view.buttonflowview;

import javax.swing.JButton;
import it.unibo.CluedoLite.view.AppColorFont;
import it.unibo.CluedoLite.controller.buttonflowcontroller.api.ResetButtonController;

/**
 * Button that resets the game with the same players
 */
public class ResetButtonView extends JButton {

    /**
     * Creates the RESET button
     * @param controller the controller that handles the reset action
     */
    public ResetButtonView(final ResetButtonController controller) {
        setText("RESET");
        setFont(AppColorFont.FONT_BUTTON);
        setBackground(AppColorFont.BUTTON_BACKGROUND);
        setForeground(AppColorFont.BUTTON_FOREGROUND);
        setFocusPainted(false);
        setBorderPainted(false);
        addActionListener(e -> controller.onResetClicked());
    }
}
