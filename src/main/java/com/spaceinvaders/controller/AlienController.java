package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;

import java.util.List;

public class AlienController extends Controller<Arena>{
    public AlienController(Arena model) {
        super(model);
    }

    @Override
    public void step(Game game, long time) {
        for (List<Alien> list : getModel().getAliens()){
            for (Alien alien : list){
                move(alien);
            }
        }
    }

    private void move(Alien alien){
        Position newPos = new Position(alien.getPosition().getX() + alien.getDirection(), alien.getPosition().getY());
        if (newPos.getX() >= 0 && newPos.getX() <= getModel().getWidth() - 1)
            alien.setPosition(newPos);
        else
            alien.changeDirection();
    }

    public Ammo shoot(Alien alien){
        if (alien.freeToShoot(getModel())) {
            return new com.spaceinvaders.model.Ammo(alien.getPosition().getX(), alien.getPosition().getY() + 1, 1, 1);
        }
        return null;
    }
}
