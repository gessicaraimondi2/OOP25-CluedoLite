package it.unibo.CluedoLite.model.AccuseAndSuspect.api;

import it.unibo.CluedoLite.model.AccuseAndSuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.creationCards.impl.Characters;
import it.unibo.CluedoLite.model.creationCards.impl.Weapons;

/**
 * Interface for the suspicion manager in the CluedoLite game.
 * It handles the creation of suspicions during the game.
 */
public interface InterfaceSuspicionManager {

    /**
     * Creates a suspicion based on the player's current position and the chosen character and weapon.
     * Returns null if the player is not in a room.
     * @param player the player making the suspicion.
     * @param character the suspected character.
     * @param weapon the suspected weapon.
     * @return a Suspicion object, or null if the player is not in a room.
     */
    Suspicion makeSuspicion(Player player, Characters character, Weapons weapon);
}