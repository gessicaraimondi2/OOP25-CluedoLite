package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import it.unibo.CluedoLite.model.accuseAndSuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.model.creationCards.impl.*;
import it.unibo.CluedoLite.model.turnmanager.api.turnManager;
import it.unibo.CluedoLite.model.turnmanager.impl.TurnManagerImpl;


public class TurnmanagerImplTest {
    private PlayerImpl p1, p2, p3, p4;
    private List<PlayerImpl> players;
    private Card character, weapon, room;
    private Suspicion suspect;
	private turnManager tm;

    /**
     * Initializes players and cards before each test.
     */
    @BeforeEach
    void init() {
        p1 = new PlayerImpl("Giulia");
        p2 = new PlayerImpl("Giorgia");
        p3 = new PlayerImpl("Gessica");
        p4 = new PlayerImpl("Valentina");
        this.players = List.of(p1, p2, p3, p4);

        character = new Characters("Miss Scarlett");
        weapon = new Weapons("Dagger");
        room = new Rooms("Kitchen");


        suspect= new Suspicion(character, weapon, room);
       
	    tm = new TurnManagerImpl(players);
    }


    /**
     * Tests the normal turn order.
     */
    @Test
    void testTurn() {
        final turnManager tm = new TurnManagerImpl(players);
        assertEquals(p1, tm.getCurrentPlayer());
        assertEquals(p2, tm.nextTurn());
        assertEquals(p3, tm.nextTurn());
        assertEquals(p4, tm.nextTurn());
        assertEquals(p1, tm.nextTurn());
    }

    /**
     * Tests that isGameOver() returns true after endGame() is called.
     */
    @Test
    void testEndGame() {
        final turnManager tm = new TurnManagerImpl(players);
        tm.endGame();
        assertTrue(tm.isGameOver());
    }

    /**
     * Tests that nextTurn() throws IllegalStateException after the game is over.
     */
    @Test
    void testNextTurnThrowsWhenGameOver() {
        final turnManager tm = new TurnManagerImpl(players);
        tm.endGame();
        assertThrows(IllegalStateException.class, () -> tm.nextTurn());
    }

    /**
     * Tests that getCurrentPlayer() still returns the correct player after endGame().
     */
    @Test
    void testGetCurrentPlayerAfterGameOver() {
        final turnManager tm = new TurnManagerImpl(players);
        tm.nextTurn();
        tm.endGame();
        assertEquals(p2, tm.getCurrentPlayer());
    }

        @Test
    void testSuggestionResponseFirstMatch() {
        p2.addCard(character);
        assertEquals(character, tm.SuggestionResponse(suspect));
    }

    @Test
    void testSuggestionResponseSkipsNoMatch() {
        p3.addCard(weapon);
        assertEquals(weapon, tm.SuggestionResponse(suspect));
    }

    @Test
    void testSuggestionResponseNoMatch() {
        assertNull(tm.SuggestionResponse(suspect));
    }

    @Test
    void testSuggestionResponseCircularOrder() {
        tm.nextTurn(); // currentPlayer = p2
        p1.addCard(room);
        assertEquals(room, tm.SuggestionResponse(suspect));
    }
}
