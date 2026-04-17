package it.unibo.CluedoLite.model.gameboard.impl;

import java.util.*;

import it.unibo.CluedoLite.model.gameboard.api.Room;

public class RoomImpl implements Room {
    private final String name;
    private final ArrayList<Room> adjacent = new ArrayList<>();

    public RoomImpl(String name) { 
        
        this.name = name; 
    }

    @Override
    public void addAdjacent(Room r) { 
        adjacent.add(r); 
    }

    @Override
    public ArrayList<Room> getAdjacent() { 
        return adjacent; 
    }

    @Override
    public String getName() { 
        return name; 
    }
}
