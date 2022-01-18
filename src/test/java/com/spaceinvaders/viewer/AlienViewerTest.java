package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Alien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlienViewerTest {
    ElementViewer<Alien> viewer;
    Alien alien;
    GUI gui;

    @BeforeEach
    void setup() {
        this.alien = Mockito.mock(Alien.class);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new AlienViewer();
    }

    @Test
    void drawNormalAlien() {
        Mockito.when(alien.getArmor()).thenReturn(0);
        viewer.drawElement(alien, gui);
        Mockito.verify(gui, Mockito.times(1)).drawNormalAlien(alien.getPosition());
    }

    @Test
    void drawArmoredAlien() {
        Mockito.when(alien.getArmor()).thenReturn(1);
        viewer.drawElement(alien, gui);
        Mockito.verify(gui, Mockito.times(1)).drawArmoredAlien(alien.getPosition());
    }
}
