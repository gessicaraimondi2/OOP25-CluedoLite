package it.unibo.CluedoLite.model.GameSetUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.CluedoLite.model.creationCards.Rooms;
import it.unibo.CluedoLite.model.creationCards.Weapons;
import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Card;

/*
* Class SecretSolution represents the secret solution of the Cluedo game, 
* which consists of one character card, one weapon card, and one room card.
 */

public class SecretSolution {
    private final List<Card> solution = new ArrayList<>(); //create the solution as an ArrayList of Card objects
    private Characters secretCharacters;
    private Weapons secretWeapons;
    private Rooms secretRooms;
    
    public SecretSolution(Deck deck) {
        Collections.shuffle(deck.getCards()); //shuffle the deck to randomize the order of the cards
        generateSecretSolution(deck); //generate the secret solution using the provided deck of cards
    }

    private void generateSecretSolution(Deck deck){
        secretCharacters = null; //initialize the secret solution variables to null so they can be assigned a card from the deck
        secretWeapons = null;
        secretRooms = null;
        List<Card> cards = deck.getCards(); //get the deck of cards from the Deck object

        for (Card card : cards) { //iterate through the deck of cards and randomly select one card from each type to be the secret solution, and add them to the solution list
            if (card instanceof Characters && secretCharacters == null) { //check if the card is a character card and if the secret character has not been selected yet
                secretCharacters = (Characters) card; //cast the card to a Characters object and assign it to the secret character variable
                solution.add(secretCharacters); //add the secret character to the solution list
            } else if (card instanceof Weapons && secretWeapons == null) {
                secretWeapons = (Weapons) card;
                solution.add(secretWeapons);
            } else if (card instanceof Rooms && secretRooms == null) {
                secretRooms = (Rooms) card;
                solution.add(secretRooms);
            }
        }
        cards.remove(secretCharacters); //remove the secret solution cards from the deck so they cannot be drawn by the players
        cards.remove(secretWeapons);
        cards.remove(secretRooms);
    }

    public List<Card> getSolution() {
        return solution; //return the secret solution as a list of Card objects
    }
}

