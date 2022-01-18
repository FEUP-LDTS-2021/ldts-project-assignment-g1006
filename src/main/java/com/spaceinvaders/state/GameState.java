package com.spaceinvaders.state;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.Controller;

import java.io.IOException;

public abstract class GameState<T> {
    private final T model;
    private final Controller<T> controller;

    public GameState(T model){
        this.model = model;
        this.controller = getController();
    }

    public T getModel() {
        return null;
    }

    public void step(Game game, long time) throws IOException {

    }

    protected abstract Controller<T> getController();
}
