package it.unibo.CluedoLite.model.suspectNotes.impl;

import it.unibo.CluedoLite.model.creationCards.impl.*;
import it.unibo.CluedoLite.model.suspectNotes.api.*;

/*
 * Class representing a single entry in the suspect notes: it stores a card and its current state
 */

public class BoxImpl implements Box{
    private Card name;
    private State state;        

    public BoxImpl(Card name){
        this.name = name;
        this.state = State.POSSIBLE;  // default state before any card is excluded
    }

    // Marks this specific box as EXCLUDED, independently of the table or any player logic
    public void excludeCard(){              
        this.state = State.EXCLUDED;
    }

   public State getState(){
        return this.state;
    }

    public Card getCard(){
        return name;
    }
}
