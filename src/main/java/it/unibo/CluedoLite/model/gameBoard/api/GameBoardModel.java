package it.unibo.CluedoLite.model.gameBoard.api;
import java.util.*;

import it.unibo.CluedoLite.model.player.api.Player;

public interface GameBoardModel {

    /**
     * Returns a copy of the list of all rooms in the game board.
     *
     * @return a list containing all the rooms
     */
    List<Room> getRooms();

    /**
     * Returns the room with the given name, or null if not found
     *
     * @param name the name of the room to search for
     * @return the matching room, or null if no room has that name
     */
    Room getRoomByName(String name);

    /**
     * Returns the current room of the given player.
     * Returns null if the player has no position yet (start of the game).
     *
     * @param p the player whose position is requested
     * @return the room where the player is located, or null if not yet placed
     */
    Room getPlayerPosition(Player p);

    /**
     * Sets the position of the given player to the specified room.
     *
     * @param p the player whose position is to be set
     * @param r the room where the player will be placed
     */
    void setPlayerPosition(Player p,Room r);

    
    /**
     * Checks whether two rooms are adjacent to each other.
     *
     * @param r1 the first room
     * @param r2 the second room
     * @return true if r1 and r2 are adjacent, false otherwise
     */
    boolean areAdjacent(Room r1, Room r2);

    /**
     * Checks whether the given player can move to the target room.
     * A player with no current position (start of the game) can move to any room.
     * Otherwise, the target room must be adjacent to the player's current position.
     *
     * @param p the player who wants to move
     * @param target the room the player wants to move to
     * @return true if the move is allowed, false otherwise
     */
    boolean canMoveTo(Player p, Room target) ;
}
