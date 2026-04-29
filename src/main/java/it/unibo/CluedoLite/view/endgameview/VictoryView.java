package it.unibo.CluedoLite.view.endgameview;

import javax.swing.*;
import java.awt.*;
import it.unibo.CluedoLite.view.AppColorFont;
import it.unibo.CluedoLite.view.bottonflowview.GameFlowView;

public class VictoryView extends JFrame {

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 400;

    private final GameFlowView gameFlowView;

    public VictoryView() {
        setTitle("Victory!");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        // Root panel: BorderLayout to place buttons at the bottom
        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        rootPanel.setBorder(BorderFactory.createLineBorder(AppColorFont.ACCENT_SECONDARY, 6));

        // Outer panel centres content both vertically and horizontally
        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(AppColorFont.BACKGROUND_DARK);

        // Inner vertical panel stacks the two text labels
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(AppColorFont.BACKGROUND_DARK);
        innerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel titleLabel = new JLabel("WINNER :)");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(AppColorFont.FONT_TITLE.deriveFont(72f));
        titleLabel.setForeground(AppColorFont.ACCENT_SECONDARY);

        JLabel subtitleLabel = new JLabel("Congratulations!");
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setFont(AppColorFont.FONT_LABEL);
        subtitleLabel.setForeground(AppColorFont.TEXT_PRIMARY);
        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        innerPanel.add(titleLabel);
        innerPanel.add(subtitleLabel);
        outerPanel.add(innerPanel);

        // Buttons panel at the bottom
        gameFlowView = new GameFlowView();

        rootPanel.add(outerPanel, BorderLayout.CENTER);
        rootPanel.add(gameFlowView, BorderLayout.SOUTH);

        add(rootPanel);
        setVisible(true);
    }

    public GameFlowView getGameFlowView() {
        return gameFlowView;
    }
}