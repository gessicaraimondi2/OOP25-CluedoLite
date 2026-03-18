package it.unibo.CluedoLite.model.suspectNotes;

import it.unibo.CluedoLite.model.creationCards.*;

/*
 * Class representing a single entry in the suspect notes: it stores a card and its current state
 */

public class Box{
    Card name;
    State state;        

    Box(Card name){
        this.name = name;
        this.state = State.POSSIBLE;        // default state before any card is excluded
    }

    // Marks this specific box as EXCLUDED, independently of the table or any player logic
    void excludeCard(Box box){              
        this.state = State.EXCLUDED;
    }
}