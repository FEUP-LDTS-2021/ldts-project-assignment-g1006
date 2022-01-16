package com.spaceinvaders.controller;

import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
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
    void move(){
        Ammo ammo = Mockito.mock(Ammo.class);
        Mockito.when(arena.getProjectiles()).thenReturn(List.of(ammo));

        ammoController.step();

        Mockito.verify(ammo, Mockito.times(1)).move();
    }
}
