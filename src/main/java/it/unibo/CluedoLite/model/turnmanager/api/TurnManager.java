package it.unibo.CluedoLite.model.turnmanager.api;
import it.unibo.CluedoLite.model.Player.impl.Player;

/**
 * Interface rapresenting the logic of the class that manages the turn order of players in the game.
 */

 public interface TurnManager {

    /**
     * @return the current player
     */
    Player getCurrentPlayer();

    /**
     * Marks the game as over, preventing further turn progression.
     */
    void endGame();

    /**
     * @return true if the game has ended, false otherwise
     */
    boolean isGameOver();

    /**
     * @return the next player who will take the turn
     * @throws IllegalStateException if the game is already over
     */
    Player nextTurn();
}
