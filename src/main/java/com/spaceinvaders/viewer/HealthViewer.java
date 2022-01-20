package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Player;

public class HealthViewer {
    public void drawElement(int health, GUI gui) {
        gui.drawHealth(health);
    }
}
