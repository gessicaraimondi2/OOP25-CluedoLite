package it.unibo.CluedoLite.view.endgameview;

import javax.swing.*;
import java.awt.*;
import it.unibo.CluedoLite.view.AppColorFont;

/**
 * Swing view displayed when the player wins the game.
 * Shows a large "HAI VINTO" title in gold on a dark-red background,
 * with a congratulatory message below it.
 * The window closes automatically after {@value AUTO_CLOSE_MS} milliseconds.
 */
public class VictoryView extends JFrame {

    /** Total width of the window. */
    private static final int WINDOW_WIDTH = 700;

    /** Total height of the window. */
    private static final int WINDOW_HEIGHT = 400;

    /**
     * Creates and displays the victory window.
    */  
    public VictoryView() {
        setTitle("Vittoria!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        // Outer panel centres content both vertically and horizontally
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        outerPanel.setBorder(BorderFactory.createLineBorder(AppColorFont.ACCENT_SECONDARY, 6));

        // Inner vertical panel stacks the two text labels
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        innerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Main "HAI VINTO" title in gold
        JLabel titleLabel = new JLabel("HAI VINTO");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(AppColorFont.FONT_TITLE);
        titleLabel.setFont(AppColorFont.FONT_TITLE.deriveFont(72f));
        titleLabel.setForeground(AppColorFont.ACCENT_SECONDARY);

        // Subtitle showing the player name in light text
        JLabel subtitleLabel = new JLabel("Complimenti!");
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setFont(AppColorFont.FONT_LABEL);
        subtitleLabel.setForeground(AppColorFont.TEXT_PRIMARY);
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        innerPanel.add(titleLabel);
        innerPanel.add(subtitleLabel);
        outerPanel.add(innerPanel);
        add(outerPanel);
        setVisible(true);

    }
}