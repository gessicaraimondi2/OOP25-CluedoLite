package it.unibo.CluedoLite.model.turnmanager.impl;

import java.util.List;

import it.unibo.CluedoLite.model.creationCards.impl.Card;
import it.unibo.CluedoLite.model.turnmanager.api.turnManager;
import it.unibo.CluedoLite.model.accuseAndSuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;

/**
 * Implementation of the {@link turnManager} interface.
 */

public class TurnManagerImpl implements turnManager{

    private final List<PlayerImpl> players;
    private int currentIndex;
    private boolean gameOver = false;

    public TurnManagerImpl(List<PlayerImpl> players){
            this.players=List.copyOf(players);
            this.currentIndex=0;
    } 

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerImpl getCurrentPlayer(){
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
    public PlayerImpl nextTurn(){
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
            PlayerImpl respondent = players.get((suspectIndex + i) % players.size());
            Card cardToShow = respondent.findMatchingCard(suspicion.getCharacters(), suspicion.getWeapon(), suspicion.getRoom());

            if (cardToShow != null) {
                return cardToShow;
            }
        }
        return null;
    }
} 