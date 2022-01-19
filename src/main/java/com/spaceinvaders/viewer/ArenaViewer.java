package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Element;

import java.io.IOException;
import java.util.List;

public class ArenaViewer {
    private final GUI gui;
    private final Arena arena;

    public ArenaViewer(GUI gui, Arena arena) {
        this.gui = gui;
        this.arena = arena;
    }

    public void draw() throws IOException {
        gui.clear();
        gui.drawBackground();

        for (List<Alien> list : arena.getAliens()) drawElements(list, new AlienViewer());
        drawElements(arena.getProjectiles(), new AmmoViewer());
        drawElements(arena.getWalls(), new WallViewer());
        drawElement(arena.getPlayer(), new PlayerViewer());
        drawHealth(arena.getPlayer().getHealth(), new HealthViewer());

        gui.refresh();
    }

    private void drawHealth(int health, HealthViewer viewer){
        viewer.drawElement(health, gui);
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.drawElement(element, gui);
    }

    private <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }
}