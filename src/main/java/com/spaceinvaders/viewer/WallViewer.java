package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void drawElement(Wall element, GUI gui) {
        gui.drawWall(gui.createTextGraphics(), element.getPosition());
    }
}
