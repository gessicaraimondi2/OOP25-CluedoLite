package it.unibo.CluedoLite.model.AccuseAndSuspect;

import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;
import it.unibo.CluedoLite.model.GameBoard.api.Room;

/*
 * This class represents a suspicion made by a player in the CluedoLite game. 
 * It encapsulates the character, weapon, and room that the player suspects to be involved in the crime. 
 * The class provides getter methods to retrieve the details of the suspicion.
 */
public final class Suspicion {
    private final Characters suspectCharacter;
    private final Weapons suspectWeapon;
    private final Room suspectroom; // The room where the player is currently located when making the suspicion

    public Suspicion (Characters suspectCharacter, Weapons suspectWeapon, Room suspectroom) {
        this.suspectCharacter = suspectCharacter;
        this.suspectWeapon = suspectWeapon;
        this.suspectroom = suspectroom;
    }

    public Characters getSuspect() { 
        return suspectCharacter; 
    }

    public Weapons getWeapon() { 
        return suspectWeapon; 
    }

    public Room getRoom() { 
        return suspectroom; 
    }

    @Override
    public String toString() {
        return "Sospetto: " + suspectCharacter.getName() 
             + " con " + suspectWeapon.getName() 
             + " nella " + suspectroom.getName();
    }
}