package com.spaceinvaders.controller;

import java.io.IOException;

public abstract class Controller <T>{
    public final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step() throws IOException;
}
