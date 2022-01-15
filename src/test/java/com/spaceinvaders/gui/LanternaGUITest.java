package com.spaceinvaders.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.spaceinvaders.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private LanternaGUI gui;
    private TextGraphics textGraphics;
    private TerminalScreen terminalScreen;

    @BeforeEach
    void setup(){
        this.terminalScreen = Mockito.mock(TerminalScreen.class);
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
        gui.drawPlayer(textGraphics, position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getY(), "P");
    }

    @Test
    void drawAlien(){
        Position  position = new Position(10,10);
        gui.drawAlien(textGraphics, position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getY(), "A");
    }

    @Test
    void drawAmmo(){
        Position  position = new Position(10,10);
        gui.drawAmmo(textGraphics, position);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(position.getX(), position.getY(), "|");
    }

    @Test
    void drawBackground(){

        gui.drawBackground(textGraphics);
        String color = "#3360FF";
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString(color));
    }

    @Test
    void getKeyClose() throws IOException {
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(terminalScreen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('q');
        Assertions.assertEquals(gui.getAction(), GUI.Action.EXIT);

        Mockito.when(key.getKeyType()).thenReturn(KeyType.EOF);
        Assertions.assertEquals(gui.getAction(), GUI.Action.EXIT);
    }

    @Test
    void getKeyRight() throws IOException {
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(terminalScreen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowRight);

        Assertions.assertEquals(gui.getAction(), GUI.Action.KEYRIGHT);
    }

    @Test
    void getKeyLeft() throws IOException {
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(terminalScreen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowLeft);

        Assertions.assertEquals(gui.getAction(), GUI.Action.KEYLEFT);
    }

    @Test
    void getKeyUp() throws IOException {
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(terminalScreen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowUp);

        Assertions.assertEquals(gui.getAction(), GUI.Action.KEYUP);
    }
}
