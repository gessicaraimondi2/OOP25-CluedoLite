/*
package it.unibo.samplejavafx;

import javax.swing.*;

import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.creationCards.impl.CardType;
import it.unibo.CluedoLite.model.gameSetUp.impl.Deck;
import it.unibo.CluedoLite.controller.SuspicionController;
import it.unibo.CluedoLite.model.accuseAndSuspect.impl.SuspicionManager;
import it.unibo.CluedoLite.model.accuseAndSuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.player.impl.Player;
import it.unibo.CluedoLite.view.suspicionView.ButtonSuspicionView;
*/
/**
 * Manual test class for the suspicion phase of CluedoLite.
 * This class tests both the MODEL layer directly and the full MVC flow visually.
 *
 * It is divided into two independent test sections:
 *
 * TEST 1 - Model test (automated, console output):
 *   Verifies that {@link SuspicionManager} correctly creates {@link Suspicion} objects
 *   and handles edge cases (e.g. null room) without involving any view or controller.
 *   Results are printed to console as PASS/FAIL.
 *
 * TEST 2 - Visual MVC test (manual, UI interaction):
 *   Opens a game screen with the suspicion button visible.
 *   The tester clicks the button, selects a character and weapon, and confirms.
 *   The resulting {@link Suspicion} is printed to console, verifying that the full
 *   MVC flow works correctly: button -> controller -> view -> model -> callback.
 */
/*
public class TestSuspicionView {

    public static void main(String[] args) {

        // TEST 1: direct model verification (no UI)
        System.out.println("TEST 1: MODEL");

        // Retrieve real cards from the Deck to use as test data
        Card[] characters = Deck.getCardsByType(CardType.CHARACTER).toArray(new Card[0]);
        Card[] weapons = Deck.getCardsByType(CardType.WEAPON).toArray(new Card[0]);
        Card room = Deck.getCardsByType(CardType.ROOM).get(0);
        Player testPlayer = new Player("TestPlayer");

        SuspicionManager manager = new SuspicionManager();

        // Test 1a: valid data, makeSuspicion must return a non-null Suspicion
        Suspicion suspicion = manager.makeSuspicion(testPlayer, characters[0], weapons[0], room);
        System.out.println("Test 1a - Suspicion not null: " + (suspicion != null ? "PASS" : "FAIL"));

        // Test the Suspicion must contain exactly the data that was passed in
        if (suspicion != null) {
            boolean charOk = suspicion.getCharacters().equals(characters[0]);
            boolean weaponOk = suspicion.getWeapon().equals(weapons[0]);
            boolean roomOk = suspicion.getRoom().equals(room);
            System.out.println("Test 1b - Character correct: " + (charOk ? "PASS" : "FAIL"));
            System.out.println("Test 1c - Weapon correct:    " + (weaponOk ? "PASS" : "FAIL"));
            System.out.println("Test 1d - Room correct:      " + (roomOk ? "PASS" : "FAIL"));
            // Print the full toString to visually verify the suspicion content
            System.out.println("Suspicion toString: " + suspicion);
        }

        // Test null room, makeSuspicion must return null (player not in a room)
        Suspicion nullSuspicion = manager.makeSuspicion(testPlayer, characters[0], weapons[0], null);
        System.out.println("Test 1e - Null room returns null: " + (nullSuspicion == null ? "PASS" : "FAIL"));

        System.out.println("=== END TEST 1 ===\n");

        // TEST 2: full MVC visual test (manual interaction)
        // All Swing operations must run on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {

            /**
             * Create the SuspicionController with all required data.
             * The callback prints the confirmed Suspicion to console,
             * allowing the tester to verify that the correct data
             * flowed through the entire MVC chain:
             * ButtonSuspicionView -> SuspicionController -> SuspicionView -> SuspicionManager -> callback
             */
            /*
            SuspicionController controller = new SuspicionController(
                new SuspicionManager(),
                testPlayer,
                characters,
                weapons,
                room,
                result -> {
                    // This callback is triggered when the player clicks "Confirm your Suspicion"
                    // Verify that the Suspicion contains the correct data selected in the UI
                    System.out.println("TEST 2: Suspicion confirmed from UI");
                    System.out.println("Character: " + result.getCharacters().getName());
                    System.out.println("Weapon:    " + result.getWeapon().getName());
                    System.out.println("Room:      " + result.getRoom().getName());
                    System.out.println("toString:  " + result);
                }
            );

            // Main test window simulating the game screen
            // Contains the ButtonSuspicionView which is always visible during the game
            JFrame testFrame = new JFrame("Test - Suspicion Button");
            testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            testFrame.setSize(300, 150);
            testFrame.setLocationRelativeTo(null);

            // Add the suspicion button panel to the test frame
            testFrame.add(new ButtonSuspicionView(controller));
            testFrame.setVisible(true);
        });
    }
}
*/