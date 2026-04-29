package it.unibo.CluedoLite.controller.tablecontroller.impl;

import it.unibo.CluedoLite.model.accuseandsuspect.impl.Suspicion;
import it.unibo.CluedoLite.model.creationcards.impl.Card;
import it.unibo.CluedoLite.model.suspectnotes.api.Table;
import it.unibo.CluedoLite.model.turnmanager.api.TurnManager;
import it.unibo.CluedoLite.view.tableview.TablePanel;
import it.unibo.CluedoLite.controller.tablecontroller.api.TableController;

/*
 * Controller responsible for managing the suspicion phase.
 * It coordinates the model and the view when a suspicion is made.
 */
public class TableControllerImpl implements TableController {
    private final TurnManager turnManager;
    private final Table table;
    private final TablePanel tablePanel;

    public TableControllerImpl(TurnManager turnManager, Table table, TablePanel tablePanel) {
        this.turnManager = turnManager;
        this.table = table;
        this.tablePanel = tablePanel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleSuspicion(Suspicion suspicion) {
        Card card = turnManager.checkSuspicion(suspicion);
        if (card != null) {
            table.updateTable(card);
            tablePanel.refresh(card);
        }
    }
}