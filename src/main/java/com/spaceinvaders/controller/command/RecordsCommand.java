package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.menu.RecordsMenu;
import com.spaceinvaders.state.RecordsMenuState;

public class RecordsCommand extends ButtonCommand{
    public RecordsCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.setGameState(new RecordsMenuState(new RecordsMenu(game), game.getGui()));
    }
}
