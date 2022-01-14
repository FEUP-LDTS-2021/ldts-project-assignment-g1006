package com.spaceinvaders.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.spaceinvaders.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class LanternaGUITest {
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setup(){
        TerminalScreen terminalScreen = Mockito.mock(TerminalScreen.class);
        this.gui = new LanternaGUI(terminalScreen);
        this.textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(terminalScreen.newTextGraphics()).thenReturn(textGraphics);
    }

    @Test
    void getWidth(){
        int width = gui.getWidth();
        Assertions.assertEquals(width, 100);
    }

    @Test
    void getHeight(){
        int height = gui.getHeight();
        Assertions.assertEquals(height, 80);
    }

    @Test
    void drawPlayer(){
        Position  position = new Position(10,10);
        gui.drawPlayer(position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getX(), "P");
    }

    @Test
    void drawAlien(){
        Position  position = new Position(10,10);
        gui.drawAlien(position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getX(), "A");
    }

    @Test
    void drawAmmo(){
        Position  position = new Position(10,10);
        gui.drawAmmo(position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getX(), "|");
    }

    @Test
    void drawBackground(){
        gui.drawBackground();
        String color = "#3360FF";
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(color));
    }
}
