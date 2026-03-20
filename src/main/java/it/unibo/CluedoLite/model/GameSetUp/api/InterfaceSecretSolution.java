package it.unibo.CluedoLite.model.GameSetUp.api;

import java.util.List;

import it.unibo.CluedoLite.model.creationCards.impl.Card;

/**
 * Interface for the secret solution of the game.
 * The secret solution is composed of one character, one weapon and one room card.
 */
public interface InterfaceSecretSolution {

    /**
     * Returns the list of cards that compose the secret solution.
     * @return a list containing the secret character, weapon and room card.
     */
    List<Card> getSolution();
}