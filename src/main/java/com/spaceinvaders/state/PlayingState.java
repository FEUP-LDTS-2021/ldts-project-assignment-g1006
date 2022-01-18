package com.spaceinvaders.state;

import com.spaceinvaders.controller.ArenaController;
import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Arena;

public class PlayingState extends GameState<Arena> {

    public PlayingState(Arena arena, GUI gui) {
        super(arena, gui);
    }

    @Override
    public Controller<Arena> getController() {
        return new ArenaController(getModel(), gui);
    }
}
