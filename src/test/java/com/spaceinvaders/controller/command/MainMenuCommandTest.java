package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuCommandTest {
    private Game game;
    private ButtonCommand buttonCommand;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.buttonCommand = new MainMenuCommand(game);
    }

    @Test
    void exit(){
        buttonCommand.execute();
        Mockito.verify(game, Mockito.times(1)).setGameState(Mockito.any(MenuState.class));
    }
}
