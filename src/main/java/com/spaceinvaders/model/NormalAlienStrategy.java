package com.spaceinvaders.model;

public class NormalAlienStrategy implements AlienStrategy{
    @Override
    public int handleShot(int armor, Ammo ammo) {
        ammo.setDamage(ammo.getDamage() - 1);
        return armor - 1;
    }
}
