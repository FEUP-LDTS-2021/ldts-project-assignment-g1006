package com.spaceinvaders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setup() throws IOException, URISyntaxException, FontFormatException {
        game = Game.getInstance();
    }

    @Test
    void instanceTest() throws IOException, URISyntaxException, FontFormatException {
        Game game1 = Game.getInstance();
        Assertions.assertNotNull(game1);
        Assertions.assertEquals(game,game1);
    }
}
