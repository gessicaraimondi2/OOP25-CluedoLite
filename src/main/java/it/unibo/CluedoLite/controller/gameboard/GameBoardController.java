package it.unibo.CluedoLite.controller.gameboard;

import it.unibo.CluedoLite.model.gameBoard.api.Room;
import it.unibo.CluedoLite.model.gameBoard.impl.GameBoardModelImpl;
import it.unibo.CluedoLite.model.gameBoard.impl.RoomImpl;
import it.unibo.CluedoLite.model.player.api.Player;
import it.unibo.CluedoLite.model.player.impl.PlayerImpl;
import it.unibo.CluedoLite.model.turnmanager.impl.TurnManagerImpl;
import it.unibo.CluedoLite.view.gameboard.Board;

public class GameBoardController{
    GameBoardModelImpl gb;
    TurnManagerImpl tm;
    Board view;

    public GameBoardController(GameBoardModelImpl gb,TurnManagerImpl tm, Board v){
        this.gb=gb;
        this.tm=tm;
        this.view=v;
    }

    public void move(Room r){
        Player currentplayer=tm.getCurrentPlayer();
        
        if(gb.canMoveTo(currentplayer, r)){
            gb.setPlayerPosition(currentplayer,r);
            view.repaint();
        }else{
            view.wrongRoomSelected();
        }
    }

    public Room getRoomByName(String name) {
        return gb.getRoomByName(name);
    }

    public Room getCurrentRoomOf(Player p) {
        return gb.getPlayerPosition(p);
    }
}
