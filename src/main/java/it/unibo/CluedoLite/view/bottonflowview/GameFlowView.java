package it.unibo.CluedoLite.view.bottonflowview;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import it.unibo.CluedoLite.view.AppColorFont;

/**
 * Panel containing the RESET and QUIT buttons shown during the game
 * This panel is added to the GameView by Raimondi
 */
public class GameFlowView extends JPanel {

    // Button to reset the game back to the lobby
    private final JButton resetButton;
    // Button to quit back to the main menu
    private final JButton quitButton;

    /**
     * Creates the panel with RESET and QUIT buttons
     */
    public GameFlowView() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setBackground(AppColorFont.BACKGROUND_MEDIUM);

        // Reset button
        resetButton = new JButton("RESET");
        resetButton.setFont(AppColorFont.FONT_BUTTON);
        resetButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        resetButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        resetButton.setFocusPainted(false);
        resetButton.setBorderPainted(false);

        // Quit button
        quitButton = new JButton("QUIT");
        quitButton.setFont(AppColorFont.FONT_BUTTON);
        quitButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        quitButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        quitButton.setFocusPainted(false);
        quitButton.setBorderPainted(false);

        add(resetButton);
        add(quitButton);
    }

    /**
     * Returns the RESET button so the controller can attach a listener
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * Returns the QUIT button so the controller can attach a listener
     */
    public JButton getQuitButton() {
        return quitButton;
    }

}