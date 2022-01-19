package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;

public class ExitCommand extends ButtonCommand{
    protected ExitCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.setGameState(null);
    }
}
