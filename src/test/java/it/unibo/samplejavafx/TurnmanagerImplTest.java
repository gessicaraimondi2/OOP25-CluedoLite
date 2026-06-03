package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.cluedolite.model.accuseandsuspect.impl.Suspicion;
import it.unibo.cluedolite.model.creationcards.impl.*;
import it.unibo.cluedolite.model.player.api.Player;
import it.unibo.cluedolite.model.player.impl.PlayerImpl;
import it.unibo.cluedolite.model.turnmanager.api.TurnManager;
import it.unibo.cluedolite.model.turnmanager.impl.TurnManagerImpl;

import java.util.List;
import java.util.Optional;


public class TurnmanagerImplTest {
    private PlayerImpl p1, p2, p3, p4;
    private List<Player> players;
    private AbstractCard character, weapon, room;
    private Suspicion suspect;
	private TurnManager tm;

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
        final TurnManager tm = new TurnManagerImpl(players);
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
        final TurnManager tm = new TurnManagerImpl(players);
        tm.endGame();
        assertTrue(tm.isGameOver());
    }

    /**
     * Tests that nextTurn() throws IllegalStateException after the game is over.
     */
    @Test
    void testNextTurnThrowsWhenGameOver() {
        final TurnManager tm = new TurnManagerImpl(players);
        tm.endGame();
        assertThrows(IllegalStateException.class, () -> tm.nextTurn());
    }

    /**
     * Tests that getCurrentPlayer() still returns the correct player after endGame().
     */
    @Test
    void testGetCurrentPlayerAfterGameOver() {
        final TurnManager tm = new TurnManagerImpl(players);
        tm.nextTurn();
        tm.endGame();
        assertEquals(p2, tm.getCurrentPlayer());
    }

    @Test
    void testSuggestionResponseFirstMatch() {
        p2.addCard(character);
        assertEquals(Optional.of(character), tm.checkSuspicion(suspect));
    }

    @Test
    void testSuggestionResponseSkipsNoMatch() {
        p3.addCard(weapon);
        assertEquals(Optional.of(weapon), tm.checkSuspicion(suspect));
    }

    @Test
    void testSuggestionResponseNoMatch() {
        assertTrue(tm.checkSuspicion(suspect).isEmpty());
    }

    @Test
    void testSuggestionResponseCircularOrder() {
        tm.nextTurn(); // currentPlayer = p2
        p1.addCard(room);
        assertEquals(Optional.of(room), tm.checkSuspicion(suspect));
    }
}
