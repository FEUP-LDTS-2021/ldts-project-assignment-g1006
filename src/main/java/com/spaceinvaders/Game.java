package com.spaceinvaders;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private Arena arena;
    private LanternaGUI gui;
    private int width = 50;
    private int height = 25;

    private static Game singleton = null;

    private Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(width, height);
        this.arena = new Arena(width,height);
        setupArena(arena);
    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    private List<List<Alien>> createAliens(){
        List<List<Alien>> aliens = new ArrayList<>();
        //aliens.add(new com.spaceinvaders.Alien(5,5,'A'));
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


    private void setupArena(Arena arena){
        arena.setPlayer(new Player(5,15,'P'));
        arena.setProjectiles(createProjectiles());
        arena.setAliens(createAliens());
    }

    private void draw() throws IOException {
        gui.clear();
        arena.draw(gui);
        gui.refresh();
    }

    public void run() throws IOException {
        while(true) {
            GUI.Action action = gui.getAction();
            draw();
            if (action == GUI.Action.EXIT) {
                gui.close(); break;
            }
            arena.processKey(action);

            for (List<Alien> row : arena.getAliens()) {
                for(Alien alien : row)
                    alien.move(arena);
            }

            for(Ammo ammo : arena.getProjectiles()) {
                ammo.move();
            }

            arena.checkAlienProjectilesCollisions();

            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
