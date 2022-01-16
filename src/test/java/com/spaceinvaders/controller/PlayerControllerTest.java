package com.spaceinvaders.controller;

import com.spaceinvaders.model.Player;
import com.spaceinvaders.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayerControllerTest {
    private PlayerController playerController;
    private Player player;

    @BeforeEach
    void setup(){
        this.player = Mockito.mock(Player.class);
        Mockito.when(player.getPosition()).thenReturn(new Position(10,10));
        this.playerController = new PlayerController(player);
    }

    @Test
    void moveLeft(){
        Assertions.assertEquals(playerController.moveLeft(), new Position(9,10));
    }

    @Test
    void moveRight(){
        Assertions.assertEquals(playerController.moveRight(), new Position(11,10));
    }

    @Test
    void move(){
        Player pl = new Player(1,1,'P');
        playerController = new PlayerController(pl);
        playerController.move(new Position(10, 10));
        Assertions.assertEquals(player.getPosition(), new Position(10, 10));
    }

    @Test
    void shoot() {
        Assertions.assertEquals(playerController.shoot().getPosition().getX(), 10);
        Assertions.assertEquals(playerController.shoot().getPosition().getY(), 9);
    }
}
