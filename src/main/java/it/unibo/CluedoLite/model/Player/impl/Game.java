package it.unibo.CluedoLite.model.Player.impl;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final List<CreationCharacter> availableCharacters;

    /**
     * Creates a new game with the given number of players.
     * The number of players must be between 3 and 6.
     */
    public Game(int numPlayers) {
        if (numPlayers < 3 || numPlayers > 6) {
            throw new IllegalArgumentException("Number of players must be between 3 and 6.");
        }

        // Initialize the player list with empty slots (null)
        this.players = new ArrayList<>(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            players.add(null);
        }

        // Initialize the list of available characters
        this.availableCharacters = new ArrayList<>(List.of(
            new CreationCharacter("Miss Scarlet", "RED"),
            new CreationCharacter("Colonel Mustard", "YELLOW"),
            new CreationCharacter("Mrs. White", "WHITE"),
            new CreationCharacter("Mr. Green", "GREEN"),
            new CreationCharacter("Mrs. Peacock", "BLUE"),
            new CreationCharacter("Professor Plum", "PURPLE")
        ));
    }

    /**
     * Returns the list of players in the game.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Returns the list of characters that are still available.
     */
    public List<CreationCharacter> getAvailableCharacters() {
        return availableCharacters;
    }

    /**
     * Sets a player in the given position.
     */
    public void setPlayer(int index, Player player) {
        players.set(index, player);
    }

    /**
     * Assigns a character to a player.
     * 
     * Checks:
     * 1. The player exists.
     * 2. The character has not already been chosen by another player.
     * 3. Removes the character from the available list.
     */
    public void assignCharacterToPlayer(int index, CreationCharacter character) {

        // 1. Check if the player exists
        if (players.get(index) == null) {
            throw new NullPointerException("Player not initialized.");
        }

        // 2. Check if the character is already taken by another player
        for (Player p : players) {
            if (p != null && p.getCharacter() != null && p.getCharacter().equals(character)) {
                throw new IllegalArgumentException("This character is already chosen by another player.");
            }
        }

        // 3. Assign the character to the player
        players.get(index).chooseCharacter(character);

        // 4. Remove the character from the available list
        availableCharacters.remove(character);
    }
}
