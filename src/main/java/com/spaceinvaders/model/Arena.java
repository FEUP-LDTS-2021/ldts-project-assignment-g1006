package com.spaceinvaders.model;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
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

}
