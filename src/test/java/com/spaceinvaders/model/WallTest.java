package com.spaceinvaders.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WallTest {
    private Wall wall;

    @BeforeEach
    void setup(){
        this.wall = new Wall(1,1, 3);
    }

    @Test
    void getPosition(){
        Assertions.assertEquals(wall.getPosition(), new Position(1,1));
    }

    @Test
    void setPosition(){
        wall.setPosition(new Position(2,2));
        Assertions.assertEquals(wall.getPosition(), new Position(2,2));
    }

    @Test
    void getHealth(){
        Assertions.assertEquals(wall.getHealth(), 3);
    }

    @Test
    void decreaseHealth(){
        wall.decreaseHealth(2);
        Assertions.assertEquals(wall.getHealth(), 1);
        wall.decreaseHealth(2);
        Assertions.assertEquals(wall.getHealth(), -1);
    }
}
