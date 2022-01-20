package com.spaceinvaders.model;

import com.spaceinvaders.model.Position;

public abstract class Element {
    protected Position position;

    public Element(int x, int y) {
        position = new Position(x,y);
    }

    protected Position getPosition(){
       return position;
    }

    protected void setPosition(Position position){
        this.position = position;
    }
}