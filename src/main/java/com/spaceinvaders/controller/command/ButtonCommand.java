package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;

public abstract class ButtonCommand {
    protected Game game;

    protected ButtonCommand(Game game){
        this.game = game;
    }

    public abstract void execute();
}
