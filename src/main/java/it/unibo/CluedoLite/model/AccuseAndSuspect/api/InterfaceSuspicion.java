package it.unibo.CluedoLite.model.AccuseAndSuspect.api;

import it.unibo.CluedoLite.model.creationCards.impl.Characters;
import it.unibo.CluedoLite.model.creationCards.impl.Weapons;
import it.unibo.CluedoLite.model.GameBoard.api.Room;

/**
 * Interface for a suspicion made by a player in the CluedoLite game.
 * A suspicion is composed of a character, a weapon and a room.
 */
public interface InterfaceSuspicion {

    /**
     * Returns the suspected character.
     * @return the character card suspected by the player.
     */
    Characters getCharacters();

    /**
     * Returns the suspected weapon.
     * @return the weapon card suspected by the player.
     */
    Weapons getWeapon();

    /**
     * Returns the room where the suspicion is made.
     * @return the room where the player is located.
     */
    Room getRoom();
}