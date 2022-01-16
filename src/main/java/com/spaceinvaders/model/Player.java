package com.spaceinvaders.model;

public class Player extends Element {

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
}