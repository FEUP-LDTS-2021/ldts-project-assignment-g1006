package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;

import java.io.IOException;

public abstract class Viewer <T>{
    protected final GUI gui;
    protected final T model;

    public Viewer(T model, GUI gui){
        this.gui = gui;
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public GUI getGui() {
        return gui;
    }

    public abstract void draw() throws IOException;
}
