package it.unibo.CluedoLite.model.Turnmanager.impl;

import java.util.List;

import it.unibo.CluedoLite.model.creationCards.Card;
import it.unibo.CluedoLite.model.Turnmanager.api.TurnManager;
import it.unibo.CluedoLite.model.AccuseAndSuspect.Suspicion;
import it.unibo.CluedoLite.model.Player.impl.Player;

/**
 * Implementation of the {@link TurnManager} interface.
 */

public class TurnManagerImpl implements TurnManager{

    private final List<Player> players;
    private int currentIndex;
    private boolean gameOver = false;

    public TurnManagerImpl(List<Player> players){
            this.players=List.copyOf(players);
            this.currentIndex=0;
    } 

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getCurrentPlayer(){
        return this.players.get(this.currentIndex);
    } 

    /**
     * {@inheritDoc}
     */
    @Override
    public void endGame() {
        this.gameOver = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player nextTurn(){
        if (this.gameOver) {
            throw new IllegalStateException("Non si puo proseguire:il gioco è gia finito");
        }
        this.currentIndex=(this.currentIndex+1)%this.players.size();
        return this.players.get(this.currentIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Card SuggestionResponse(Suspicion suspicion) {
        int suspectIndex = currentIndex;
        for (int i = 1; i < players.size(); i++) {
            Player respondent = players.get((suspectIndex + i) % players.size());
            Card cardToShow = respondent.findMatchingCard(suspicion.getCharacter(), suspicion.getWeapon(), suspicion.getRoom());

            if (cardToShow != null) {
                return cardToShow;
            }
        }
        return null;
    }
} 