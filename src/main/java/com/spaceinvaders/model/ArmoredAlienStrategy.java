package com.spaceinvaders.model;

public class ArmoredAlienStrategy implements AlienStrategy{
    @Override
    public int handleShot(int armor, Ammo ammo) {
        return 0;
    }
}
