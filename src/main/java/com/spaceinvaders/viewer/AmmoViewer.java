package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Ammo;

public class AmmoViewer implements ElementViewer<Ammo>{
    @Override
    public void drawElement(Ammo element, GUI gui) {
        if(element.getDamage() == 1)
            gui.drawNormalAmmo(element.getPosition());
        else
            gui.drawSuperAmmo(element.getPosition());
    }
}
