package it.unibo.CluedoLite.model.suspectNotes;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.creationCards.impl.Characters;
import it.unibo.CluedoLite.model.creationCards.impl.Weapons;
import it.unibo.CluedoLite.model.gameSetUp.impl.Deck;

/*
 * Represents the suspect notes table, grouping all cards into Boxes
 * based on their type (characters, weapons, rooms).
 */

public class Table {
    private final List<Box> rooms = new ArrayList<>();
    private final List<Box> characters = new ArrayList<>();
    private final List<Box> weapons = new ArrayList<>();

    // Builds the suspect notes table by creating a Box for each card and grouping them by type
    public Table(List<Card> hand){
        for (Card name : Deck.getAllCards()) {      
            Box box = new Box(name);   
            searchType(name).add(box);
        }
        initializeTable(hand);
    }

    // Updates the table based on the player's hand
    public void initializeTable(List<Card> hand){   
        for(Card name : hand){           
            searchType(name).stream()
            .filter(box -> box.getCard().equals(name))
            .forEach(Box::excludeCard);
        }
    }

    // Returns the list corresponding to the card's type (characters, weapons, or rooms).
    public List<Box> searchType(Card name){
        if(name instanceof Characters){
            return characters;
        }else if(name instanceof Weapons){
            return weapons;
        }else{
            return rooms;
        }
    }

    // Checks whether the given card is already marked as EXCLUDED in the table.
    // Returns true if the card is already present with state EXCLUDED.
    public boolean alreadyExcluded(Card name){
        return searchType(name).stream()
                        .filter(box -> box.getCard().equals(name))
                        .anyMatch(box -> box.getState().equals(State.EXCLUDED));
    }
    
    // Excludes the box corresponding to the given card in the table
    public void updateTable(Card name){
        searchType(name).stream()
        .filter(box -> box.getCard().equals(name))
        .forEach(box -> box.excludeCard());
    }
}