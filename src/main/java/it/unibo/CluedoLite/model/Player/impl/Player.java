package main.java.it.unibo.CluedoLite.model.Player.impl;

public class Player {
    private final String name;
    private Character character; // chosen character

    public Player(String name) {
        this.name = name;
    }

    public void chooseCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}


