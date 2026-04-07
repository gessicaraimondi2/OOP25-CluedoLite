package it.unibo.samplejavafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.gameflow.impl.Game;
import it.unibo.CluedoLite.model.gameflow.impl.GameState;
import it.unibo.CluedoLite.model.player.impl.CreationCharacter;
import it.unibo.CluedoLite.model.player.impl.Player;

public class GameFlowTest {

    private Game game;
    private Player p1, p2, p3;

    @BeforeEach
    void setUp() {
        game = new Game(3);
        p1 = new Player("Anna");
        p2 = new Player("Chiara");
        p3 = new Player("Sara");
    }

    /*
     * Tests that the game starts in MENU state
     */
    @Test
    void testInitialStateIsMenu() {
        assertEquals(GameState.MENU, game.getState());
    }

    /*
     * Tests that enterLobby() transitions from MENU to WAITING
     */
    @Test
    void testEnterLobby() {
        game.enterLobby();
        assertEquals(GameState.WAITING, game.getState());
    }

    /*
     * Tests that enterLobby() throws if not in MENU state
     */
    @Test
    void testEnterLobby_notFromMenu_throws() {
        game.enterLobby(); 
        assertThrows(IllegalStateException.class, () -> game.enterLobby());
    }

    /*
     * Tests that startGame() transitions from WAITING to IN_PROGRESS
     */
    @Test
    void testStartGame() {
        game.enterLobby();
        game.setPlayer(0, p1);
        game.setPlayer(1, p2);
        game.setPlayer(2, p3);

        List<CreationCharacter> chars = new ArrayList<>(game.getAvailableCharacters());
        game.assignCharacterToPlayer(0, chars.get(0));
        game.assignCharacterToPlayer(1, chars.get(1));
        game.assignCharacterToPlayer(2, chars.get(2));

        game.startGame();
        assertEquals(GameState.IN_PROGRESS, game.getState());
    }

    /*
     * Tests that startGame() throws if not all characters are assigned
     */
    @Test
    void testStartGame_notAllAssigned_throws() {
        game.enterLobby();
        game.setPlayer(0, p1); 
        assertThrows(IllegalStateException.class, () -> game.startGame());
    }

    /*
     * Tests that startGame() throws if not in WAITING state
     */
    @Test
    void testStartGame_notFromWaiting_throws() {
        assertThrows(IllegalStateException.class, () -> game.startGame());
    }

    /*
     * Tests that quitToMenu() resets everything and goes back to MENU
     */
    @Test
    void testQuitToMenu_fromWaiting() {
        game.enterLobby();
        game.setPlayer(0, p1);
        game.quitToMenu();

        assertEquals(GameState.MENU, game.getState());
        assertNull(game.getPlayers().get(0));
        assertEquals(6, game.getAvailableCharacters().size());
    }

    /*
     * Tests that quitToMenu() works from IN_PROGRESS
     */
    @Test
    void testQuitToMenu_fromInProgress() {
        game.enterLobby();
        game.setPlayer(0, p1);
        game.setPlayer(1, p2);
        game.setPlayer(2, p3);

        List<CreationCharacter> chars = new ArrayList<>(game.getAvailableCharacters());
        game.assignCharacterToPlayer(0, chars.get(0));
        game.assignCharacterToPlayer(1, chars.get(1));
        game.assignCharacterToPlayer(2, chars.get(2));
        game.startGame();

        game.quitToMenu();
        assertEquals(GameState.MENU, game.getState());
        assertEquals(6, game.getAvailableCharacters().size());
    }

    /*
     * Tests that resetGame() keeps players but clears characters and back to WAITING
     */
    @Test
    void testResetGame() {
        game.enterLobby();
        game.setPlayer(0, p1);
        game.setPlayer(1, p2);
        game.setPlayer(2, p3);

        List<CreationCharacter> chars = new ArrayList<>(game.getAvailableCharacters());
        game.assignCharacterToPlayer(0, chars.get(0));
        game.assignCharacterToPlayer(1, chars.get(1));
        game.assignCharacterToPlayer(2, chars.get(2));
        game.startGame();

        game.resetGame();

        assertEquals(GameState.WAITING, game.getState());
        assertEquals("Anna", game.getPlayers().get(0).getName()); 
        assertNull(game.getPlayers().get(0).getCharacter());   
        assertEquals(6, game.getAvailableCharacters().size());    
    }

    /*
     * Test if game is not IN_PROGRESS
     */
    @Test
    void testResetGame_notInProgress_throws() {
        assertThrows(IllegalStateException.class, () -> game.resetGame());
    }
}
