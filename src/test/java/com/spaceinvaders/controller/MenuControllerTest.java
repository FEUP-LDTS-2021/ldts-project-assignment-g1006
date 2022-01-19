package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    private MenuController menuController;
    private Game game;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.menu = Mockito.mock(Menu.class);
        this.menuController = new MenuController(menu, gui);
    }

    @Test
    void keyUp() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.KEYUP);
        menuController.step(game, 0);
        Mockito.verify(menu, Mockito.times(1)).previousButton();
    }

    @Test
    void keyDown() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.KEYDOWN);
        menuController.step(game, 0);
        Mockito.verify(menu, Mockito.times(1)).nextButton();
    }

    @Test
    void keyExit() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.EXIT);
        menuController.step(game, 0);
        Mockito.verify(game, Mockito.times(1)).setGameState(null);
    }
}
