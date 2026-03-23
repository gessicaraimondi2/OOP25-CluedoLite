package it.unibo.CluedoLite.model.suspectNotes;

import it.unibo.CluedoLite.model.creationCards.impl.Card;

/*
 * Class representing a single entry in the suspect notes: it stores a card and its current state
 */

public class Box{
    private Card name;
    private State state;        

    public Box(Card name){
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