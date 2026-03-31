package it.unibo.CluedoLite.view.gameboard;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import it.unibo.CluedoLite.controller.gameboard.GameBoardController;
import it.unibo.CluedoLite.model.creationCards.impl.Rooms;
import it.unibo.CluedoLite.model.gameBoard.api.Room;
import it.unibo.CluedoLite.model.player.api.Player;


public class Board extends JPanel{
    private List<Player> players = new ArrayList<>();
    private Image backgroundImg;
    private int activePlayerIndex = 0;
    private Map<RoomView, Image> roomImages = new HashMap<>();
    private GameBoardController controller;

    public Board(List<Player> p, GameBoardController c){
        this.controller=c;

        try {
            backgroundImg = ImageIO.read(new File("floor.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        for(RoomView r : RoomView.values()) {
            try {
                roomImages.put(r, ImageIO.read(new File(r.imagePath)));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        this.players=p;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getPoint());
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //pulisce il pannello prima di ridisegnare 
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), null);
        drawRooms(g2);
        drawCenter(g2);
        drawPlayers(g2);
    }

    public void drawRooms(Graphics2D g2){
        for(RoomView r : RoomView.values()){
            
            int x = (int)(r.x * getWidth());
            int y = (int)(r.y * getHeight());
            int w = (int)(r.width * getWidth());
            int h = (int)(r.height * getHeight());
            
            g2.setColor(Color.PINK);
            g2.fillRect(x, y, w, h); //colora l'interno

            Image img = roomImages.get(r);
            if(img != null) {
                g2.drawImage(img, x, y, w, h, null);
            }

            g2.setFont(new Font("Serif", Font.BOLD, (int)(getWidth() * 0.018)));
            FontMetrics fm = g2.getFontMetrics();
            int tx = x + (w - fm.stringWidth(r.name)) / 2;
            int ty = y + fm.getAscent() + 5;

            // sfondo semitrasparente dietro il nome
            g2.setColor(new Color(0, 0, 0, 100));
            g2.fillRect(x, y, w, fm.getHeight() + 8);

            // ombra testo
            g2.setColor(new Color(0, 0, 0, 150));
            g2.drawString(r.name, tx + 2, ty + 2);

            // testo bianco
            g2.setColor(Color.WHITE);
            g2.drawString(r.name, tx, ty);
        }
    }

    public void drawCenter(Graphics2D g2){
        Rectangle r = getCenterRect();

        g2.setFont(new Font("Serif", Font.BOLD, (int)(getWidth() * 0.05)));
        FontMetrics fm = g2.getFontMetrics();

        // Prima riga - "Cluedo"
        int cluedoX = r.x + (r.width - fm.stringWidth("CLUEDO")) / 2;
        int cluedoY = r.y + (r.height / 2);
        // ombra
        g2.setColor(new Color(0, 0, 0, 150)); // nero semitrasparente
        g2.drawString("CLUEDO", cluedoX + 2, cluedoY + 2);

        // testo vero
        g2.setColor(Color.WHITE);
        g2.drawString("CLUEDO", cluedoX, cluedoY);

        // Seconda riga - "Lite" con font più piccolo
        g2.setFont(new Font("Serif", Font.BOLD, (int)(getWidth() * 0.03)));
        fm = g2.getFontMetrics();
        int liteX = r.x + (r.width - fm.stringWidth("Lite")) / 2;
        int liteY = cluedoY + fm.getHeight();
        // ombra
        g2.setColor(new Color(0, 0, 0, 150)); // nero semitrasparente
        g2.drawString("Lite", liteX + 2, liteY + 2);

        // testo vero
        g2.setColor(Color.WHITE);
        g2.drawString("Lite", liteX, liteY);
    }

    public void drawPlayers(Graphics2D g2){
        int size = (int)(Math.min(getWidth(), getHeight()) * 0.025);
        int padding = (int)(getWidth() * 0.01);
        int centerIndex = 0;

        for(Player p: players){
            Room currentRoom = controller.getCurrentRoomOf(p);
            if (currentRoom == null) {
                Rectangle cr = getCenterRect();
                int x = cr.x + padding + centerIndex * (size + padding);
                int y = cr.y + cr.height + padding;
                drawToken(g2, p, x, y, size);
                centerIndex++;
            } else {
                RoomView r = RoomView.fromName(currentRoom.getName());
                int roomIndex = 0;
                int count = 0;
                for (Player other : players) {
                    if (controller.getCurrentRoomOf(other) == currentRoom) {
                        if (other == p) roomIndex = count;
                        count++;
                    }
                }
                int cx = (int)(r.x * getWidth()) + padding;
                int cy = (int)(r.y * getHeight()) + (int)(r.height * getHeight()) / 2;
                int x = cx + (roomIndex % 2) * (size + padding);
                int y = cy + (roomIndex / 2) * (size + padding);
                drawToken(g2, p, x, y, size);
            }

        }
    }

    private void handleClick(Point p) {
        for (RoomView r : RoomView.values()) {
             if (r.toRect(getWidth(), getHeight()).contains(p)) {
                controller.move(controller.getRoomByName(r.name));
                activePlayerIndex = (activePlayerIndex + 1) % players.size();
                repaint();//ridisegna il pannello con il nuovo stato
                return;
            }
        }
    }

    private Rectangle getCenterRect() {
        int w = (int)(getWidth() * 0.20);
        int h = (int)(getHeight() * 0.15);
        int x = (getWidth() - w) / 2;
        int y = (getHeight() - h) / 2;
        return new Rectangle(x, y, w, h);
    }

    private void drawToken(Graphics2D g2, Player p, int x, int y, int size) {
        g2.setColor(Color.decode(p.getCharacter().getColor())); // trasforma nel formato "#FF0000"
        g2.fillOval(x, y, size, size);
        if (p == players.get(activePlayerIndex)) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(3f));
            g2.drawOval(x, y, size, size);
        }
    }
}