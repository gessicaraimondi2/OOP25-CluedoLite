package it.unibo.CluedoLite.view.TableView;

import javax.swing.*;

import it.unibo.CluedoLite.model.suspectNotes.api.State;

import java.awt.*;

/*
 * Custom JPanel representing a single card in the suspect notes table.
 * Its appearance changes based on the card state.
 */

public class CardPanel extends JPanel {
    private String name;
    private State state;

    // The constructor creates a card panel with the given name and state and a preferred size.
    public CardPanel(String name, State state){
        this.name = name;
        this.state = state;
        setPreferredSize(new Dimension(80, 130));
    }

    // Draws the card appearance based on its state: normal if POSSIBLE, 
    // darkened with a red X if EXCLUDED.
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(state==State.EXCLUDED){
            g.setColor(Color.gray);
        } else g.setColor(Color.lightGray);             
        g.fillRect(0, 0, getWidth(), getHeight());

        if(state == State.EXCLUDED){            
            g.setColor(Color.RED);
            g.drawLine(0, 0, getWidth(), getHeight());
            g.drawLine(getWidth(), 0, 0, getHeight());
            g.drawRect(0, 0, getWidth()-1, getHeight()-1);
            writeCardName(name, g, Color.WHITE);
        } else writeCardName(name, g, Color.BLACK);
    } 
    
    // Draws the card name on the panel
    private void writeCardName(String name, Graphics g, Color color){
        g.setColor(color);
        String[] words = name.split(" ");   // splits the name into multiple lines 
            int y = 20;                           // if it contains spaces.
            for(String word : words){
                g.drawString(word, 10, y);
                y += 15;
            }
    }
}
