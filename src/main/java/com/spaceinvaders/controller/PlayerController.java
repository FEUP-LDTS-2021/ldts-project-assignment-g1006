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
        return new Position(player.getPosition().getX() - 1, player.getPosition().getY());
    }

    public Position moveRight() {
        return new Position(player.getPosition().getX() + 1, player.getPosition().getY());
    }

    public void move(Position position){
        player.setPosition(position);
    }
    
    public Ammo shoot(){
        return new Ammo(player.getPosition().getX(), player.getPosition().getY() - 1, '|', -1, 1);
    }
}
