package it.unibo.samplejavafx;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.GameSetUp.impl.Deck;
import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.creationCards.impl.CardType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.unibo.CluedoLite.model.suspectNotes.*;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Test class for the Table class. 
 */
class TableTest {
    private Card missScarlett;
    private Card candlestick;
    private Card kitchen;

    @BeforeEach
    void setUp() {
        List<Card> allCards = Deck.getAllCards();

        missScarlett = allCards.stream()
                .filter(c -> c.getType() == CardType.CHARACTER)
                .findFirst()
                .orElseThrow();

        candlestick = allCards.stream()
                .filter(c -> c.getType() == CardType.WEAPON)
                .findFirst()
                .orElseThrow();

        kitchen = allCards.stream()
                .filter(c -> c.getType() == CardType.ROOM)
                .findFirst()
                .orElseThrow();
    }

    @Test
    void defaultState() {
        Box box = new Box(missScarlett);
        assertEquals(State.POSSIBLE, box.getState());
    }

    @Test
    void excludeCard() {
        Box box = new Box(missScarlett);
        box.excludeCard();
        assertEquals(State.EXCLUDED, box.getState());
    }

    @Test
    void tableCreation() {
        Table table = new Table(new ArrayList<>());
        int deckSize = Deck.getAllCards().size(); // 21 cards
        int boxesNum = table.searchType(missScarlett).size() 
                     + table.searchType(candlestick).size() 
                     + table.searchType(kitchen).size(); 
        assertEquals(deckSize, boxesNum);
    }

    @Test
    void searchTypeCharacters() {
        Table table = new Table(new ArrayList<>());
        List<Box> characterList = table.searchType(missScarlett);
        assertTrue(characterList.stream().allMatch(b -> b.getCard().getType() == CardType.CHARACTER));
    }

    @Test
    void searchTypeWeapons() {
        Table table = new Table(new ArrayList<>());
        List<Box> weaponList = table.searchType(candlestick);
        assertTrue(weaponList.stream().allMatch(b -> b.getCard().getType() == CardType.WEAPON));
    }

    @Test
    void searchTypeRooms() {
        Table table = new Table(new ArrayList<>());
        List<Box> roomList = table.searchType(kitchen);
        assertTrue(roomList.stream().allMatch(b -> b.getCard().getType() == CardType.ROOM));
    }

    @Test
    void initializeTableTwice() {
        List<Card> hand = List.of(missScarlett);
        Table table = new Table(hand);

        assertDoesNotThrow(() -> table.initializeTable(hand));

        long characterCount = Deck.getAllCards().stream()
                .filter(c -> c.getType() == CardType.CHARACTER).count();
        assertEquals(characterCount, table.searchType(missScarlett).size());
    }
}