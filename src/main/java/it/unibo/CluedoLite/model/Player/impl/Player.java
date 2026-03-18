package it.unibo.CluedoLite.model.Player.impl;
/**
 * Represents a player in the game.
 * Each player has a name and can choose exactly one character.
 */
public class Player {
    private final String name;
    private CreationCharacter character; // chosen character

    public Player(String name) {
        this.name = name;
    }
    
    public void chooseCharacter(CreationCharacter character) {
        this.character = character;
    }
    /*
     * Returns the character chosen by the player.
     */
    public CreationCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}


