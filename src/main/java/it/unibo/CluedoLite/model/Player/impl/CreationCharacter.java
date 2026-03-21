package it.unibo.CluedoLite.model.Player.impl;

import it.unibo.CluedoLite.model.creationCards.impl.Characters;
/**
 * Represents a playable character in the game
 * Each character has a name 
 * and a unique color associated with it
 */
public class CreationCharacter extends Characters{
    private final String color;

    public CreationCharacter(String name, String color) {
        super(name);
        this.color = color;      
    }

    public String getColor(){
        return color;
    }
    /*
     * Returns a string representation of the character,
     * including its name and color
     */
    @Override
    public String toString() {
        return getName() + "(" + color + ")";
    }
}
