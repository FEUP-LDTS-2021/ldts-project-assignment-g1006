package com.spaceinvaders.model;

public class Player extends Element {
    private int health = 3;

    public Player(int x, int y, char character){
        super(x,y,character);
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }
}