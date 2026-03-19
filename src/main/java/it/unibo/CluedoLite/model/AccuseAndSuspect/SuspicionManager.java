package it.unibo.CluedoLite.model.AccuseAndSuspect;

import it.unibo.CluedoLite.model.GameBoard.api.Room;
import it.unibo.CluedoLite.model.GameBoard.impl.GameBoardModelImpl;
import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;

/*
 * This class manages the suspicion phase of the CluedoLite game.
 * It creates a Suspicion object using the character and weapon chosen by the player,
 * and the room where the player currently is.
 */
public class SuspicionManager {

    //The game board is needed to determine the room of the player when making a suspicion
    private final GameBoardModelImpl board;

    // Constructor that takes the game board as a parameter
    public SuspicionManager(GameBoardModelImpl board) {
        this.board = board;
    }

    /*
    * Creates a Suspicion object based on the player's current position and the chosen character and weapon.
     * If the player is not in a room, it returns null and prints a message indicating that the suspicion cannot be made.
     * Otherwise, it returns a new Suspicion object with the specified character, weapon, and the room where the player is located.
     */
    public Suspicion makeSuspicion(Player player, Characters character, Weapons weapon) {

        // Get the room where the player is currently located
        Room room = board.getPlayerPosition(player);

        // If the player is not in a room, they cannot make a suspicion
        if (room == null) {
            System.out.println("The player is not in a room and cannot make a suspicion.");
            return null;
        }

        // Create and return a new Suspicion object with the chosen character, weapon, and the room where the player is located
        return new Suspicion(character, weapon, room);
    }
}