package com.spaceinvaders.controller;

import com.spaceinvaders.Game;

import java.io.IOException;

public abstract class Controller <T>{
    public final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, long time) throws IOException;
}
