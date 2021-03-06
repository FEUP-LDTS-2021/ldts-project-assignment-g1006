package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.*;
import com.spaceinvaders.model.menu.GameOverMenu;
import com.spaceinvaders.model.menu.GameWonMenu;
import com.spaceinvaders.state.GameOverState;
import com.spaceinvaders.state.GameWonState;
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
    private long startTime;

    public ArenaController(Arena model, GUI gui) {
        super(model);
        this.gui = gui;
        setPlayerController(new PlayerController(getModel().getPlayer()));
        setAlienController(new AlienController(getModel()));
        setAmmoController(new AmmoController(getModel()));
        setArenaViewer(new ArenaViewer(gui, getModel()));
        this.startTime = -1;
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

    void exit(Game game, long time, boolean win){
        long finalTime = time - startTime;
        if (win) game.setGameState(new GameWonState(new GameWonMenu(game, finalTime), gui));
        else game.setGameState(new GameOverState(new GameOverMenu(game, finalTime), gui));
    }

    @Override
    public void step(Game game, long time) throws IOException {
        if (startTime<0) this.startTime = time;
        arenaViewer.draw();
        processAction(game, gui.getAction());
        for (List<Alien> aliensRow : getModel().getAliens()) {
            for (Alien alien : aliensRow) {
                int shootingProbability = (int)Math.floor(Math.random() * (300 - 1) + 0);
                if(shootingProbability == 0) {
                    Ammo ammo = alienController.shoot(alien);
                    if(ammo != null)
                        getModel().getProjectiles().add(ammo);
                }
            }
        }
        alienController.step(game, time);
        ammoController.step(game, time);
        checkAlienProjectilesCollisions();
        checkWallProjectilesCollisions();
        checkProjectilesOutOfBounds();
        if (checkProjectilesPlayerCollisions()) exit(game, time, false);
        if (getModel().allAliensDead()) exit(game, time, true);
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
            case KEYUP -> {
                if(getModel().getProjectiles().size() <= 1)
                    getModel().getProjectiles().add(playerController.shoot());
            }
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
                            if(ammo.getDamage() <= 0)
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

    public void checkProjectilesOutOfBounds(){
        for (int i = getModel().getProjectiles().size() - 1; i >= 0; i--) {
            Ammo ammo = getModel().getProjectiles().get(i);
            if(ammo.getPosition().getX() > getModel().getWidth()-1 || ammo.getPosition().getX() < 0 || ammo.getPosition().getY() > 20 || ammo.getPosition().getY() < 0)
                getModel().getProjectiles().remove(i);
        }
    }

    public boolean checkProjectilesPlayerCollisions(){
        for (int i = getModel().getProjectiles().size() - 1; i >= 0; i--) {
            Ammo ammo = getModel().getProjectiles().get(i);
            if(ammo.getPosition().equals(getModel().getPlayer().getPosition())){
                getModel().getProjectiles().remove(i);
                getModel().getPlayer().setHealth(getModel().getPlayer().getHealth() - ammo.getDamage());
                if(getModel().getPlayer().getHealth() <= 0){
                    return true;
                }
            }
        }
        return false;
    }
}
