package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Ammo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AmmoViewerTest {
    ElementViewer<Ammo> viewer;
    Ammo ammo;
    GUI gui;

    @BeforeEach
    void setup() {
        this.ammo = Mockito.mock(Ammo.class);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new AmmoViewer();
    }

    @Test
    void drawNormalAmmo() {
        Mockito.when(ammo.getDamage()).thenReturn(1);
        viewer.drawElement(ammo, gui);
        Mockito.verify(gui, Mockito.times(1)).drawNormalAmmo(ammo.getPosition());
    }

    @Test
    void drawSuperAmmo() {
        Mockito.when(ammo.getDamage()).thenReturn(2);
        viewer.drawElement(ammo, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSuperAmmo(ammo.getPosition());
    }
}
