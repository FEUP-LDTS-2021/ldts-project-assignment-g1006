package com.spaceinvaders.state;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.gui.GUI;

import java.io.IOException;

public abstract class GameState<T> {
    protected GUI gui;
    private final T model;
    private final Controller<T> controller;

    public GameState(T model, GUI gui){
        this.gui = gui;
        this.model = model;
        this.controller = getController();
    }

    public T getModel() {
        return model;
    }

    public void step(Game game, long time) throws IOException {
        controller.step(game, time);
    }

    protected abstract Controller<T> getController();
}
