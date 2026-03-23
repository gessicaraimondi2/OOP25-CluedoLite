package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.gameSetUp.impl.CardDistribution;
import it.unibo.CluedoLite.model.gameSetUp.impl.Deck;
import it.unibo.CluedoLite.model.gameSetUp.impl.SecretSolution;
import it.unibo.CluedoLite.model.player.impl.Player;

/*
 * This test class verifies the correct distribution of cards to players in the CluedoLite game.
 */
public class TestCardDistribution {

    @Test
    void testCardDistributionEvenly() {
        List<Card> cards = Deck.getAllCards(); // 21 carte
        new SecretSolution(cards); // rimuove 3 carte, ne rimangono 18

        int totalCards = cards.size();
        assertEquals(18, totalCards, "The deck should have 18 cards after removing the secret solution cards");

        List<Player> players = Arrays.asList(
            new Player("Alice"),
            new Player("Bob"),
            new Player("Charlie")
        );

        new CardDistribution(cards, players); // distribuisce le 18 carte

        if (players.size() == 3) {
            int expectedCardsPerPlayer = totalCards / 3;
            for (Player player : players) {
                assertEquals(expectedCardsPerPlayer, player.getHand().size(), "Each player should receive the correct number of cards");
            }
        } else if (players.size() == 4) {
            int count4 = 0;
            int count5 = 0;
            for (Player p : players) {
                int handSize = p.getHand().size();
                if (handSize == 4) count4++;
                else if (handSize == 5) count5++;
            }
            assertTrue(count4 == 2 && count5 == 2, "With 4 players, two should receive 4 cards and two should receive 5 cards");
        } else if (players.size() == 5) {
            int count3 = 0;
            int count4 = 0;
            for (Player p : players) {
                int handSize = p.getHand().size();
                if (handSize == 3) count3++;
                else if (handSize == 4) count4++;
            }
            assertTrue(count3 == 2 && count4 == 3, "With 5 players, two should receive 3 cards and three should receive 4 cards");
        } else if (players.size() == 6) {
            int expectedCardsPerPlayer = totalCards / 6;
            for (Player player : players) {
                assertEquals(expectedCardsPerPlayer, player.getHand().size(), "Each player should receive the correct number of cards");
            }
        }
    }
}