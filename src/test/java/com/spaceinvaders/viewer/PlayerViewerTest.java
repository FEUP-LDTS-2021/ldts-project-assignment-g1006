package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class PlayerViewerTest {
    ElementViewer<Player> viewer;
    Player player;
    GUI gui;

    @BeforeEach
    void setup() {
        this.player = Mockito.mock(Player.class);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new PlayerViewer();
    }

    @Test
    void drawElement() {
        viewer.drawElement(player, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player.getPosition());
    }
}
