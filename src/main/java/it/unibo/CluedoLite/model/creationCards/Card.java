package it.unibo.CluedoLite.model.creationCards;
/*
* Abstaract class representing a card in the game, 
* with a name property and a constructor to initialize it, 
* and a getter method to retrieve the name of the card. 
* This class is extended
 */
public abstract class Card{
    private final String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}

