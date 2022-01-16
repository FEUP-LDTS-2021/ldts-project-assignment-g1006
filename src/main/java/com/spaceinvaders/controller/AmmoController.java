package com.spaceinvaders.controller;

import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;

public class AmmoController extends Controller<Arena>{
    public AmmoController(Arena model) {
        super(model);
    }

    @Override
    public void step() {
        for (Ammo ammo : getModel().getProjectiles()){
            ammo.move();
        }
    }
}
