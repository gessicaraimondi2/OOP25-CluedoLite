package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.GameSetUp.CardDistribution;
import it.unibo.CluedoLite.model.GameSetUp.Deck;
import it.unibo.CluedoLite.model.GameSetUp.SecretSolution;

public class TestCardDistribution {

    @Test
    void testCardDistributionEvenly() {
        Deck deck = new Deck(); // create a new deck of cards for the test
        SecretSolution secretSolution = new SecretSolution(deck); // generate the secret solution, which will remove the solution cards from the deck, leaving 18 cards to be distributed among the players

        int totalCards = deck.getCards().size(); // total number of cards in the deck
        assertEquals(18, totalCards, "The deck should have 18 cards after removing the secret solution cards");
        List<Player> players = Arrays.asList( // create a list of players for the test
            new Player("Alice"), 
            new Player("Bob"), 
            new Player("Charlie")
        );

        new CardDistribution(deck, players); // distribute the cards to the players

        if (players.size() == 3){ // if there are 3 players, each player should receive an equal number of cards
            int expectedCardsPerPlayer = totalCards / 3;
            for (Player player : players) {
            assertEquals(expectedCardsPerPlayer, player.getHand().size(), "Each player should receive the correct number of cards");
        }
        }
        else if (players.size() == 4){ // if there are 4 players, two players should receive 4 cards and two players should receive 5 cards, since 18 cards cannot be evenly distributed among 4 players
            int count4=0;
            int count5=0;
            for (Player p : players) {
                int handSize = p.getHand().size();
                if(handSize == 4){
                    count4++;
                }
                else if (handSize == 5){
                    count5++;
                }
            }
            assertTrue(count4 == 2 && count5 == 2, "With 4 players, two should receive 4 cards and two should receive 5 cards");
        }
        else if(players.size() == 5){ // if there are 5 players, two players should receive 3 cards and three players should receive 4 cards, since 18 cards cannot be evenly distributed among 5 players
            int count3=0;
            int count4=0;
            for (Player p : players) {
                int handSize = p.getHand().size();
                if(handSize == 3){
                    count3++;
                }
                else if (handSize == 4){
                    count4++;
                }
            }
            assertTrue(count3 == 2 && count4 == 3, "With 5 players, two should receive 3 cards and three should receive 4 cards");
        }
        else if(players.size() == 6){ // if there are 6 players, each player should receive an equal number of cards, since 18 cards can be evenly distributed among 6 players
            int expectedCardsPerPlayer = totalCards / 6;
            for (Player player : players) {
            assertEquals(expectedCardsPerPlayer, player.getHand().size(), "Each player should receive the correct number of cards");
        }
        }
    }
}
