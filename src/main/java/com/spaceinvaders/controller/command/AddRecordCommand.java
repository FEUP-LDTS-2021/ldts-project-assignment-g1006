package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.InputDialog;
import com.spaceinvaders.model.menu.StartMenu;
import com.spaceinvaders.state.MenuState;

import java.io.FileNotFoundException;
import java.util.Locale;

public class AddRecordCommand extends ButtonCommand{
    private final int time;
    public AddRecordCommand(Game game, int time) {
        super(game);
        this.time = time;
    }

    @Override
    public void execute() {
        String name = new InputDialog().getString().toUpperCase(Locale.ROOT);
        try{ game.getRecordsManager().write(name, time);
        }catch (FileNotFoundException ignored){}
        game.setGameState(new MenuState(new StartMenu(game), game.getGui()));
    }
}
