package it.unibo.CluedoLite.model.GameBoard.impl;

import java.util.*;

import it.unibo.CluedoLite.model.GameBoard.api.GameBoardModel;
import it.unibo.CluedoLite.model.GameBoard.api.Room;
import it.unibo.CluedoLite.model.Player.impl.Player;

public class GameBoardModelImpl implements GameBoardModel{
    private final Map<Player,Room> playersposition=new HashMap<>();
    private final List<Room> rooms=new ArrayList<>();

    public GameBoardModelImpl(){

        rooms.add(new RoomImpl("Kitchen"));
        rooms.add(new RoomImpl("Ballroom"));
        rooms.add(new RoomImpl("Conservatory"));
        rooms.add(new RoomImpl("Billiard Room"));
        rooms.add(new RoomImpl("Library"));
        rooms.add(new RoomImpl("Study"));
        rooms.add(new RoomImpl("Hall"));
        rooms.add(new RoomImpl("Lounge"));
        rooms.add(new RoomImpl("Dining Room"));

        // automatically generates adjacencies in a circular order
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).addAdjacent(rooms.get((i + 1) % rooms.size()));
            rooms.get(i).addAdjacent(rooms.get((i - 1 + rooms.size()) % rooms.size()));
        }
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Room> getRooms() {
        return List.copyOf(rooms);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Room getRoomByName(String name) {
        return rooms.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Room getPlayerPosition(Player p) {
        return playersposition.get(p);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void setPlayerPosition(Player p,Room r){
        playersposition.put(p,r);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public boolean areAdjacent(Room r1, Room r2){
        return r1.getAdjacent().contains(r2);
    }
}
