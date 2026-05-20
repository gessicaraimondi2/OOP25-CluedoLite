package it.unibo.CluedoLite.controller.gameboard.impl;

import it.unibo.CluedoLite.controller.gameboard.api.GameBoardController;
import it.unibo.CluedoLite.model.gameboard.api.GameBoardModel;
import it.unibo.CluedoLite.model.gameboard.api.Room;
import it.unibo.CluedoLite.model.player.api.Player;
import it.unibo.CluedoLite.model.turnmanager.api.TurnManager;
import it.unibo.CluedoLite.view.gameboard.api.Board;

public class GameBoardControllerImpl implements GameBoardController {

    private final GameBoardModel gb;
    private final TurnManager tm;
    private Board view;

    /** Stanza in cui il giocatore si trovava a inizio turno. Null al primissimo turno. */
    private Room turnStartRoom;

    /** True dopo che il giocatore ha fatto sospetto o accusa: blocca il movimento. */
    private boolean movementLocked;

    public GameBoardControllerImpl(final GameBoardModel gb, final TurnManager tm) {
        this.gb = gb;
        this.tm = tm;
        this.turnStartRoom   = null;
        this.movementLocked  = false;
    }

    @Override
    public void setView(final Board v) {
        this.view = v;
    }

    /**
     * Muove il giocatore corrente nella stanza {@code r}, rispettando queste regole:
     * <ul>
     *   <li>Se il movimento è bloccato (sospetto/accusa già fatti) non fa nulla.</li>
     *   <li>Se il giocatore è eliminato non fa nulla.</li>
     *   <li>Al primissimo turno (nessuna posizione) può scegliere qualsiasi stanza
     *       e quella diventa la {@code turnStartRoom}.</li>
     *   <li>Nei turni successivi può muoversi liberamente solo nella stanza di
     *       partenza del turno e nelle sue due adiacenti.</li>
     * </ul>
     */
    @Override
    public void move(final Room r) {
        if (r == null) return;

        final Player currentPlayer = tm.getCurrentPlayer();

        if (currentPlayer.isEliminated()) return;
        if (movementLocked) return;

        final Room currentPos = gb.getPlayerPosition(currentPlayer);

        // primo turno assoluto: nessuna posizione, qualsiasi stanza è valida
        if (currentPos == null) {
            gb.setPlayerPosition(currentPlayer, r);
            turnStartRoom = r;
            view.repaint();
            return;
        }

        // fissa la stanza di partenza al primo movimento del turno
        if (turnStartRoom == null) {
            turnStartRoom = currentPos;
        }

        // può muoversi solo nella stanza di partenza o nelle sue adiacenti
        if (r.equals(turnStartRoom) || turnStartRoom.getAdjacent().contains(r)) {
            gb.setPlayerPosition(currentPlayer, r);
            view.repaint();
        }
        // click su stanza non consentita: silenzioso, il giocatore riprova
    }

    
    @Override
    public void lockMovement() {
        movementLocked = true;
    }

    @Override
    public Player currentPlayer() {
        return tm.getCurrentPlayer();
    }

    @Override
    public Room getRoomByName(final String name) {
        return gb.getRoomByName(name);
    }

    @Override
    public Room getCurrentRoomOf(final Player p) {
        return gb.getPlayerPosition(p);
    }

    @Override
    public void endTurn() {
        turnStartRoom  = null;
        movementLocked = false;
        tm.nextTurn();
        view.repaint();
    }
}