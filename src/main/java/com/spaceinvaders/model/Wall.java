package com.spaceinvaders.model;

public class Wall extends Element{
    private int health;

    public Wall(int x, int y, int health) {
        super(x, y);
        this.health = health;
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int damage){
        this.health -= damage;
    }
}
