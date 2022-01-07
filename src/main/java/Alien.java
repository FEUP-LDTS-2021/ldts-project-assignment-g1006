import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
import java.util.Objects;

public abstract class Alien extends Element{
    protected int direction = 1;
    protected int armor;
    protected Boolean isDead;

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
    public boolean freeToShoot(Arena arena){
        for (Alien alien : arena.getAliens()){
            if (alien.getPosition().getX() == getPosition().getX() && alien.getPosition().getY() > getPosition().getY()){
                return false;
            }
        }
        return true;
    }

    public void shoot(Arena arena){
        if (freeToShoot(arena)){
            Ammo ammo = new Ammo(getPosition().getX(), getPosition().getY()+getDirection(), getCharacter(), getDirection(), 0);
            arena.getProjectiles().add(ammo);
        }
    }
    */
    public void reduceArmor(){
        this.armor--;
    }

    public int getArmor(){
        return armor;
    }

    public void setAsDead(){
        isDead = true;
    }

    public Boolean isDead(){
        return isDead;
    }
    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#07C400"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "A");
    }
}
