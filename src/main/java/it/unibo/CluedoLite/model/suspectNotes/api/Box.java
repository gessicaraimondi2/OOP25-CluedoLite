package it.unibo.CluedoLite.model.suspectNotes.api;

import it.unibo.CluedoLite.model.creationCards.impl.Card;


public interface Box{

    /**
     * Marks this card as EXCLUDED.
     */
    void excludeCard();

     /**
     * Returns the current state of this box.
     *
     * @return the {@link State} of this box (POSSIBLE or EXCLUDED)
     */
    State getState();

    /**
     * Returns the card associated with this box.
     *
     * @return the {@link Card} of this box
     */
    Card getCard();
}