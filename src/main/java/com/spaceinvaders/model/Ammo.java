package com.spaceinvaders.model;

public class Ammo extends Element {

    private int direction;
    private int damage;

    public Ammo(int x, int y, char character, int direction, int damage) {
        super(x, y, character);
        this.direction = direction;
        this.damage = damage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void move(){
        setPosition(new Position(getPosition().getX(), getPosition().getY() + getDirection()));
    }

    public void shoot(){

    }
}