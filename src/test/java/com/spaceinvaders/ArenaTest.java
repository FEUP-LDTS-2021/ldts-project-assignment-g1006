package com.spaceinvaders;

import com.googlecode.lanterna.screen.Screen;
import com.spaceinvaders.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ArenaTest {
    private Arena arena;
    private Screen screen;
    private Ammo ammo;
    private Player player;
    private Alien alien;

    @BeforeEach
    public void setup(){
        screen = Mockito.mock(Screen.class);
        arena = new Arena(10,10);
        ammo = Mockito.mock(Ammo.class);
        arena.setProjectiles(List.of(ammo));
        alien = Mockito.mock(Alien.class);
        arena.setAliens(List.of(List.of(alien)));
        player = Mockito.mock(Player.class);
        arena.setPlayer(player);
    }

    @Test
    public void processKeyRight(){
        Mockito.when(player.getPosition()).thenReturn(new Position(1,1));

        arena.processKey(GUI.Action.KEYRIGHT);
        Mockito.verify(player, Mockito.times(1)).moveRight(arena);

    }

    @Test
    public void processKeyLeft(){
        Mockito.when(player.getPosition()).thenReturn(new Position(1,1));

        arena.processKey(GUI.Action.KEYLEFT);
        Mockito.verify(player, Mockito.times(1)).moveLeft(arena);

    }

    @Test
    public void processKeyUp(){
        Mockito.when(player.getPosition()).thenReturn(new Position(1,1));

        arena.processKey(GUI.Action.KEYUP);

        Mockito.verify(player, Mockito.times(1)).shoot(arena);
        Assertions.assertEquals(arena.getProjectiles().size(), 1);
    }
}
