package com.spaceinvaders.gui;

import com.spaceinvaders.Position;

public interface GUI {
    int getWidth();
    int getHeight();

    void refresh();
    void clear();
    void close();

    void drawBackground();
    void drawPlayer(Position position);
    void drawAmmo(Position position);
    void drawAlien(Position position);
}
