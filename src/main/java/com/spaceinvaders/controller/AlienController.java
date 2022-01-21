package com.spaceinvaders.controller;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.Alien;
import com.spaceinvaders.model.Ammo;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.Position;

import java.util.List;

public class AlienController extends Controller<Arena>{
    private long lastMoveTime;
    private long beginTime;
    public AlienController(Arena model) {
        super(model);
        this.lastMoveTime = 0;
        this.beginTime = 0;
    }

    @Override
    public void step(Game game, long time) {
        if(this.beginTime == 0) this.beginTime = time;
        if (time - lastMoveTime > 150) {
            for (List<Alien> list : getModel().getAliens()) {
                for (Alien alien : list) {
                    move(alien);
                }
            }
            outerLoop:
            for (List<Alien> list : getModel().getAliens()){
                for (Alien alien : list){
                    if(alien.getPosition().getX() == 0 || alien.getPosition().getX() == getModel().getWidth() - 1){
                        for (List<Alien> list2 : getModel().getAliens()) {
                            for (Alien alien2 : list2) {
                                alien2.changeDirection();
                            }
                        }
                        break outerLoop;
                    }
                }
            }
            this.lastMoveTime = time;
        }
    }

    private void move(Alien alien){
        Position newPos = new Position(alien.getPosition().getX() + alien.getDirection(), alien.getPosition().getY());
        alien.setPosition(newPos);
    }

    public Ammo shoot(Alien alien){
        if (alien.freeToShoot(getModel())) {
            return new com.spaceinvaders.model.Ammo(alien.getPosition().getX(), alien.getPosition().getY() + 1, 1, 1);
        }
        return null;
    }
}
