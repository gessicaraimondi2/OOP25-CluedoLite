package it.unibo.CluedoLite.model.accuseAndSuspect.api;

import it.unibo.CluedoLite.model.creationCards.impl.Card;

/**
 * Interface for a suspicion made by a player in the CluedoLite game.
 * A suspicion is composed of a character, a weapon and a room.
 */
public interface InterfaceSuspicion {

    /**
     * Returns the suspected character.
     * @return the character card suspected by the player.
     */
    Card getCharacters();

    /**
     * Returns the suspected weapon.
     * @return the weapon card suspected by the player.
     */
    Card getWeapon();

    /**
     * Returns the room where the suspicion is made.
     * @return the room where the player is located.
     */
    Card getRoom();
}