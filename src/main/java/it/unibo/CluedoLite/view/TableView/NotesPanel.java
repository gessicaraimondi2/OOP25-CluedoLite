package it.unibo.CluedoLite.view.tableview;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

/*
* Represents a scrollable notepad panel where the player can write personal notes.
*/






// cancellare test 
// sistemare commenti
// committare
// vedere cosa devo fare nel controller








public class NotesPanel extends JPanel {
    private JTextArea notes; 

    public NotesPanel(){
        notes = new JTextArea();

        notes.setPreferredSize(null);
        notes.setBackground(new Color(255, 255, 200));
        notes.setLineWrap(true);       // wraps text automatically when the line is full
        notes.setWrapStyleWord(true);  // wraps at word boundaries
        notes.setForeground(new Color(139, 90, 43)); 

        // Wraps the text area in a scroll pane
        JScrollPane scrollPane = new JScrollPane(notes);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(new Color(139, 90, 43)), "Notes", TitledBorder.LEFT, TitledBorder.TOP, null,  new Color(139, 90, 43)));
        scrollPane.setBackground(new Color(255, 255, 200));
        scrollPane.getViewport().setBackground(new Color(255, 255, 200));
        scrollPane.setPreferredSize(new Dimension(450, 170));
        add(scrollPane);

        notes.setText("Clicca per digitare...");
        notes.setForeground(Color.GRAY);

        // Shows or hides the placeholder text based on focus.
        notes.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (notes.getText().equals("Clicca per digitare...")) {
                    notes.setText("");
                    notes.setForeground(new Color(139, 90, 43));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (notes.getText().isEmpty()) {
                    notes.setText("Clicca per digitare...");
                    notes.setForeground(Color.GRAY);
                }
            }
        });

    }
}
