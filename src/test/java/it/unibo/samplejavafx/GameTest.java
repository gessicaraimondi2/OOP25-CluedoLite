package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.GameFlow.impl.Game;
import it.unibo.CluedoLite.model.Player.impl.CreationCharacter;

public class GameTest {

    /*
     * Tests that the game is created correctly with a valid number of players
     */
    @Test
    public void testValidNumberOfPlayers() {
        assertDoesNotThrow(() -> new Game(3));
    }

    @Test
    public void testInvalidNumberOfPlayers() {
        assertThrows(IllegalArgumentException.class, () -> new Game(2));
        assertThrows(IllegalArgumentException.class, () -> new Game(7));
    }

    /*
     * Tests that the available characters list contains exactly 6 characters
     */
    @Test
    public void testAvailableCharactersCount() {
        Game game = new Game(3);
        assertEquals(6, game.getAvailableCharacters().size());
    }

    /*
     * Tests that a player can be correctly inserted into the game
     */
    @Test
    public void testSetPlayerCorrectly() {
        Game game = new Game(3);
        Player p = new Player("Anna");
        game.setPlayer(0, p);
        assertEquals(p, game.getPlayers().get(0));
    }

    /*
     * Tests that setting a player out of bounds throws an exception
     */
    @Test
    public void testSetPlayerOutOfBounds() {
        Game game = new Game(3);
        assertThrows(IndexOutOfBoundsException.class, () -> game.setPlayer(3, new Player("Test")));
    }

    /*
     * Tests that assigning a character to a valid player works correctly
     */
    @Test
    public void testAssignCharacterCorrectly() {
        Game game = new Game(3);

        Player p1 = new Player("Anna");
        game.setPlayer(0, p1);

        CreationCharacter c = game.getAvailableCharacters().get(0);
        game.assignCharacterToPlayer(0, c);

        assertEquals(c, p1.getCharacter());
    }

    /*
     * Tests that assigning a character to a null player throws an exception
     */
    @Test
    public void testAssignCharacterToNullPlayer() {
        Game game = new Game(3);
        CreationCharacter c = game.getAvailableCharacters().get(0);

        assertThrows(IllegalStateException.class, () -> game.assignCharacterToPlayer(0, c));
    }

    /*
     * Tests that a character cannot be assigned twice
     */
    @Test
    public void testAssignDuplicateCharacter() {
        Game game = new Game(3);

        Player p1 = new Player("Anna");
        Player p2 = new Player("Chiara");

        game.setPlayer(0, p1);
        game.setPlayer(1, p2);

        CreationCharacter c = game.getAvailableCharacters().get(0);

        game.assignCharacterToPlayer(0, c);

        assertThrows(IllegalArgumentException.class, () -> game.assignCharacterToPlayer(1, c));
    }

    /* 
     * Tests that an assigned character is removed from the list of available characters
    */
    @Test
    public void testCharacterIsRemovedFromAvailableList() {
        Game game = new Game(3);

        Player p1 = new Player("Anna");
        game.setPlayer(0, p1);

        CreationCharacter c = game.getAvailableCharacters().get(0);

        game.assignCharacterToPlayer(0, c);

        assertFalse(game.getAvailableCharacters().contains(c));
    }

    /*
     * Tests that players are added, characters assigned, and duplicates prevented
     */
    @Test
    public void testGameSetupAndCharacterAssignment() {
        Game game = new Game(3);

        Player p1 = new Player("Anna");
        Player p2 = new Player("Chiara");
        Player p3 = new Player("Sara");

        game.setPlayer(0, p1);
        game.setPlayer(1, p2);
        game.setPlayer(2, p3);

        // Make a copy of the original list before assignments
        List<CreationCharacter> characters = new ArrayList<>(game.getAvailableCharacters());

        game.assignCharacterToPlayer(0, characters.get(0)); 
        game.assignCharacterToPlayer(1, characters.get(1)); 

        assertEquals("Miss Scarlet", p1.getCharacter().getName());
        assertEquals("RED", p1.getCharacter().getColor());

        assertEquals("Colonel Mustard", p2.getCharacter().getName());
        assertEquals("YELLOW", p2.getCharacter().getColor());

        assertThrows(IllegalArgumentException.class, () -> {
            game.assignCharacterToPlayer(2, characters.get(0));
        });

        game.assignCharacterToPlayer(2, characters.get(2));

        assertEquals("Mrs. White", p3.getCharacter().getName());
    }
}


