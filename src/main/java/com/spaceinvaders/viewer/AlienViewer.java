package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Alien;

public class AlienViewer implements ElementViewer<Alien> {
    @Override
    public void drawElement(Alien element, GUI gui) {
        if(element.getArmor() == 0)
            gui.drawNormalAlien(element.getPosition());
        else
            gui.drawArmoredAlien(element.getPosition());
    }
}
