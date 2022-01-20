package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.command.MainMenuCommand;
import com.spaceinvaders.controller.command.PlayCommand;
import com.spaceinvaders.model.Position;

import static java.lang.Math.round;

public class GameOverMenu extends Menu{
    public String time;
    public GameOverMenu(Game game, long finalTime) {
        super(game);
        this.time = String.valueOf(round(finalTime / 1000.0));
        Button play = new Button("Retry", "#003399", new Position(3, 18), new Position(14, 20));
        Button mainMenu = new Button("Main Menu", "#003399", new Position(16, 18), new Position(27, 20));
        play.setCommand(new PlayCommand(game));
        mainMenu.setCommand(new MainMenuCommand(game));
        getButtons().add(play);
        getButtons().add(mainMenu);
        setSelected(0);
        getButtons().get(0).setHighlight(true);
    }
}
