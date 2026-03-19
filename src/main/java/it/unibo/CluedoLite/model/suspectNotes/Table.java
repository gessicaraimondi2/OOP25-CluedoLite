package it.unibo.CluedoLite.model.suspectNotes;

import java.util.ArrayList;
import java.util.List;
import it.unibo.CluedoLite.model.creationCards.*;
import it.unibo.CluedoLite.model.GameSetUp.*;

/*
 * Represents the suspect notes table, grouping all cards into Boxes
 * based on their type (characters, weapons, rooms).
 */

public class Table {
    public static Deck deck = new Deck();
    private final List<Box> rooms = new ArrayList<>();
    private final List<Box> characters = new ArrayList<>();
    private final List<Box> weapons = new ArrayList<>();

    // Builds the suspect notes table by creating a Box for each card and grouping them by type
    public Table(List<Card> hand){
        for(Card name : deck.getCards()){      
            Box box = new Box(name);   
            searchType(name).add(box); // determines the card type and adds the Box to the correct list         
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
}


