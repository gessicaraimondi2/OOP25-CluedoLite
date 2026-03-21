package it.unibo.CluedoLite.model.Player.impl;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final List<CreationCharacter> availableCharacters;
    private GameState state;

     private static final List<CreationCharacter> DEFAULT_CHARACTERS = List.of(
        new CreationCharacter("Miss Scarlet", "RED"),
        new CreationCharacter("Colonel Mustard", "YELLOW"),
        new CreationCharacter("Mrs. White", "WHITE"),
        new CreationCharacter("Mr. Green", "GREEN"),
        new CreationCharacter("Mrs. Peacock", "BLUE"),
        new CreationCharacter("Professor Plum", "PURPLE")
    );
    /*
     * Creates a new game; The number of players must be between 3 and 6
     */
    public Game(int numPlayers) {
        if (numPlayers < 3 || numPlayers > 6) {
            throw new IllegalArgumentException("Number of players must be between 3 and 6");
        }

        this.players = new ArrayList<>(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            players.add(null);
        }
        this.availableCharacters = new ArrayList<>(DEFAULT_CHARACTERS);
        this.state = GameState.MENU;
    }
    /*
     * Returns the list of players in the game
     */
    public List<Player> getPlayers() {
        return players;
    }
    /*
     * Returns the list of characters that are still available
     */
    public List<CreationCharacter> getAvailableCharacters() {
        return availableCharacters;
    }
    /*
     * Sets a player in the given position.
     */
    public void setPlayer(int index, Player player) {
        players.set(index, player);
    }
    /**
     * Assigns a character to a player
     * 1. The player exists
     * 2. The character has not already been chosen by another player
     * 3. Removes the character from the available list
     */
    public void assignCharacterToPlayer(int index, CreationCharacter character) {

        if (players.get(index) == null) {
            throw new IllegalStateException("Player not initialized");
        }

        for (Player p : players) {
            if (p != null && p.getCharacter() != null && p.getCharacter().equals(character)) {
                throw new IllegalArgumentException("This character is already chosen by another player");
            }
        }
        players.get(index).chooseCharacter(character);
        availableCharacters.remove(character);
    }
    // retun state of the game
    public GameState getState() {
        return state;
    }
    /*
    * Moves the game from the main menu to the lobby
     */
    public void enterLobby(){
        if (state != GameState.MENU)
        throw new IllegalStateException("Game is not in the main menu");
        this.state = GameState.WAITING;
    }
    /*
    * Starts the game if all players have a character assigned
     */
    public void startGame() {
    if (state != GameState.WAITING)
        throw new IllegalStateException("Game is not in the lobby");
    if (!allCharactersAssigned())
        throw new IllegalStateException("Not all players have a character");
    this.state = GameState.IN_PROGRESS;
    }
    // Returns true if every player has a character assigned
    public boolean allCharactersAssigned() {
        for (Player p : players)
            if (p == null || p.getCharacter() == null) return false;
        return true;
    }
    // Returns to the main menu from any state
    public void quitToMenu() {
        players.replaceAll(p -> null);
        availableCharacters.clear();
        availableCharacters.addAll(DEFAULT_CHARACTERS);
        this.state = GameState.MENU;
    }
    /*  Restarts the game with the same players  */
    public void resetGame() {
        if (state != GameState.IN_PROGRESS)
            throw new IllegalStateException("Game is not in progress");
        for (Player p : players)
            if (p != null) p.chooseCharacter(null);
        availableCharacters.clear();
        availableCharacters.addAll(DEFAULT_CHARACTERS);
        this.state = GameState.WAITING;
    }
}
