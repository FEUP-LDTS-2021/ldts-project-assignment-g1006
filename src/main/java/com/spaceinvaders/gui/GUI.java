package com.spaceinvaders.gui;

import com.spaceinvaders.Position;

import java.io.IOException;

public interface GUI {
    int getWidth();
    int getHeight();

    void refresh() throws IOException;
    void clear();
    void close() throws IOException;

    void drawBackground();
    void drawPlayer(Position position);
    void drawAmmo(Position position);
    void drawAlien(Position position);
}
