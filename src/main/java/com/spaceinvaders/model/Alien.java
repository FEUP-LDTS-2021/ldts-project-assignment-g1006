package com.spaceinvaders.model;

public class Alien extends Element {
    private int direction = 1;
    private int armor;
    private AlienStrategy strategy;

    public Alien(int x, int y, char character, int armor){
        super(x, y, character);
        setArmor(armor);
        setStrategy();
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

    public void setStrategy(){
        if(armor > 0)
            this.strategy = new ArmoredAlienStrategy();
        else
            this.strategy = new NormalAlienStrategy();
    }

    public void setArmor(int armor) {

    }

    /*
    public boolean freeToShoot(com.spaceinvaders.model.Arena arena){
        for (com.spaceinvaders.model.Alien alien : arena.getAliens()){
            if (alien.getPosition().getX() == getPosition().getX() && alien.getPosition().getY() > getPosition().getY()){
                return false;
            }
        }
        return true;
    }

    public void shoot(com.spaceinvaders.model.Arena arena){
        if (freeToShoot(arena)){
            com.spaceinvaders.model.Ammo ammo = new com.spaceinvaders.model.Ammo(getPosition().getX(), getPosition().getY()+getDirection(), getCharacter(), getDirection(), 0);
            arena.getProjectiles().add(ammo);
        }
    }
    */
}
