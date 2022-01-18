package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.*;
import com.spaceinvaders.viewer.ArenaViewer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ArenaController extends Controller<Arena> {
    private PlayerController playerController;
    private AlienController alienController;
    private AmmoController ammoController;
    private ArenaViewer arenaViewer;
    private final GUI gui;

    public ArenaController(Arena model, GUI gui) {
        super(model);
        this.gui = gui;
        setPlayerController(new PlayerController(getModel().getPlayer()));
        setAlienController(new AlienController(getModel()));
        setAmmoController(new AmmoController(getModel()));
        setArenaViewer(new ArenaViewer(gui, getModel()));
    }

    public AlienController getAlienController() {
        return alienController;
    }

    public AmmoController getAmmoController() {
        return ammoController;
    }

    public ArenaViewer getArenaViewer() {
        return arenaViewer;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setAlienController(AlienController alienController){
        this.alienController = alienController;
    }

    public void setAmmoController(AmmoController ammoController) {
        this.ammoController = ammoController;
    }

    public void setArenaViewer(ArenaViewer arenaViewer) {
        this.arenaViewer = arenaViewer;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    @Override
    public void step(Game game, long time) throws IOException {
        arenaViewer.draw();
        processAction(game, gui.getAction());
        alienController.step(game, time);
        ammoController.step(game, time);
        checkAlienProjectilesCollisions();
        checkWallProjectilesCollisions();
    }

    public void processAction(Game game, GUI.Action action){
        switch (action) {
            case EXIT -> game.setGameState(null);
            case KEYLEFT -> {
                Position newPos = playerController.moveLeft();
                if(checkLimits(newPos)) playerController.move(newPos);
            }
            case KEYRIGHT -> {
                Position newPos = playerController.moveRight();
                if(checkLimits(newPos)) playerController.move(newPos);
            }
            case KEYUP -> getModel().getProjectiles().add(playerController.shoot());
        }
    }

    public boolean checkLimits(Position position){
        return position.getX() >= 0 && position.getX() < getModel().getWidth();
    }

    public void checkAlienProjectilesCollisions(){
        for(List<Alien> row : getModel().getAliens()) {
            Iterator<Alien> it1 = row.iterator();
            while (it1.hasNext()) {
                Alien alien = it1.next();
                Iterator<Ammo> it2 = getModel().getProjectiles().iterator();
                while (it2.hasNext()) {
                    Ammo ammo = it2.next();
                    if (alien.getPosition().equals(ammo.getPosition())) {
                        alien.handleShot(ammo);
                        if(alien.isDead()){
                            it1.remove();
                            it2.remove();
                        }
                        break;
                    }
                }
            }
        }
    }

    public void checkWallProjectilesCollisions(){
        for (int i = getModel().getWalls().size() - 1; i >= 0; i--) {
            Wall wall = getModel().getWalls().get(i);
            for (int j = getModel().getProjectiles().size() - 1; j >= 0; j--){
                Ammo ammo = getModel().getProjectiles().get(j);
                if (ammo.getPosition().equals(wall.getPosition())) {
                    wall.decreaseHealth(ammo.getDamage());
                    if (wall.getHealth() <= 0)
                        getModel().getWalls().remove(i);
                    getModel().getProjectiles().remove(j);
                }
            }
        }
    }
}
