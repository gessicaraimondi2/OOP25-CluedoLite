package main.java.it.unibo.CluedoLite.model.Player.impl;

public class Game {

    private final Character[] availableCharacters = { //tutti i personaggi
        new Character("Miss Scarlet", "RED"),
        new Character("Colonel Mustard", "YELLOW"),
        new Character("Mrs. White", "WHITE"),
        new Character("Mr. Green", "GREEN"),
        new Character("Mrs. Peacock", "BLUE"),
        new Character("Professor Plum", "PURPLE")
    };

    private Player[] players; //array da 3 a 6 giocatori

    public Game(int numberOfPlayers) {
        if (numberOfPlayers < 3 || numberOfPlayers > 6) {
            throw new IllegalArgumentException("Number of players must be between 3 and 6");
        }

        players = new Player[numberOfPlayers];
    }

    public Character[] getAvailableCharacters() {
        return availableCharacters;
    }

    public void setPlayer(int index, Player player) {
        players[index] = player;
    }

    public void assignCharacterToPlayer(int playerIndex, Character character) {
        // Check if the character is already taken
        for (Player p : players) {
            if (p != null && p.getCharacter() != null && p.getCharacter().equals(character)) {
                throw new IllegalArgumentException("This character is already chosen by another player.");
            }
        }
        // If free, assign it
        players[playerIndex].chooseCharacter(character);
    }

    public Player[] getPlayers() {
        return players;
    }
}

