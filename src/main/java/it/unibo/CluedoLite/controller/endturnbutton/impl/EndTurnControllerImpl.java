package it.unibo.CluedoLite.controller.endturnbutton.impl;

import it.unibo.CluedoLite.controller.endturnbutton.api.EndTurnController;

/**
 * Implementation of {@link EndTurnController}.
 * Delegates the end-turn logic to a {@link Runnable} provided at construction time,
 * keeping this controller decoupled from {@code GameController}.
 */
public class EndTurnControllerImpl implements EndTurnController {

    private final Runnable onEndTurn;

    /**
     * @param onEndTurn callback executed when the player ends their turn;
     *                  typically {@code GameController::advanceTurn}
     */
    public EndTurnControllerImpl(final Runnable onEndTurn) {
        this.onEndTurn = onEndTurn;
    }

    @Override
    public void onEndTurnClicked() {
        onEndTurn.run();
    }
}