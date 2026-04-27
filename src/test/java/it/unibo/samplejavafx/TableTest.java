package it.unibo.samplejavafx;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.creationcards.impl.Card;
import it.unibo.CluedoLite.model.creationcards.impl.CardType;
import it.unibo.CluedoLite.model.gamesetup.impl.Deck;
import it.unibo.CluedoLite.model.suspectnotes.impl.*;
import it.unibo.CluedoLite.model.suspectnotes.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        BoxImpl box = new BoxImpl(missScarlett);
        assertEquals(State.POSSIBLE, box.getState());
    }

    @Test
    void excludeCard() {
        BoxImpl box = new BoxImpl(missScarlett);
        box.excludeCard();
        assertEquals(State.EXCLUDED, box.getState());
    }

    @Test
    void tableCreation() {
        TableImpl table = new TableImpl(new ArrayList<>());
        int deckSize = Deck.getAllCards().size(); // 21 cards
        int boxesNum = table.searchType(missScarlett).size() 
                     + table.searchType(candlestick).size() 
                     + table.searchType(kitchen).size(); 
        assertEquals(deckSize, boxesNum);
    }

    @Test
    void searchTypeCharacters() {
        TableImpl table = new TableImpl(new ArrayList<>());
        List<BoxImpl> characterList = table.searchType(missScarlett);
        assertTrue(characterList.stream().allMatch(b -> b.getCard().getType() == CardType.CHARACTER));
    }

    @Test
    void searchTypeWeapons() {
        TableImpl table = new TableImpl(new ArrayList<>());
        List<BoxImpl> weaponList = table.searchType(candlestick);
        assertTrue(weaponList.stream().allMatch(b -> b.getCard().getType() == CardType.WEAPON));
    }

    @Test
    void searchTypeRooms() {
        TableImpl table = new TableImpl(new ArrayList<>());
        List<BoxImpl> roomList = table.searchType(kitchen);
        assertTrue(roomList.stream().allMatch(b -> b.getCard().getType() == CardType.ROOM));
    }

    @Test
    void initializeTableTwice() {
        List<Card> hand = List.of(missScarlett);
        Table table = new TableImpl(hand);

        assertDoesNotThrow(() -> table.initializeTable(hand));

        long characterCount = Deck.getAllCards().stream()
                .filter(c -> c.getType() == CardType.CHARACTER).count();
        assertEquals(characterCount, table.searchType(missScarlett).size());
    }
}