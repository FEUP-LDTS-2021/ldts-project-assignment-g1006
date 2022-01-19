package com.spaceinvaders.state;

import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;

public class MenuState extends GameState<Menu>{
    public MenuState(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public Controller<Menu> getController() {
        return null;
    }
}
