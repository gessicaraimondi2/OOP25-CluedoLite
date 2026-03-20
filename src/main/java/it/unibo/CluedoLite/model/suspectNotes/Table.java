package it.unibo.CluedoLite.model.suspectNotes;

import java.util.ArrayList;
import java.util.List;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.creationCards.impl.CardType;
import it.unibo.CluedoLite.model.GameSetUp.impl.Deck;

/*
 * Represents the suspect notes table, grouping all cards into Boxes
 * based on their type (characters, weapons, rooms).
 */
public class Table {
    private final List<Box> rooms = new ArrayList<>();
    private final List<Box> characters = new ArrayList<>();
    private final List<Box> weapons = new ArrayList<>();

    public Table(List<Card> hand){
        for (Card name : Deck.getAllCards()) {      
            Box box = new Box(name);   
            searchType(name).add(box);
        }
        initializeTable(hand);
    }

    public void initializeTable(List<Card> hand){   
        for (Card name : hand) {           
            searchType(name).stream()
                .filter(box -> box.getCard().equals(name))
                .forEach(Box::excludeCard);
        }
    }

    public List<Box> searchType(Card name){
        if (name.getType() == CardType.CHARACTER) {
            return characters;
        } else if (name.getType() == CardType.WEAPON) {
            return weapons;
        } else {
            return rooms;
        }
    }

    public boolean alreadyExcluded(Card name){
        return searchType(name).stream()
                .filter(box -> box.getCard().equals(name))
                .anyMatch(box -> box.getState().equals(State.EXCLUDED));
    }                
}

