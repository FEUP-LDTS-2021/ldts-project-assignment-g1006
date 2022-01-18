package com.spaceinvaders.model;

import com.spaceinvaders.model.menu.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonTest {
    private Button button;

    @BeforeEach
    void setup(){
        Position position = new Position(0,0);
        this.button = new Button("Play", "#000000", position);
    }

    @Test
    void getPosition(){
        Assertions.assertEquals(button.getPosition(), new Position(0,0));
    }

    @Test
    void getText(){
        Assertions.assertEquals(button.getText(), "Play");
    }

    @Test
    void getColor(){
        Assertions.assertEquals(button.getColor(), "#000000");
    }

    @Test
    void getHighlight(){
        Assertions.assertTrue(button.getHighlight());
    }
}

