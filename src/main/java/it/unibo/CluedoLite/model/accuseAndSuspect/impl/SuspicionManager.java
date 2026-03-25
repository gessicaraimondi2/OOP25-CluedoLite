package it.unibo.CluedoLite.model.accuseAndSuspect.impl;

import it.unibo.CluedoLite.model.accuseAndSuspect.api.InterfaceSuspicionManager;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.gameBoard.impl.GameBoardModelImpl;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;

/*
 * This class manages the suspicion phase of the CluedoLite game.
 * It creates a Suspicion object using the character and weapon chosen by the player,
 * and the room where the player currently is.
 */
public class SuspicionManager implements InterfaceSuspicionManager {

    //The game board is needed to determine the room of the player when making a suspicion
    private final GameBoardModelImpl board;

    /**
    * Constructs a {@link SuspicionManager} with the given game board.
    * @param board the {@link GameBoardModelImpl} representing the current game board
    */
    public SuspicionManager(GameBoardModelImpl board) {
        this.board = board;
    }

    /*
     * Creates a Suspicion object based on the player's current position and the chosen character and weapon.
     * If the player is not in a room, it returns null and prints a message indicating that the suspicion cannot be made.
     * Otherwise, it returns a new Suspicion object with the specified character, weapon, and the room where the player is located.
     */
    @Override
    public Suspicion makeSuspicion(PlayerImpl player, Card character, Card weapon) {

        // Get the room where the player is currently located and cast it to a Card, since rooms are represented as Cards in the game
        Card room = (Card) board.getPlayerPosition(player);

        // If the player is not in a room, they cannot make a suspicion
        if (room == null) {
            System.out.println("The player is not in a room and cannot make a suspicion.");
            return null;
        }

        // Create and return a new Suspicion object with the chosen character, weapon, and the room where the player is located
        return new Suspicion(character, weapon, room);
    }
}