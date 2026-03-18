package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.GameBoard.api.GameBoardModel;
import it.unibo.CluedoLite.model.GameBoard.api.Room;
import it.unibo.CluedoLite.model.GameBoard.impl.GameBoardModelImpl;
import it.unibo.CluedoLite.model.Player.impl.Player;

public class GameBoardModelImplTest {

    private GameBoardModel gb;

    /**
     * Initializes a fresh GameBoardModel before each test.
     */
    @BeforeEach
    void setup() {
        gb = new GameBoardModelImpl();
    }

    /**
     * Tests that all nine rooms are created and reachable by name.
     */
    @Test
    void testRoomsCreation() {
        List<Room> rooms = gb.getRooms();

        assertEquals(9, rooms.size(), "Il numero di stanze deve essere 9");
        
        assertNotNull(gb.getRoomByName("Kitchen"));
        assertNotNull(gb.getRoomByName("Hall"));
        assertNotNull(gb.getRoomByName("Library"));
        
        assertNull(gb.getRoomByName("NonEsiste"));
    }

    /**
     * Tests that each room is adjacent to its neighbours in circular order.
     */
    @Test
    void testAdjacency() {
        List<Room> rooms = gb.getRooms();

        for (int i = 0; i < rooms.size(); i++) {
            Room current = rooms.get(i);
            Room next = rooms.get((i + 1) % rooms.size());
            Room prev = rooms.get((i - 1 + rooms.size()) % rooms.size());

            assertTrue(gb.areAdjacent(current, next),
                    current.getName() + " deve essere adiacente a " + next.getName());

            assertTrue(gb.areAdjacent(current, prev),
                    current.getName() + " deve essere adiacente a " + prev.getName());
        }
    }

    /**
     * Tests that two non-neighbouring rooms are not adjacent.
     */
    @Test
    void testAreAdjacentFalse() {
        Room kitchen = gb.getRoomByName("Kitchen");
        Room library = gb.getRoomByName("Library");

        assertFalse(gb.areAdjacent(kitchen, library));
    }

    /**
     * Tests that a player's position is set and retrieved correctly.
     */
    @Test
    void testPlayerPosition() {
        Player p = new Player("Gessica");
        Room kitchen = gb.getRoomByName("Kitchen");

        gb.setPlayerPosition(p, kitchen);

        assertEquals(kitchen, gb.getPlayerPosition(p),
                "La posizione del giocatore deve essere Kitchen");
    }

     /**
     * Tests that setting a new position overwrites the previous one.
     */
    @Test
    void testPlayerPositionOverwrite() {
        Player p = new Player("Gessica");
        Room kitchen = gb.getRoomByName("Kitchen");
        Room hall = gb.getRoomByName("Hall");

        gb.setPlayerPosition(p, kitchen);
        gb.setPlayerPosition(p, hall);

        assertEquals(hall, gb.getPlayerPosition(p),
                "La posizione deve essere aggiornata all'ultima stanza assegnata");
    }

}