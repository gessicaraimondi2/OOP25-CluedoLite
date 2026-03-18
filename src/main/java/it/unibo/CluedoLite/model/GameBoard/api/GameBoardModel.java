package it.unibo.CluedoLite.model.GameBoard.api;
import java.util.*;

import it.unibo.CluedoLite.model.Player.impl.Player;

public interface GameBoardModel {

    /**
     * @return the list of all rooms on the board
     */
    List<Room> getRooms();

    /**
     * @param name the name of the room to search for
     * @return the room with the given name, or null if not found
     */
    Room getRoomByName(String name);

     /**
     * @param p the player whose position is requested
     * @return the room where the player is currently located, or null if not placed
     */
    Room getPlayerPosition(Player p);

    /**
     * @param p the player to move
     * @param r the room to place the player in
     */
    void setPlayerPosition(Player p,Room r);

    
     /**
     * @param r1 the first room
     * @param r2 the second room
     * @return true if r1 and r2 are adjacent, false otherwise
     */
    boolean areAdjacent(Room r1, Room r2);
}
