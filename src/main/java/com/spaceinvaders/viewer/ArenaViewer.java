package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Element;

import java.io.IOException;
import java.util.List;

public class ArenaViewer extends Viewer<Arena>{

    public ArenaViewer(GUI gui, Arena arena) {
        super(arena, gui);
    }

    public void draw() throws IOException {
        getGui().clear();
        getGui().drawBackground();

        for (List<Alien> list : getModel().getAliens()) drawElements(list, new AlienViewer());
        drawElements(getModel().getProjectiles(), new AmmoViewer());
        drawElements(getModel().getWalls(), new WallViewer());
        drawElement(getModel().getPlayer(), new PlayerViewer());

        getGui().refresh();
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.drawElement(element, gui);
    }

    private <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }
}