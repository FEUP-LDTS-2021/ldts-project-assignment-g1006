package com.spaceinvaders.controller;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.viewer.ArenaViewer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ArenaController extends Controller<Arena> {
    private final PlayerController playerController;
    private final AlienController alienController;
    private final AmmoController ammoController;
    private final ArenaViewer arenaViewer;
    private final GUI gui;
    private boolean exit;

    public ArenaController(Arena model, GUI gui) {
        super(model);
        this.gui = gui;
        this.playerController = new PlayerController(getModel().getPlayer());
        this.alienController = new AlienController(getModel());
        this.ammoController = new AmmoController(getModel());
        this.arenaViewer = new ArenaViewer(gui, getModel());
        this.exit = false;
    }

    public ArenaController(Arena arena, ArenaViewer arenaViewer, GUI gui, PlayerController playerController, AlienController alienController, AmmoController ammoController) {
        super(arena);
        this.gui = gui;
        this.playerController = playerController;
        this.alienController = alienController;
        this.ammoController = ammoController;
        this.arenaViewer = arenaViewer;
        this.exit = false;
    }

    public boolean exit(){
        return this.exit;
    }

    @Override
    public void step() throws IOException {
        arenaViewer.draw();
        processAction(gui.getAction());
        alienController.step();
        ammoController.step();
        checkAlienProjectilesCollisions();
    }

    public void processAction(GUI.Action action){
        switch (action) {
            case EXIT -> this.exit = true;
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
                        it1.remove();
                        it2.remove();
                        break;
                    }
                }
            }
        }
    }
}
