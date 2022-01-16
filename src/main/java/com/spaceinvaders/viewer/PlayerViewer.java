package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void drawElement(Player element, GUI gui) {
        gui.drawPlayer(gui.createTextGraphics(), element.getPosition());
    }
}
