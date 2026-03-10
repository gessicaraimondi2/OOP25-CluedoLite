package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.Deck;
import it.unibo.CluedoLite.model.SecretSolution;
import it.unibo.CluedoLite.model.creationCards.Card;
import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;
import it.unibo.CluedoLite.model.creationCards.Rooms;

public class TestSecretSolution {

    @Test
    public void testSecretSolutionGeneration() {
        Deck deck = new Deck();

        // Recupero la soluzione
        SecretSolution secret = new SecretSolution();
        List<Card> sol = secret.getSolution();

        // 1. La soluzione deve contenere esattamente 3 carte
        assertEquals(3, sol.size());

        // 2. Deve contenere 1 personaggio, 1 arma, 1 stanza
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

        // 3. Le carte della soluzione NON devono essere nel mazzo
        for (Card c : sol) {
            assertFalse(deck.getCards().contains(c));
        }

        // 4. Il mazzo deve avere 21 carte (24 totali - 3 soluzione)
        assertEquals(21, deck.getCards().size());
}
}