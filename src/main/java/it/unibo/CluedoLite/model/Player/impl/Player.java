package it.unibo.CluedoLite.model.Player.impl;

import java.util.List;
import java.util.ArrayList;

import it.unibo.CluedoLite.model.creationCards.Card;
/**
 * Represents a player in the game.
 * Each player has a name and can choose exactly one character.
 * The player also has a hand of cards that they can use during the game.
 */
public class Player {
    private final String name;
    private CreationCharacter character; // chosen character
    private final List<Card> hand; // cards in the player's hand

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
    
    public void chooseCharacter(CreationCharacter character) {
        this.character = character;
    }
    /*
     * Returns the character chosen by the player.
     */
    public CreationCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    // Adds a card to the player's hand.
    public void addCard(Card card) {
        hand.add(card);
    }

    // Returns the list of cards in the player's hand.
    public List<Card> getHand() {
        return hand;
    }
}