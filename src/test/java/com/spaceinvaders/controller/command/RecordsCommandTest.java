package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.RecordsManager;
import com.spaceinvaders.state.RecordsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;

public class RecordsCommandTest {
    private Game game;
    private RecordsManager recordsManager;
    private ButtonCommand buttonCommand;

    @BeforeEach
    void setup() throws FileNotFoundException {
        this.game = Mockito.mock(Game.class);
        this.recordsManager = Mockito.mock(RecordsManager.class);
        this.buttonCommand = new RecordsCommand(game);
        Mockito.when(game.getRecordsManager()).thenReturn(recordsManager);
        Mockito.when(recordsManager.read(Mockito.anyInt())).thenReturn(null);
    }

    @Test
    void play(){
        buttonCommand.execute();
        Mockito.verify(game, Mockito.times(1)).setGameState(Mockito.any(RecordsMenuState.class));
    }
}
