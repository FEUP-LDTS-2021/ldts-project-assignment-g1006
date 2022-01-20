package com.spaceinvaders.state;

import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.controller.GameWonController;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;

public class GameWonState extends GameState<Menu>{
    public GameWonState(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public Controller<Menu> getController() {
        return new GameWonController(getModel(), gui);
    }
}
