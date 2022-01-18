package com.spaceinvaders.model;

import java.util.ArrayList;
import java.util.List;

public class ArenaBuilder {
    public Arena createArena(int width, int height){
        Arena arena = new Arena(width, height);
        arena.setAliens(createAliens());
        arena.setProjectiles(createProjectiles());
        arena.setPlayer(createPlayer());
        arena.setWalls(createWalls());
        return arena;
    }

    private List<List<Alien>> createAliens(){
        List<List<Alien>> aliens = new ArrayList<>();
        int numberOfRows = 3;
        int aliensPerRow = 6;
        int maxArmorLevel = 3;
        int minArmorLevel = 0;
        for(int i = 0; i < numberOfRows; i++){
            List<Alien> row = new ArrayList<>();
            for(int j = 0; j < aliensPerRow; j++){
                int armorLevel = (int)Math.floor(Math.random() * (maxArmorLevel - minArmorLevel + 1) + minArmorLevel);
                row.add(new Alien(j, i, armorLevel));
            }
            aliens.add(row);
        }
        return aliens;
    }


    private List<Ammo> createProjectiles(){
        List<Ammo> ammoList = new ArrayList<>();
        ammoList.add(new Ammo(5,5, 1,1));
        return ammoList;
    }

    private Player createPlayer(){
        return new Player(5,20,'P');
    }

    private List<Wall> createWalls(){
        int x = 10; int y = 17; int health = 2; int size = 3;
        List<Wall> walls = new ArrayList<>();
        while (x <= 40){
            for (int i = 0; i<size; i++)
                walls.add(new Wall(x+i, y, 'O', health));
            x += 10;
        }
        return walls;
    }
}
