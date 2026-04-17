package it.unibo.CluedoLite.view.accuseview;

import javax.swing.*;
import it.unibo.CluedoLite.view.AppColorFont;
import it.unibo.CluedoLite.controller.accuseandsuspectcontroller.impl.AccusationController;

/**
 * This class represents the button that triggers the accusation phase in the game screen.
 * It belongs to the VIEW layer of the MVC pattern.
 *
 * Responsibilities:
 *  - displays a button always visible on the game screen
 *  - when clicked, delegates to the {@link AccusationController} to open the accusation view
 *
 * This class has no game logic: it only knows the controller and calls
 * {@link AccusationController#openAccusationView()} when the button is pressed.
 * It does not know anything about the model, the cards, or the accusation result.
 */
public class ButtonAccuseView extends JPanel {

    private final JButton accusationButton;

    /**
     * Constructs the panel containing the accusation button.
     *
     * @param controller the {@link AccusationController} that handles the accusation phase.
     */
    public ButtonAccuseView(AccusationController controller) {

        setBackground(AppColorFont.PANEL_BACKGROUND);

        accusationButton = new JButton("Make an Accusation");
        accusationButton.setBackground(AppColorFont.BUTTON_BACKGROUND);
        accusationButton.setForeground(AppColorFont.BUTTON_FOREGROUND);
        accusationButton.setFont(AppColorFont.FONT_BUTTON);
        accusationButton.setFocusPainted(false);

        accusationButton.addActionListener(e -> controller.openAccusationView());

        add(accusationButton);
    }
}