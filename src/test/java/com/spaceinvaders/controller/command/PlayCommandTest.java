package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.state.PlayingState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayCommandTest {
    private Game game;
    private ButtonCommand buttonCommand;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.buttonCommand = new PlayCommand(game);
    }

    @Test
    void play(){
        buttonCommand.execute();
        Mockito.verify(game, Mockito.times(1)).setGameState(Mockito.any(PlayingState.class));
    }
}
