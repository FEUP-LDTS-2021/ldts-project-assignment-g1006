package com.spaceinvaders.state;

import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;

public class RecordsMenuState extends GameState<Menu>{
    public RecordsMenuState(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    protected Controller<Menu> getController() {
        return null;
    }
}
