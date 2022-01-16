package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallViewerTest {
    private ElementViewer<Wall> viewer;
    private Wall wall;
    private GUI gui;

    @BeforeEach
    void setup() {
        this.wall = Mockito.mock(Wall.class);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new WallViewer();
    }

    @Test
    void drawElement() {
        viewer.drawElement(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(gui.createTextGraphics(), wall.getPosition());
    }
}
