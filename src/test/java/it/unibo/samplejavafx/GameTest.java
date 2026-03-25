package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.gameFlow.impl.GameImpl;
import it.unibo.CluedoLite.model.player.impl.CreationCharacterImpl;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;

public class GameTest {

    /*
     * Tests that the game is created correctly with a valid number of players
     */
    @Test
    public void testValidNumberOfPlayers() {
        assertDoesNotThrow(() -> new GameImpl(3));
    }

    @Test
    public void testInvalidNumberOfPlayers() {
        assertThrows(IllegalArgumentException.class, () -> new GameImpl(2));
        assertThrows(IllegalArgumentException.class, () -> new GameImpl(7));
    }

    /*
     * Tests that the available characters list contains exactly 6 characters
     */
    @Test
    public void testAvailableCharactersCount() {
        GameImpl game = new GameImpl(3);
        assertEquals(6, game.getAvailableCharacters().size());
    }

    /*
     * Tests that a player can be correctly inserted into the game
     */
    @Test
    public void testSetPlayerCorrectly() {
        GameImpl game = new GameImpl(3);
        PlayerImpl p = new PlayerImpl("Anna");
        game.setPlayer(0, p);
        assertEquals(p, game.getPlayers().get(0));
    }

    /*
     * Tests that setting a player out of bounds throws an exception
     */
    @Test
    public void testSetPlayerOutOfBounds() {
        GameImpl game = new GameImpl(3);
        assertThrows(IndexOutOfBoundsException.class, () -> game.setPlayer(3, new PlayerImpl("Test")));
    }

    /*
     * Tests that assigning a character to a valid player works correctly
     */
    @Test
    public void testAssignCharacterCorrectly() {
        GameImpl game = new GameImpl(3);

        PlayerImpl p1 = new PlayerImpl("Anna");
        game.setPlayer(0, p1);

        CreationCharacterImpl c = game.getAvailableCharacters().get(0);
        game.assignCharacterToPlayer(0, c);

        assertEquals(c, p1.getCharacter());
    }

    /*
     * Tests that assigning a character to a null player throws an exception
     */
    @Test
    public void testAssignCharacterToNullPlayer() {
        GameImpl game = new GameImpl(3);
        CreationCharacterImpl c = game.getAvailableCharacters().get(0);

        assertThrows(IllegalStateException.class, () -> game.assignCharacterToPlayer(0, c));
    }

    /*
     * Tests that a character cannot be assigned twice
     */
    @Test
    public void testAssignDuplicateCharacter() {
        GameImpl game = new GameImpl(3);

        PlayerImpl p1 = new PlayerImpl("Anna");
        PlayerImpl p2 = new PlayerImpl("Chiara");

        game.setPlayer(0, p1);
        game.setPlayer(1, p2);

        CreationCharacterImpl c = game.getAvailableCharacters().get(0);

        game.assignCharacterToPlayer(0, c);

        assertThrows(IllegalArgumentException.class, () -> game.assignCharacterToPlayer(1, c));
    }

    /* 
     * Tests that an assigned character is removed from the list of available characters
    */
    @Test
    public void testCharacterIsRemovedFromAvailableList() {
        GameImpl game = new GameImpl(3);

        PlayerImpl p1 = new PlayerImpl("Anna");
        game.setPlayer(0, p1);

        CreationCharacterImpl c = game.getAvailableCharacters().get(0);

        game.assignCharacterToPlayer(0, c);

        assertFalse(game.getAvailableCharacters().contains(c));
    }

    /*
     * Tests that players are added, characters assigned, and duplicates prevented
     */
    @Test
    public void testGameSetupAndCharacterAssignment() {
        GameImpl game = new GameImpl(3);

        PlayerImpl p1 = new PlayerImpl("Anna");
        PlayerImpl p2 = new PlayerImpl("Chiara");
        PlayerImpl p3 = new PlayerImpl("Sara");

        game.setPlayer(0, p1);
        game.setPlayer(1, p2);
        game.setPlayer(2, p3);

        // Make a copy of the original list before assignments
        List<CreationCharacterImpl> characters = new ArrayList<>(game.getAvailableCharacters());

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


