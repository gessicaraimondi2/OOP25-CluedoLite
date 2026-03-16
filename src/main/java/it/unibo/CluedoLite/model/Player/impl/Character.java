package main.java.it.unibo.CluedoLite.model.Player.impl;

public class Character {
    private final String name;
    private final String color;

    public Character(String name, String color) {
        this.name = name;
        this.color = color;      
    }

    public String getName() {
        return name;
    }
    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return name + "(" + color + ")";
    }
}
