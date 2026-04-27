package it.unibo.CluedoLite.view.endgameview;

import javax.swing.*;
import java.awt.*;
import it.unibo.CluedoLite.view.AppColorFont;

/**
 * Swing view displayed when the player loses the game.
 * Shows a large "HAI PERSO" title in black on a dark-red background,
 * with a message below it.
 * The window closes automatically after {@value AUTO_CLOSE_MS} milliseconds.
 */
public class DefeatView extends JFrame {

    /** Total width of the window. */
    private static final int WINDOW_WIDTH = 700;

    /** Total height of the window. */
    private static final int WINDOW_HEIGHT = 400;

    /**
     * Creates and displays the defeat window.
     */
    public DefeatView() {
        setTitle("Sconfitta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        // Outer panel centres content both vertically and horizontally
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));

        // Inner vertical panel stacks the two text labels
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        innerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Main "HAI PERSO" title in black
        JLabel titleLabel = new JLabel("HAI PERSO");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(AppColorFont.FONT_TITLE);
        titleLabel.setFont(AppColorFont.FONT_TITLE.deriveFont(72f));
        titleLabel.setForeground(Color.BLACK);

        // Subtitle showing the player name in muted text
        JLabel subtitleLabel = new JLabel("Peccato...");
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setFont(AppColorFont.FONT_LABEL);
        subtitleLabel.setForeground(AppColorFont.TEXT_SECONDARY);
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        innerPanel.add(titleLabel);
        innerPanel.add(subtitleLabel);
        outerPanel.add(innerPanel);
        add(outerPanel);
        setVisible(true);

    }
}