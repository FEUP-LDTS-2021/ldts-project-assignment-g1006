package com.spaceinvaders.viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class ArenaViewerTest {
    ArenaViewer arenaViewer;
    Arena arena;
    GUI gui;

    @BeforeEach
    void setup() {
        this.gui = Mockito.mock(GUI.class);
        this.arena = new Arena(20,20);
        this.arena.setAliens(List.of(List.of(new Alien(0, 0,0))));
        this.arena.setPlayer(new Player(1,1));
        this.arena.setProjectiles(List.of(new Ammo(2,2, 1, 0)));
        this.arena.setWalls(List.of(new Wall(1,1,1)));
        this.arenaViewer = new ArenaViewer(gui, arena);
    }

    @Test
    void draw() throws IOException {
        arenaViewer.draw();

        Mockito.verify(gui, Mockito.times(1)).drawBackground();

        for (List<Alien> list : arena.getAliens()){
            for (Alien alien : list)
                if(alien.getArmor() == 0)
                    Mockito.verify(gui, Mockito.times(1)).drawNormalAlien(alien.getPosition());
                else
                    Mockito.verify(gui, Mockito.times(1)).drawArmoredAlien(alien.getPosition());
        }

        for (Ammo ammo : arena.getProjectiles()){
            Mockito.verify(gui, Mockito.times(1)).drawAmmo(ammo.getPosition());
        }

        for (Wall wall : arena.getWalls()){
            Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
        }

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(arena.getPlayer().getPosition());
    }
}
