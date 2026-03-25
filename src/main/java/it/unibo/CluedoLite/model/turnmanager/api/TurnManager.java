package it.unibo.CluedoLite.model.turnmanager.api;


import it.unibo.CluedoLite.model.accuseAndSuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;

/**
 * Interface rapresenting the logic of the class that manages the turn order of players in the game.
 */

 public interface TurnManager {

    /**
     * Returns the player whose turn it currently is.
     *
     * @return the current player
     */
    PlayerImpl getCurrentPlayer();

    /**
     * Marks the game as over, preventing any further turn progression.
     */
    void endGame();

    /**
     * Checks whether the game has ended.
     *
     * @return true if the game is over, false otherwise
     */
    boolean isGameOver();

    /**
     * Advances the turn to the next player in circular order.
     * Throws an exception if the game is already over.
     *
     * @return the next player
     * @throws IllegalStateException if the game is already over
     */
    PlayerImpl nextTurn();

    /**
     * Handles the response to the current player's suggestion.
     * The other players, in circular order, show the first card in their hand
     * that matches the suggestion and has not yet been excluded from the notebook.
     *
     * @param suspicion the suspected cards
     * @return the card shown by the first player who can respond, or null if no one can
     */
    Card SuggestionResponse(Suspicion suspicion);
}