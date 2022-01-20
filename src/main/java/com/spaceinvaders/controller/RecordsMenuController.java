package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.viewer.menu.RecordsMenuViewer;

import java.io.IOException;

public class RecordsMenuController extends Controller<Menu>{
    private RecordsMenuViewer viewer;
    private GUI gui;

    public RecordsMenuController(Menu model, GUI gui) {
        super(model);
        this.gui = gui;
        this.viewer = new RecordsMenuViewer(getModel(), gui);
    }

    @Override
    public void step(Game game, long time) throws IOException {
        viewer.draw();
        GUI.Action action = gui.getAction();
        switch (action){
            case KEYRIGHT -> getModel().nextButton();
            case KEYLEFT -> getModel().previousButton();
            case ENTER -> getModel().getSelectedButton().click();
            case EXIT -> game.setGameState(null);
        }
    }
}
