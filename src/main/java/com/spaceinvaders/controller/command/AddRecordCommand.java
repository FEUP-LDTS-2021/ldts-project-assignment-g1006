package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.InputDialog;
import com.spaceinvaders.model.menu.StartMenu;
import com.spaceinvaders.state.MenuState;

public class AddRecordCommand extends ButtonCommand{
    private String time;
    public AddRecordCommand(Game game, String time) {
        super(game);
        this.time = time;
    }

    @Override
    public void execute() {
        String name = new InputDialog().getString();
        game.setGameState(new MenuState(new StartMenu(game), game.getGui()));
    }
}
