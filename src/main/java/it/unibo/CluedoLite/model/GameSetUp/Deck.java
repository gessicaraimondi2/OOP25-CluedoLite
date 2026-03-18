package it.unibo.CluedoLite.model.GameSetUp;

import java.util.List;
import java.util.ArrayList;

import it.unibo.CluedoLite.model.creationCards.Card;
import it.unibo.CluedoLite.model.creationCards.Rooms;
import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;

/*
* Class Deck represents the deck of cards used in the Cluedo game. 
* It initializes the deck with all the character, weapon, and room cards, shuffles them, 
* and provides a method to retrieve the list of cards in the deck. 
* The Deck class is used to generate the secret solution and to deal cards to players during the game.
 */


public class Deck {
    private final List<Card> cards = new ArrayList<>(); //create the deck of cards as an ArrayList of Card objects
    private final List<Card> OriginalCards = new ArrayList<>(); //create a copy of the original deck of cards

    public Deck(){
        InitializeCards();
        OriginalCards.addAll(cards); //add all the cards from the initialized deck to the OriginalCards list to keep a copy of the original deck
    }

    public void InitializeCards() { //initialize the deck with all the cards for all the types
        cards.add(new Characters("Miss Scarlett"));
        cards.add(new Characters("Colonel Mustard"));
        cards.add(new Characters("Mrs. White"));
        cards.add(new Characters("Mr. Green"));
        cards.add(new Characters("Mrs. Peacock"));
        cards.add(new Characters("Professor Plum"));

        cards.add(new Weapons("Candlestick"));
        cards.add(new Weapons("Dagger"));
        cards.add(new Weapons("Lead Pipe"));
        cards.add(new Weapons("Revolver"));
        cards.add(new Weapons("Rope"));
        cards.add(new Weapons("Wrench"));

        cards.add(new Rooms("Kitchen"));
        cards.add(new Rooms("Ballroom"));
        cards.add(new Rooms("Conservatory"));
        cards.add(new Rooms("Dining Room"));
        cards.add(new Rooms("Billiard Room"));
        cards.add(new Rooms("Library"));
        cards.add(new Rooms("Lounge"));
        cards.add(new Rooms("Hall"));
        cards.add(new Rooms("Study"));
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getOriginalCards() {
        return OriginalCards;
    }
}

