package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.GameSetUp.Deck;
import it.unibo.CluedoLite.model.GameSetUp.SecretSolution;
import it.unibo.CluedoLite.model.creationCards.Card;
import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;
import it.unibo.CluedoLite.model.creationCards.Rooms;

/*
* Test class for the SecretSolution class.
 */
public class TestSecretSolution {

    @Test
    public void testSecretSolutionGeneration() {
        Deck deck = new Deck();

        // Regenerate the secret solution and get the solution cards
        SecretSolution secretSolution = new SecretSolution(deck);
        List<Card> sol = secretSolution.getSolution();

        // 1. The solution must contain exactly 3 cards
        assertEquals(3, sol.size());

        // 2. The solution must contain 1 character, 1 weapon, and 1 room
        boolean hasCharacter = false;
        boolean hasWeapon = false;
        boolean hasRoom = false;

        for (Card c : sol) {
            if (c instanceof Characters) hasCharacter = true;
            if (c instanceof Weapons) hasWeapon = true;
            if (c instanceof Rooms) hasRoom = true;
        }

        assertTrue(hasCharacter);
        assertTrue(hasWeapon);
        assertTrue(hasRoom);

        // 3. The solution cards must not be in the deck anymore
        for (Card c : sol) {
            assertFalse(deck.getCards().contains(c));
        }

        // 4. The deck must have 18 cards (21 total - 3 solution cards)
        assertEquals(18, deck.getCards().size());
        //5. The original deck must still have 21 cards
        assertEquals(21, deck.getOriginalCards().size());
    }
}