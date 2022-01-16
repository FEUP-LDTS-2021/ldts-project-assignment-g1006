package com.spaceinvaders.controller;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.viewer.ArenaViewer;

public class ArenaController extends Controller<Arena> {
    private final PlayerController playerController;
    private final AlienController alienController;
    private final ArenaViewer arenaViewer;
    private final GUI gui;

    public ArenaController(Arena model, GUI gui) {
        super(model);
        this.gui = gui;
        this.playerController = new PlayerController(getModel().getPlayer());
        this.alienController = new AlienController(getModel());
        this.arenaViewer = new ArenaViewer(gui, getModel());
    }

    public ArenaController(Arena arena, ArenaViewer arenaViewer, GUI gui, PlayerController playerController, AlienController alienController) {
        super(arena);
        this.gui = gui;
        this.playerController = playerController;
        this.alienController = alienController;
        this.arenaViewer = arenaViewer;
    }

    @Override
    public void step() {

    }

    public void processAction(GUI.Action action){

    }

    public boolean checkLimits(Position position){
        return false;
    }

    public void checkAlienProjectilesCollisions(){

    }
}
