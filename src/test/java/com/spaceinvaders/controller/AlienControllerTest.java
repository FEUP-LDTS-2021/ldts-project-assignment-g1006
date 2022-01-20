package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class AlienControllerTest {
    private AlienController alienController;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.arena = Mockito.mock(Arena.class);
        this.alienController = new AlienController(arena);
    }

    @Test
    void moveRight(){
        Alien alien = new Alien(10,10,0);
        Mockito.when(arena.getAliens()).thenReturn(List.of(List.of(alien)));
        Mockito.when(arena.getWidth()).thenReturn(20);

        alienController.step(game, 1000);

        Assertions.assertEquals(alien.getPosition(), new Position(11,10));
    }

    @Test
    void moveLeft(){
        Alien alien = new Alien(10,10,0); alien.changeDirection();
        Mockito.when(arena.getAliens()).thenReturn(List.of(List.of(alien)));
        Mockito.when(arena.getWidth()).thenReturn(20);

        alienController.step(game, 1000);

        Assertions.assertEquals(alien.getPosition(), new Position(9,10));
    }

    @Test
    void testRightLimit(){
        Alien alien = new Alien(20,10,0);
        Mockito.when(arena.getAliens()).thenReturn(List.of(List.of(alien)));
        Mockito.when(arena.getWidth()).thenReturn(20);

        alienController.step(game, 1000);

        Assertions.assertEquals(alien.getPosition(), new Position(20,10));
        Assertions.assertEquals(alien.getDirection(), -1);
    }

    @Test
    void testLeftLimit(){
        Alien alien = new Alien(0,10,0); alien.changeDirection();
        Mockito.when(arena.getAliens()).thenReturn(List.of(List.of(alien)));
        Mockito.when(arena.getWidth()).thenReturn(20);

        alienController.step(game, 1000);

        Assertions.assertEquals(alien.getPosition(), new Position(0,10));
        Assertions.assertEquals(alien.getDirection(), 1);
    }

    @Test
    void shoot(){
        Alien alien1 = new Alien(10,10,0);
        Alien alien2 = new Alien(10,12,0);
        Mockito.when(arena.getAliens()).thenReturn(List.of(List.of(alien1), List.of(alien2)));
        arena.setProjectiles(List.of());

        Assertions.assertEquals(alienController.shoot(alien1), null);
        Assertions.assertEquals(alienController.shoot(alien2).getPosition(), new Position(alien2.getPosition().getX(), alien2.getPosition().getY() + 1));
    }

}
