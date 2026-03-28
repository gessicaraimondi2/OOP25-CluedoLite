package it.unibo.CluedoLite.view.TableView;

import it.unibo.CluedoLite.model.creationCards.impl.CardType;
import it.unibo.CluedoLite.model.gameSetUp.impl.Deck;
import it.unibo.CluedoLite.model.suspectNotes.Box;
import it.unibo.CluedoLite.model.suspectNotes.Table;
import java.util.List;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;

/*
 * Represents the suspect notes table, organized into three sections:
 * characters, weapons, and rooms. Each section contains a CardPanel for every card,
 * whose appearance reflects its current state.
 */

public class TablePanel extends JPanel {

    // Builds the table panel by creating three sections (characters, weapons, rooms)
    // and populating each with the corresponding cards from the table.
    public TablePanel(Table table){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel characters = createSectionPanel("Characters");
        JPanel rooms = createSectionPanel("Rooms");
        JPanel weapons = createSectionPanel("Weapons");

        add(characters);
        add(rooms);
        add(weapons);

        fillTable(table.searchType(Deck.getCardsByType(CardType.CHARACTER).get(0)), characters);
        fillTable(table.searchType(Deck.getCardsByType(CardType.WEAPON).get(0)), weapons);
        fillTable(table.searchType(Deck.getCardsByType(CardType.ROOM).get(0)), rooms);
    }

    // Creates a styled panel for a card category section.
    private JPanel createSectionPanel(String title){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(155, 131, 107));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        return panel;
    }

    // For each item in the list creates a CardPanel, fills it with information and adds it to the panel.
    private void fillTable(List<Box> list, JPanel panel){
        list.stream().forEach(c -> {
                        CardPanel card = new CardPanel(c.getCard().getName(), c.getState());
                        panel.add(card);
                      });
    }
}