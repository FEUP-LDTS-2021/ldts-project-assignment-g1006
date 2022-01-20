package com.spaceinvaders.model;

import com.spaceinvaders.controller.command.ButtonCommand;
import com.spaceinvaders.model.menu.Button;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ButtonTest {
    private Button button;

    @BeforeEach
    void setup(){
        Position position1 = new Position(0,0);
        Position position2 = new Position(2,5);
        this.button = new Button("Play", "#000000", position1, position2);
    }

    @Test
    void getTopLeft(){
        Assertions.assertEquals(button.getTopleft(), new Position(0,0));
    }

    @Test
    void getBottomright(){
        Assertions.assertEquals(button.getBottomright(), new Position(2,5));
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
        Assertions.assertFalse(button.isHighlighted());
    }

    @Test
    void setHighlight(){
        button.setHighlight(true);
        Assertions.assertTrue(button.isHighlighted());
        button.setHighlight(false);
        Assertions.assertFalse(button.isHighlighted());
    }

    @Test
    void setCommand(){
        ButtonCommand command = Mockito.mock(ButtonCommand.class);
        button.setCommand(command);
        Assertions.assertEquals(button.getCommand(), command);
    }

    @Test
    void getCommand(){
        Assertions.assertNull(button.getCommand());
    }

    @Test
    void click(){
        ButtonCommand command = Mockito.mock(ButtonCommand.class);
        button.setCommand(command);
        button.click();
        Mockito.verify(command, Mockito.times(1)).execute();
    }

}

