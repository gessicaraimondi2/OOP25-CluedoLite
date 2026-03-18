package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.turnmanager.api.TurnManager;
import it.unibo.CluedoLite.model.turnmanager.impl.TurnManagerImpl;


public class TurnmanagerImplTest {
    private Player p1, p2, p3, p4;
    private List<Player> players;

    /**
    * Initializes a Players list before the test.
     */
    @BeforeEach
    void init() {
        p1 = new Player("Giulia");
        p2 = new Player("Giorgia");
        p3 = new Player("Gessica");
        p4 = new Player("Valentina");
        this.players = List.of(p1, p2, p3, p4);
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
}
