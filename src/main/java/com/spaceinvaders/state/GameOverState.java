package com.spaceinvaders.state;

import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.controller.GameOverController;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;

public class GameOverState extends GameState<Menu>{
    public GameOverState(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public Controller<Menu> getController() {
        return new GameOverController(getModel(), gui);
    }
}
