package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverControllerTest {
    private GameOverController gameOverController;
    private Game game;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.menu = Mockito.mock(Menu.class);
        this.gameOverController = new GameOverController(menu, gui);
    }

    @Test
    void keyLeft() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.KEYLEFT);
        gameOverController.step(game, 0);
        Mockito.verify(menu, Mockito.times(1)).previousButton();
    }

    @Test
    void keyRight() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.KEYRIGHT);
        gameOverController.step(game, 0);
        Mockito.verify(menu, Mockito.times(1)).nextButton();
    }


    @Test
    void keyEnter() throws IOException {
        Button button = Mockito.mock(Button.class);
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.ENTER);
        Mockito.when(menu.getSelectedButton()).thenReturn(button);
        gameOverController.step(game, 0);
        Mockito.verify(button, Mockito.times(1)).click();
    }

    @Test
    void keyExit() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.Action.EXIT);
        gameOverController.step(game, 0);
        Mockito.verify(game, Mockito.times(1)).setGameState(null);
    }
}
