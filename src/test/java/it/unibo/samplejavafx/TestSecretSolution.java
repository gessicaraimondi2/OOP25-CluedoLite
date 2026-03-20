package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.GameSetUp.impl.Deck;
import it.unibo.CluedoLite.model.GameSetUp.impl.SecretSolution;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.creationCards.impl.CardType;

public class TestSecretSolution {

    @Test
    public void testSecretSolutionGeneration() {
        List<Card> cards = Deck.getAllCards(); // 21 carte

        SecretSolution secretSolution = new SecretSolution(cards); // rimuove 3 carte da cards
        List<Card> sol = secretSolution.getSolution();

        // 1. La soluzione deve contenere esattamente 3 carte
        assertEquals(3, sol.size());

        // 2. La soluzione deve contenere 1 personaggio, 1 arma e 1 stanza
        boolean hasCharacter = sol.stream().anyMatch(c -> c.getType() == CardType.CHARACTER);
        boolean hasWeapon    = sol.stream().anyMatch(c -> c.getType() == CardType.WEAPON);
        boolean hasRoom      = sol.stream().anyMatch(c -> c.getType() == CardType.ROOM);

        assertTrue(hasCharacter);
        assertTrue(hasWeapon);
        assertTrue(hasRoom);

        // 3. Le carte della soluzione non devono essere nel mazzo rimanente
        for (Card c : sol) {
            assertFalse(cards.contains(c));
        }

        // 4. Il mazzo deve avere 18 carte (21 - 3)
        assertEquals(18, cards.size());
    }
}