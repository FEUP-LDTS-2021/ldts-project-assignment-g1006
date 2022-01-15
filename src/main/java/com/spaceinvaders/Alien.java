package com.spaceinvaders;

public class Alien extends Element {
    private int direction = 1;

    public Alien(int x, int y, char character){
        super(x, y, character);
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void move(Arena arena){
        Position newPos = new Position(getPosition().getX() + getDirection(), getPosition().getY());
        if (newPos.getX() >= 0 && newPos.getX() <= arena.getWidth() - 1)
            setPosition(newPos);
        else
            changeDirection();
    }

    public int getDirection(){
        return direction;
    }

    public void changeDirection() {
        direction*=-1;
    }

    /*
    public boolean freeToShoot(com.spaceinvaders.Arena arena){
        for (com.spaceinvaders.Alien alien : arena.getAliens()){
            if (alien.getPosition().getX() == getPosition().getX() && alien.getPosition().getY() > getPosition().getY()){
                return false;
            }
        }
        return true;
    }

    public void shoot(com.spaceinvaders.Arena arena){
        if (freeToShoot(arena)){
            com.spaceinvaders.Ammo ammo = new com.spaceinvaders.Ammo(getPosition().getX(), getPosition().getY()+getDirection(), getCharacter(), getDirection(), 0);
            arena.getProjectiles().add(ammo);
        }
    }
    */
}
