package it.unibo.CluedoLite.model.gameboard.api;

import java.util.*;

public interface Room {
    void addAdjacent(Room r);

    ArrayList<Room> getAdjacent();

    String getName();
}
