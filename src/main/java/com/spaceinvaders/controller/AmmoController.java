package com.spaceinvaders.controller;

import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;

public class AmmoController extends Controller<Arena>{
    public AmmoController(Arena model) {
        super(model);
    }

    @Override
    public void step() {
        for (Ammo ammo : getModel().getProjectiles()){
            move(ammo);
        }
    }

    public void move(Ammo ammo){
        Position newPos = new Position(ammo.getPosition().getX(), ammo.getPosition().getY() + ammo.getDirection());
        ammo.setPosition(newPos);
    }
}
