package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.menu.Menu;

import java.io.IOException;

public class RecordsMenuController extends Controller<Menu>{
    public RecordsMenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, long time) throws IOException {

    }
}
