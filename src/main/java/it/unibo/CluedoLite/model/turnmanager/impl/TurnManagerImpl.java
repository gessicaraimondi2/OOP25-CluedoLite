package it.unibo.CluedoLite.model.Turnmanager.impl;

import java.util.List;

import it.unibo.CluedoLite.model.Player.impl.Player;
import it.unibo.CluedoLite.model.Turnmanager.api.TurnManager;

/**
 * Implementation of the {@link TurnManager} interface.
 */

public class TurnManagerImpl implements TurnManager{

    private final List<Player> players;
    private int currentIndex;
    private boolean gameOver = false;
/**
 * Constructs a TurnManager with the given list of players.
 * 
 * @param players the list of the players of the game
 * 
 */
    public TurnManagerImpl(List<Player> players){
            this.players=List.copyOf(players);
            this.currentIndex=0;
    } 

    /**
     * @return the current player
     */
    @Override
    public Player getCurrentPlayer(){
        return this.players.get(this.currentIndex);
    } 

    /**
     * Marks the game as over, preventing further turn progression.
     */
    @Override
    public void endGame() {
        this.gameOver = true;
    }

    /**
     * @return true if the game has ended, false otherwise
     */
    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

     /**
     * @return the next player who will take the turn
     * @throws IllegalStateException if the game is already over
     */
    @Override
    public Player nextTurn(){
        if (this.gameOver) {
            throw new IllegalStateException("Non si puo proseguire:il gioco è gia finito");
        }
        this.currentIndex=(this.currentIndex+1)%this.players.size();
        return this.players.get(this.currentIndex);
    }
} 
