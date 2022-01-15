package com.spaceinvaders.controller;

import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Player;
import com.spaceinvaders.model.Position;

public class PlayerController {
    private final Player player;

    public PlayerController(Player player){
        this.player = player;
    }

    public Position moveLeft(){
        return null;
    }

    public Position moveRight() {
        return null;
    }

    public void move(Position position){
    }
    
    public Ammo shoot(){
        return null;
    }
}
