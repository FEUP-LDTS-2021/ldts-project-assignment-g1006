package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.command.ExitCommand;
import com.spaceinvaders.controller.command.PlayCommand;
import com.spaceinvaders.controller.command.RecordsCommand;
import com.spaceinvaders.model.Position;

public class StartMenu extends Menu {
    public StartMenu(Game game) {
        super(game);
        Button play = new Button("PLAY", "#003399", new Position(18, 10), new Position(28, 12));
        Button records = new Button("RECORDS", "#003399", new Position(18, 14), new Position(28, 16));
        Button exit = new Button("EXIT", "#003399", new Position(18, 18), new Position(28, 20));
        play.setCommand(new PlayCommand(game));
        records.setCommand(new RecordsCommand(game));
        exit.setCommand(new ExitCommand(game));
        getButtons().add(play);
        getButtons().add(records);
        getButtons().add(exit);
        setSelected(0);
        getButtons().get(0).setHighlight(true);
    }
}
