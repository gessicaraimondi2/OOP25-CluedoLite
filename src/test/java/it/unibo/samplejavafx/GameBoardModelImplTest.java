package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.CluedoLite.model.gameBoard.api.Room;
import it.unibo.CluedoLite.model.gameBoard.impl.*;
import it.unibo.CluedoLite.model.player.impl.Player;

public class GameBoardModelImplTest {

    private GameBoardModelImpl board;
    private Player player;

    @BeforeEach
    void setUp() {
        board = new GameBoardModelImpl();
        player = new Player("Scarlett");
    }

    @Test
    void testGetRoomsReturnsAllNineRooms() {
        assertEquals(9, board.getRooms().size());
    }

    @Test
    void testGetRoomsReturnsUnmodifiableCopy() {
        assertThrows(UnsupportedOperationException.class, () -> {
            board.getRooms().add(new RoomImpl("FakeRoom"));
        });
    }

    @Test
    void testSetAndGetPlayerPosition() {
        Room kitchen = board.getRooms().get(0);
        board.setPlayerPosition(player, kitchen);
        assertEquals(kitchen, board.getPlayerPosition(player));
    }

    @Test
    void testAreAdjacentTrue() {
        Room r1 = board.getRooms().get(0);
        Room r2 = board.getRooms().get(1);
        assertTrue(board.areAdjacent(r1, r2));
    }

    @Test
    void testAreAdjacentFalse() {
        Room r1 = board.getRooms().get(0);
        Room r3 = board.getRooms().get(3);
        assertFalse(board.areAdjacent(r1, r3));
    }

    @Test
    void testCanMoveToAnyRoomAtStart() {
        Room anyRoom = board.getRooms().get(5);
        assertTrue(board.canMoveTo(player, anyRoom));
    }

    @Test
    void testCanMoveToAdjacentRoom() {
        Room kitchen = board.getRooms().get(0);
        Room ballroom = board.getRooms().get(1);
        board.setPlayerPosition(player, kitchen);
        assertTrue(board.canMoveTo(player, ballroom));
    }

    @Test
    void testCannotMoveToNonAdjacentRoom() {
        Room kitchen = board.getRooms().get(0);
        Room library = board.getRooms().get(4);
        board.setPlayerPosition(player, kitchen);
        assertFalse(board.canMoveTo(player, library));
    }
}