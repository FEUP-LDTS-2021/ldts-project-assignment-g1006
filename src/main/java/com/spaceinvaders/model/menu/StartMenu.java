package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.Position;

public class StartMenu extends Menu {
    public StartMenu(Game game) {
        super(game);
        getButtons().add(new Button("Play", "#003399", new Position(15, 10), new Position(25, 12)));
        getButtons().add(new Button("Records", "#003399", new Position(15, 14), new Position(25, 16)));
        getButtons().add(new Button("Exit", "#003399", new Position(15, 18), new Position(25, 20)));
        setSelected(0);
        getButtons().get(0).setHighlight(true);
    }
}
