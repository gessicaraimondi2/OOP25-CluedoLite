package it.unibo.samplejavafx;

import java.util.ArrayList;
import java.util.List;

import it.unibo.CluedoLite.model.creationCards.*;
import it.unibo.CluedoLite.model.GameSetUp.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.unibo.CluedoLite.model.suspectNotes.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Test class for the Table class. 
 * Verifies the correct behavior of the table in its main operations: 
 * initialization, box state management and filtering by card type. 
 */

class TableTest {
    private static final Deck deck = Table.getDeck();
    private Characters missScarlett;
    private Weapons candlestick;
    private Rooms kitchen;


    // Before each test, takes one card from each category (character, 
    // weapon, and room) from the deck. 
    @BeforeEach
    void setUp() {
        missScarlett = (Characters) deck.getCards().stream()
                .filter(c -> c instanceof Characters)
                .findFirst()
                .orElseThrow();

        candlestick = (Weapons) deck.getCards().stream()
                .filter(c -> c instanceof Weapons)
                .findFirst()
                .orElseThrow();

        kitchen = (Rooms) deck.getCards().stream()
                .filter(c -> c instanceof Rooms)
                .findFirst()
                .orElseThrow();
    }
    
   // Checks that a newly created Box always starts from the POSSIBLE state. 
    @Test
    void defaultState() {
        Box box = new Box(missScarlett);
        assertEquals(State.POSSIBLE, box.getState());
    }

    // Checks that after excluding a card the Box switches to the EXCLUDED status.
    @Test
    void excludeCard() {
        Box box = new Box(missScarlett);
        box.excludeCard();
        assertEquals(State.EXCLUDED, box.getState());
    }

    // Checks that the total number of Boxes in a table matches the number 
    // of cards in the deck.
    @Test
    void tableCreation() {
        Table table = new Table(new ArrayList<>());
        int deckSize = deck.getCards().size(); // 21 cards
        int boxesNum = table.searchType(missScarlett).size() 
        + table.searchType(candlestick).size() 
        + table.searchType(kitchen).size(); 
        assertEquals(deckSize, boxesNum); // The sum of all three lists must 
                                          // equal the total deck size

    }

    // Checks that the type search returns only boxes that contain cards of type Characters.
    @Test
    void searchTypeCharacters() {
        Table table = new Table(new ArrayList<>());
        List<Box> characterList = table.searchType(missScarlett);
        assertTrue(characterList.stream().allMatch(b -> b.getCard() instanceof Characters));
    }

    // Checks that the type search returns only boxes that contain cards of type Weapons.
    @Test
    void searchTypeWeapons() {
        Table table = new Table(new ArrayList<>());
        List<Box> weaponList = table.searchType(candlestick);
        assertTrue(weaponList.stream().allMatch(b -> b.getCard() instanceof Weapons));
    }

    // Checks that the type search returns only boxes that contain cards of type Rooms.
    @Test
    void searchTypeRooms() {
        Table table = new Table(new ArrayList<>());
        List<Box> roomList = table.searchType(kitchen);
        assertTrue(roomList.stream().allMatch(b -> b.getCard() instanceof Rooms));
    }

    // Checks that calling initializeTable multiple times does not generate errors or 
    // alter the table structure. The number of boxes for each category must remain unchanged.
    @Test
    void initializeTableTwice() {
        List<Card> hand = List.of(missScarlett);
        Table table = new Table(hand);

        assertDoesNotThrow(() -> table.initializeTable(hand)); // does not generate errors 
                                                               // or corrupt the structure
        long characterCount = deck.getCards().stream()
                .filter(c -> c instanceof Characters).count();
        assertEquals(characterCount, table.searchType(missScarlett).size()); // the list size 
                                                                             // remains the same 
                                                                             // (no boxes added/removed)
    }

    // Checks that alreadyExcluded returns false for a POSSIBLE card and true for an EXCLUDED card
    @Test
    void alreadyExcluded(){
        Table emptyTable = new Table(new ArrayList<>());    // No cards in hand: all cards should start 
                                                            // as POSSIBLE
        Table handTable = new Table(List.of(missScarlett)); // Miss Scarlett in hand: this card is 
                                                            // marked as EXCLUDED
        assertFalse(emptyTable.alreadyExcluded(missScarlett),
         "card not in hand should be POSSIBLE");
        assertTrue(handTable.alreadyExcluded(missScarlett),
         "card in hand should be EXCLUDED");
    }
    // Checks that updateTable correctly marks the given card as EXCLUDED
    @Test
    void updateTable() {
        Table table = new Table(new ArrayList<>());
        table.updateTable(missScarlett);
        assertTrue(table.alreadyExcluded(missScarlett),
         "card should be EXCLUDED after updateTable");
    }
}