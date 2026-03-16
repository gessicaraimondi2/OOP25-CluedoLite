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
     * @return the next player who will take the turn
     */
    Player nextTurn();
}
