package it.unibo.CluedoLite.model.GameSetUp;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.creationCards.Card;
import it.unibo.CluedoLite.model.Player.impl.Player;

/**
 * This class is responsible for distributing the cards to the players at the beginning of the game.
 */

public class CardDistribution {
    List<Card> hand = new ArrayList<>();
    
    public CardDistribution(Deck deck, List<Player> players) {
        int numCards = deck.getCards().size();

        int cardIndex = 0;
        while( cardIndex < numCards) { //distribute the cards in a round-robin fashion until all cards have been distributed
            for (Player player : players) {
                if (cardIndex < numCards) {
                    player.addCard(deck.getCards().get(cardIndex)); //add the current card to the player's hand
                    cardIndex++;
                }
            }
        }
    }
}
