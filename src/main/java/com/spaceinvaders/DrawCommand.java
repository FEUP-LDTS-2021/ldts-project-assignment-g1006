package com.spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface DrawCommand {
    void draw(TextGraphics screen);
}
