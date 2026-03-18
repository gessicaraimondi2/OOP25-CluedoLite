package it.unibo.CluedoLite.model.turnmanager.impl;

import java.util.*;

import it.unibo.CluedoLite.model.turnmanager.api.TurnManager;
import it.unibo.CluedoLite.model.Player.impl.Player;

/**
 * Implementation of the {@link TurnManager} interface.
 */

public class TurnManagerImpl implements TurnManager{

    private final List<Player> players;
    private int current_index;
/**
 * Constructs a TurnManager with the given list of players.
 * 
 * @param players the list of the players of the game
 * @throws IllegalArgumentException if the players list is null, has fewer than 3 or more than 6 players
 * 
 */
public TurnManagerImpl(List<Player> players){
        this.players=List.copyOf(players);
        this.current_index=0;
    } 

    /**
     * @return the current player
     */
    @Override
    public Player getCurrentPlayer(){
        return this.players.get(this.current_index);
    } 

     /**
     * @return the next player who will take the turn
     */
    @Override
    public Player nextTurn(){
        this.current_index=(this.current_index+1)%this.players.size();
        return this.players.get(this.current_index);
    }
} 
