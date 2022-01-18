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

    void drawBackground();
    void drawPlayer(Position position);
    void drawNormalAmmo(Position position);
    void drawSuperAmmo(Position position);
    void drawNormalAlien(Position position);
    void drawArmoredAlien(Position position);
    void drawWall(Position position);
}
