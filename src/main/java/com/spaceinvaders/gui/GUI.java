package com.spaceinvaders.gui;

import com.spaceinvaders.Position;

import java.io.IOException;

public interface GUI {
enum Action {KEYUP, KEYRIGHT, KEYLEFT, EXIT, NONE}

    int getWidth();
    int getHeight();
    Action getAction() throws IOException;

    void refresh() throws IOException;
    void clear();
    void close() throws IOException;

    void drawBackground();
    void drawPlayer(Position position);
    void drawAmmo(Position position);
    void drawAlien(Position position);
}
