package it.unibo.CluedoLite.model.suspectNotes;

import java.util.ArrayList;
import java.util.List;
import it.unibo.CluedoLite.model.creationCards.*;
import it.unibo.CluedoLite.model.GameSetUp.*;

/*
 * Class representing the suspect notes table: it organizes all cards into boxes grouped by type
 */

public class Table {
    private List<Box> rooms = new ArrayList<>();
    private List<Box> characters = new ArrayList<>();
    private List<Box> weapons = new ArrayList<>();
    Deck deck = new Deck();

    // Builds the suspect notes table by creating a Box for each card and grouping them by type
    Table(Deck deck){
        for(Card name : deck.getCards()){      

            Box box = new Box(name);            
            
            if(name instanceof Characters){                      
                characters.add(box);
            }else if(name instanceof Weapons){
                weapons.add(box);
            }else{
                rooms.add(box);
            }
        }
    }

}


