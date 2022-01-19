package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.command.AddRecordCommand;
import com.spaceinvaders.controller.command.ExitCommand;
import com.spaceinvaders.controller.command.PlayCommand;
import com.spaceinvaders.model.Position;

public class GameOverMenu extends Menu{
    public GameOverMenu(Game game) {
        super(game);
        Button play = new Button("Retry", "#003399", new Position(3, 18), new Position(14, 20));
        Button addRecord = new Button("Add Record", "#003399", new Position(29, 18), new Position(40, 20));
        Button mainMenu = new Button("Main Menu", "#003399", new Position(16, 18), new Position(27, 20));
        play.setCommand(new PlayCommand(game));
        addRecord.setCommand(new AddRecordCommand(game));
        mainMenu.setCommand(new ExitCommand(game));
        getButtons().add(play);
        getButtons().add(mainMenu);
        getButtons().add(addRecord);
        setSelected(0);
        getButtons().get(0).setHighlight(true);
    }
}
