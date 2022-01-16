package com.spaceinvaders.controller;

import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class AmmoControllerTest {
    private AmmoController ammoController;
    private Arena arena;

    @BeforeEach
    void setup(){
        this.arena = Mockito.mock(Arena.class);
        this.ammoController = new AmmoController(arena);
    }

    @Test
    void moveUp(){
        Ammo ammo = new Ammo(10,10,'|', -1, 0);
        Mockito.when(arena.getProjectiles()).thenReturn(List.of(ammo));

        ammoController.step();

        Assertions.assertEquals(ammo.getPosition(), new Position(10, 9));
    }

    @Test
    void moveDown(){
        Ammo ammo = new Ammo(10,10,'|', 1, 0);
        Mockito.when(arena.getProjectiles()).thenReturn(List.of(ammo));

        ammoController.step();

        Assertions.assertEquals(ammo.getPosition(), new Position(10, 11));
    }
}
