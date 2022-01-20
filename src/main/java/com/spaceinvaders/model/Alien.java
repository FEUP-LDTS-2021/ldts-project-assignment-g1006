package com.spaceinvaders.model;

import java.util.List;

public class Alien extends Element {
    private int direction = 1;
    private int armor;
    private AlienStrategy strategy;
    private Boolean dead = false;

    public Alien(int x, int y, int armor){
        super(x, y);
        setArmor(armor);
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public int getDirection(){
        return direction;
    }

    public void changeDirection() {
        direction*=-1;
    }

    public AlienStrategy getStrategy(){
        return strategy;
    }

    private void setStrategy(){
        if(armor > 0)
            this.strategy = new ArmoredAlienStrategy();
        else
            this.strategy = new NormalAlienStrategy();
    }

    public void setArmor(int armor) {
        if(armor < 0){
            setAsDead();
            return;
        }
        else
            setAsAlive();
        this.armor = armor;
        setStrategy();
    }

    private void setAsAlive() {
        dead = false;
    }

    public int getArmor(){
        return armor;
    }

    public Boolean isDead(){
        return dead;
    }

    public void setAsDead(){
        dead = true;
    }

    public void handleShot(Ammo ammo){
        setArmor(strategy.handleShot(getArmor(),ammo));
    }



    public boolean freeToShoot(com.spaceinvaders.model.Arena arena){
        for (List<Alien> aliensRow : arena.getAliens()){
            for(com.spaceinvaders.model.Alien alien: aliensRow) {
                if (alien.getPosition().getX() == getPosition().getX() && alien.getPosition().getY() > getPosition().getY()) {
                    return false;
                }
            }
        }
        return true;
    }

}
