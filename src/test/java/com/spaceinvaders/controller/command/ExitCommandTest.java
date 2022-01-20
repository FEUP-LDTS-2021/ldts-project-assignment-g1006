package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ExitCommandTest {
    private Game game;
    private ButtonCommand buttonCommand;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.buttonCommand = new ExitCommand(game);
    }

    @Test
    void exit(){
        buttonCommand.execute();
        Mockito.verify(game, Mockito.times(1)).setGameState(null);
    }
}
