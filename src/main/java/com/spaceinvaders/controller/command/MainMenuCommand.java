package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.menu.StartMenu;
import com.spaceinvaders.state.MenuState;

public class MainMenuCommand extends ButtonCommand{
    public MainMenuCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.setGameState(new MenuState(new StartMenu(game), game.getGui()));
    }
}
