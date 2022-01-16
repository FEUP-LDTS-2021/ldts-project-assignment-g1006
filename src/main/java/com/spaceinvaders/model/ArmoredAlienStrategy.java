package com.spaceinvaders.model;

public class ArmoredAlienStrategy implements AlienStrategy{
    @Override
    public int handleShot(int armor, Ammo ammo) {
        ammo.setDirection(ammo.getDirection()*-1);
        return armor - ammo.getDamage();
    }
}
