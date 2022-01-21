package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.command.MainMenuCommand;
import com.spaceinvaders.controller.command.PlayCommand;
import com.spaceinvaders.model.Position;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class RecordsMenu extends Menu{
    private List<Map.Entry<String, Integer>> entries;
    public RecordsMenu(Game game) {
        super(game);
        Button play = new Button("PLAY", "#003399", new Position(3, 20), new Position(14, 22));
        Button mainMenu = new Button("MAIN MENU", "#003399", new Position(16, 20), new Position(27, 22));
        play.setCommand(new PlayCommand(game));
        mainMenu.setCommand(new MainMenuCommand(game));
        getButtons().add(play);
        getButtons().add(mainMenu);
        setSelected(0);
        getButtons().get(0).setHighlight(true);
        try {
            this.entries = getGame().getRecordsManager().read(10);
        } catch (FileNotFoundException ignored){}
    }

    public List<Map.Entry<String, Integer>> getEntries() {
        return entries;
    }
}
