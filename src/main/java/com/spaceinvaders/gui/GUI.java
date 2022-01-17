package com.spaceinvaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.Position;

import java.io.IOException;

public interface GUI {
enum Action {KEYUP, KEYRIGHT, KEYLEFT, EXIT, NONE}

    int getWidth();
    int getHeight();
    Action getAction() throws IOException;

    void refresh() throws IOException;
    void clear();
    void close() throws IOException;
    TextGraphics createTextGraphics();

    void drawBackground(TextGraphics textGraphics);
    void drawPlayer(TextGraphics textGraphics, Position position);
    void drawAmmo(TextGraphics textGraphics, Position position);
    void drawNormalAlien(TextGraphics textGraphics, Position position);
    void drawArmoredAlien(TextGraphics textGraphics, Position position);
    void drawWall(TextGraphics textGraphics, Position position);
}
