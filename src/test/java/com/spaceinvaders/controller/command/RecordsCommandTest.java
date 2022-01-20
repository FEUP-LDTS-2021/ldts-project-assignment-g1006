package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.state.RecordsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RecordsCommandTest {
    private Game game;
    private ButtonCommand buttonCommand;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.buttonCommand = new RecordsCommand(game);
    }

    @Test
    void play(){
        buttonCommand.execute();
        Mockito.verify(game, Mockito.times(1)).setGameState(Mockito.any(RecordsMenuState.class));
    }
}
