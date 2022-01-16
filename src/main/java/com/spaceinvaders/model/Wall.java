package com.spaceinvaders.model;

public class Wall extends Element{
    private int health;

    public Wall(int x, int y, char character, int health) {
        super(x, y, character);
        this.health = health;
    }

    public int getHealth() {
        return 0;
    }

    public void decreaseHealth(int damage){

    }
}
