package com.spaceinvaders.state;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.state.PlayingState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class PlayingStateTest {
    private PlayingState state;
    private Arena arena;
    private GUI gui;

    @BeforeEach
    public void setup() throws IOException, URISyntaxException, FontFormatException {
        this.arena = Mockito.mock(Arena.class);
        this.gui = Mockito.mock(GUI.class);
        this.state = new PlayingState(arena,gui);
    }

    @Test
    void getController(){
        Assertions.assertEquals(state.getController().getModel(), state.getModel());
    }
}

