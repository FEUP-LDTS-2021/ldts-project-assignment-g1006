package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.command.AddRecordCommand;
import com.spaceinvaders.controller.command.ExitCommand;
import com.spaceinvaders.controller.command.PlayCommand;
import com.spaceinvaders.model.Position;

public class GameOverMenu extends Menu{
    public GameOverMenu(Game game) {
        super(game);
        Button play = new Button("Retry", "#003399", new Position(15, 10), new Position(25, 12));
        Button addRecord = new Button("Add Record", "#003399", new Position(15, 14), new Position(25, 16));
        Button exit = new Button("Exit", "#003399", new Position(15, 18), new Position(25, 20));
        play.setCommand(new PlayCommand(game));
        addRecord.setCommand(new AddRecordCommand(game));
        exit.setCommand(new ExitCommand(game));
        getButtons().add(play);
        getButtons().add(addRecord);
        getButtons().add(exit);
        setSelected(0);
        getButtons().get(0).setHighlight(true);
    }
}
