package com.spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.gui.*;

import java.util.Iterator;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Player player;
    private List<List<Alien>> aliens;
    private List<Ammo> projectiles;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<List<Alien>> getAliens() {
        return aliens;
    }

    public void setAliens(List<List<Alien>> aliens) {
        this.aliens = aliens;
    }

    public List<Ammo> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Ammo> projectiles) {
        this.projectiles = projectiles;
    }

    public void draw(LanternaGUI gui){
        TextGraphics tg = gui.createTextGraphics();
        gui.drawBackground(tg);
        for (Ammo ammo : projectiles)
            gui.drawAmmo(tg, ammo.getPosition());
        for (List<Alien> row : aliens) {
            for(Alien alien : row)
                gui.drawAlien(tg, alien.getPosition());
        }
        gui.drawPlayer(tg, player.getPosition());
    }

    public boolean checkProjectilesCollision(){
        return false;
    }

    public void processKey(GUI.Action action){
        switch (action) {
            case KEYLEFT -> player.moveLeft(this);
            case KEYRIGHT -> player.moveRight(this);
            case KEYUP -> player.shoot(this);
        }
    }

    public void checkAlienProjectilesCollisions(){
        for(List<Alien> row : aliens) {
            Iterator<Alien> it1 = row.iterator();
            while (it1.hasNext()) {
                Alien alien = it1.next();
                Iterator<Ammo> it2 = projectiles.iterator();
                while (it2.hasNext()) {
                    Ammo ammo = it2.next();
                    if (alien.getPosition().equals(ammo.getPosition())) {
                        it1.remove();
                        it2.remove();
                        break;
                    }
                }
            }
        }
    }
}
