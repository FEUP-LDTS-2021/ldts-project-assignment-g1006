package com.spaceinvaders.model;

public class NormalAlienStrategy implements AlienStrategy{
    @Override
    public int handleShot(int armor, Ammo ammo) {
        return armor - ammo.getDamage();
    }
}
