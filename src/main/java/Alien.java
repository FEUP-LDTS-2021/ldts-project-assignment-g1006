import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
import java.util.Objects;

public class Alien extends Element{
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

    public void move(){
        setPosition(new Position(getPosition().getX() + getDirection(), getPosition().getY()));
    }

    public int getDirection(){
        return direction;
    }

    public void changeDirection() {
        direction*=-1;
    }

    public boolean freeToShoot(List<Alien> aliens){
        return true;
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setCharacter(getPosition().getX(), getPosition().getY(), getCharacter());
    }
}
