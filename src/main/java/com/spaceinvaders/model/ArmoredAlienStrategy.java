package com.spaceinvaders.model;

public class ArmoredAlienStrategy implements AlienStrategy{
    @Override
    public int handleShot(int armor, Ammo ammo) {
        int original_damage = ammo.getDamage();
        if(ammo.getDamage() >= armor + 1)
            ammo.setDamage(ammo.getDamage() - armor - 1);
        else
            ammo.setDirection(ammo.getDirection()*-1);
        return armor - original_damage;

    }
}
