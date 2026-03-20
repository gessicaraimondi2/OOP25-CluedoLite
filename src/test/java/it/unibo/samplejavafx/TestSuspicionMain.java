/* 
package it.unibo.samplejavafx;

import it.unibo.CluedoLite.model.creationCards.Characters;
import it.unibo.CluedoLite.model.creationCards.Weapons;
import it.unibo.CluedoLite.view.SuspicionView;
import it.unibo.CluedoLite.model.GameSetUp.Deck;

import javax.swing.SwingUtilities;

public class TestSuspicionMain {
    public static void main(String[] args) {

        Deck deck = new Deck();

        // Filtra dal mazzo solo i personaggi
        Characters[] characters = deck.getCards().stream()
            .filter(c -> c instanceof Characters)
            .map(c -> (Characters) c)
            .toArray(Characters[]::new);

        // Filtra dal mazzo solo le armi
        Weapons[] weapons = deck.getCards().stream()
            .filter(c -> c instanceof Weapons)
            .map(c -> (Weapons) c)
            .toArray(Weapons[]::new);

        SwingUtilities.invokeLater(() -> {
            SuspicionView view = new SuspicionView(characters, weapons);
            view.setVisible(true);
        });
    }
}
*/