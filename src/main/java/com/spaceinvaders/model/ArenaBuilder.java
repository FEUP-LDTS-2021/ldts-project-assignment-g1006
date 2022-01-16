package com.spaceinvaders.model;

import java.util.ArrayList;
import java.util.List;

public class ArenaBuilder {
    public Arena createArena(int width, int height){
        Arena arena = new Arena(width, height);
        arena.setAliens(createAliens());
        arena.setProjectiles(createProjectiles());
        arena.setPlayer(createPlayer());
        return arena;
    }

    private List<List<Alien>> createAliens(){
        List<List<Alien>> aliens = new ArrayList<>();
        int numberOfRows = 3;
        int aliensPerRow = 6;
        for(int i = 0; i < numberOfRows; i++){
            List<Alien> row = new ArrayList<>();
            for(int j = 0; j < aliensPerRow; j++){
                row.add(new Alien(j, i, 'A'));
            }
            aliens.add(row);
        }
        return aliens;
    }


    private List<Ammo> createProjectiles(){
        List<Ammo> ammoList = new ArrayList<>();
        ammoList.add(new Ammo(5,5,'|',1,1));
        return ammoList;
    }

    private Player createPlayer(){
        return new Player(5,15,'P');
    }
}
