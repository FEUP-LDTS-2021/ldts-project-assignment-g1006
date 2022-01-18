package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Ammo;

public class AmmoViewer implements ElementViewer<Ammo>{
    @Override
    public void drawElement(Ammo element, GUI gui) {
        gui.drawAmmo(element.getPosition());
    }
}
