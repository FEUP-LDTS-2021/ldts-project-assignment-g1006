package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.*;
import com.spaceinvaders.viewer.ArenaViewer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private PlayerController playerController;
    private AlienController alienController;
    private AmmoController ammoController;
    private ArenaViewer arenaViewer;
    private GUI gui;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setup(){
        this.arena = Mockito.mock(Arena.class);
        this.game = Mockito.mock(Game.class);
        Mockito.when(arena.getWidth()).thenReturn(20);
        Player player = Mockito.mock(Player.class);
        Mockito.when(arena.getPlayer()).thenReturn(player);
        this.gui = Mockito.mock(GUI.class);
        this.playerController = Mockito.mock(PlayerController.class);
        this.arenaViewer = Mockito.mock(ArenaViewer.class);
        this.alienController = Mockito.mock(AlienController.class);
        this.ammoController = Mockito.mock(AmmoController.class);

        this.arenaController = new ArenaController(arena, gui);
        arenaController.setAlienController(alienController);
        arenaController.setAmmoController(ammoController);
        arenaController.setArenaViewer(arenaViewer);
        arenaController.setPlayerController(playerController);
    }

    @Test
    void getArenaViewer(){
        Assertions.assertEquals(arenaController.getArenaViewer(), arenaViewer);
    }

    @Test
    void getAmmoController(){
        Assertions.assertEquals(arenaController.getAmmoController(), ammoController);
    }

    @Test
    void getAlienController(){
        Assertions.assertEquals(arenaController.getAlienController(), alienController);
    }

    @Test
    void getPlayerController(){
        Assertions.assertEquals(arenaController.getPlayerController(), playerController);
    }

    @Test
    void setArenaViewer() {
        arenaController.setArenaViewer(arenaViewer);
        Assertions.assertEquals(arenaController.getArenaViewer(), arenaViewer);
    }

    @Test
    void setAmmoController() {
        arenaController.setAmmoController(ammoController);
        Assertions.assertEquals(arenaController.getAmmoController(), ammoController);
    }

    @Test
    void setAlienController() {
        arenaController.setAlienController(alienController);
        Assertions.assertEquals(arenaController.getAlienController(), alienController);
    }

    @Test
    void setPlayerController() {
        arenaController.setPlayerController(playerController);
        Assertions.assertEquals(arenaController.getPlayerController(), playerController);
    }

    @Test
    void step() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.NONE);

        arenaController.step(game, 0);

        Mockito.verify(alienController, Mockito.times(1)).step(game, 0);
        Mockito.verify(ammoController, Mockito.times(1)).step(game, 0);
        Mockito.verify(arenaViewer, Mockito.times(1)).draw();
    }

    @Test
    void processActionKeyRight(){
        Position position = new Position(10,10);
        Mockito.when(playerController.moveRight()).thenReturn(position);

        arenaController.processAction(GUI.Action.KEYRIGHT);

        Mockito.verify(playerController, Mockito.times(1)).moveRight();
        Mockito.verify(playerController, Mockito.times(1)).move(position);
    }

    @Test
    void processActionKeyLeft(){
        Position position = new Position(10,10);
        Mockito.when(playerController.moveLeft()).thenReturn(position);

        arenaController.processAction(GUI.Action.KEYLEFT);

        Mockito.verify(playerController, Mockito.times(1)).moveLeft();
        Mockito.verify(playerController, Mockito.times(1)).move(position);
    }

    @Test
    void processActionKeyRightLimit(){
        Position position = new Position(20,10);
        Mockito.when(playerController.moveRight()).thenReturn(position);

        arenaController.processAction(GUI.Action.KEYRIGHT);

        Mockito.verify(playerController, Mockito.times(1)).moveRight();
        Mockito.verify(playerController, Mockito.times(0)).move(position);
    }

    @Test
    void processActionKeyLeftLimit(){
        Position position = new Position(-1,10);
        Mockito.when(playerController.moveLeft()).thenReturn(position);

        arenaController.processAction(GUI.Action.KEYLEFT);

        Mockito.verify(playerController, Mockito.times(1)).moveLeft();
        Mockito.verify(playerController, Mockito.times(0)).move(position);
    }

    @Test
    void processActionKeyUp(){
        arenaController.processAction(GUI.Action.KEYUP);

        Mockito.when(arena.getProjectiles()).thenReturn(new ArrayList<>());
        Mockito.verify(playerController, Mockito.times(1)).shoot();
    }

    @Test
    void checkLimits(){
        Assertions.assertFalse(arenaController.checkLimits(new Position(20, 10)));
        Assertions.assertFalse(arenaController.checkLimits(new Position(-1, 10)));
        Assertions.assertTrue(arenaController.checkLimits(new Position(0, 10)));
        Assertions.assertTrue(arenaController.checkLimits(new Position(19, 10)));
    }

    @Test
    void checkAlienProjectilesCollisions(){
        Arena arena = new Arena(40, 20);
        Alien alien = new Alien(10,14,'A',0);
        Ammo ammo = new Ammo(10,14,'|', -1, 1);

        List<List<Alien>> aliens = new ArrayList<>(new ArrayList<>());
        List<Alien> listAlien = new ArrayList<>();
        listAlien.add(alien);
        aliens.add(listAlien);

        List<Ammo> projectiles = new ArrayList<>();
        projectiles.add(ammo);

        arena.setAliens(aliens);
        arena.setProjectiles(projectiles);

        ArenaController arenaController = new ArenaController(arena, gui);

        arenaController.checkAlienProjectilesCollisions();

        Assertions.assertTrue(alien.isDead());


        alien.setArmor(1);
        aliens = List.of(List.of(alien));
        projectiles = List.of(ammo);
        arena.setAliens(aliens);
        arena.setProjectiles(projectiles);

        arenaController.checkAlienProjectilesCollisions();

        Assertions.assertFalse(alien.isDead());
        Assertions.assertEquals(alien.getArmor(),0);
        Assertions.assertEquals(ammo.getDirection(),1);
    }

    @Test
    void checkWallProjectilesCollisions() {
        Arena arena = new Arena(40, 20);
        Wall wall = new Wall(1, 1, 'O', 1);
        Ammo ammo = new Ammo(1, 1, '|', 1, 1);

        List<Ammo> projectiles = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();
        walls.add(wall);
        projectiles.add(ammo);

        arena.setWalls(walls);
        arena.setProjectiles(projectiles);
        ArenaController arenaController = new ArenaController(arena, gui);
        
        arenaController.checkWallProjectilesCollisions();

        Assertions.assertEquals(walls.size(), 0);
        Assertions.assertEquals(projectiles.size(), 0);
    }
}
