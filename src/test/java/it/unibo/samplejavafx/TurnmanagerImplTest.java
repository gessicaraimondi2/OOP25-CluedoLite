package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.Turnmanager.api.TurnManager;
import it.unibo.CluedoLite.model.Turnmanager.impl.TurnManagerImpl;


public class TurnmanagerImplTest {
    private Player p1, p2, p3, p4;
    private List<Player> players;
    // private Card character, weapon, room;
	// private TurnManager tm;

    /**
     * Initializes players and cards before each test.
     */
    @BeforeEach
    void init() {
        p1 = new Player("Giulia");
        p2 = new Player("Giorgia");
        p3 = new Player("Gessica");
        p4 = new Player("Valentina");
        this.players = List.of(p1, p2, p3, p4);

        // character = new Characters("Miss Scarlett");
        // weapon = new Weapons("Dagger");
        // room = new Rooms("Kitchen");

	    // tm = new TurnManagerImpl(players);
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
}
