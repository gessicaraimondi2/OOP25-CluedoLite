package it.unibo.CluedoLite.controller.gameboard.api;

import it.unibo.CluedoLite.model.gameboard.api.Room;
import it.unibo.CluedoLite.model.player.api.Player;

public interface GameBoardController {

    /**
     * Moves the current player to the specified room if the move is valid.
     * If the move is not valid, notifies the view.
     *
     * @param r the target room
     */
    void move(Room r);

    /**
     * Returns the player whose turn it currently is.
     *
     * @return the current player
     */
    Player currentPlayer();

    /**
     * Returns the room with the given name.
     *
     * @param name the name of the room
     * @return the corresponding room, or null if not found
     */
    Room getRoomByName(String name);

    /**
     * Returns the current room of the given player.
     *
     * @param p the player
     * @return the room the player is currently in, or null if not placed yet
     */
    Room getCurrentRoomOf(Player p);

    /**
     * Ends the current player's turn and advances to the next player.
     */
    void endTurn();
}
