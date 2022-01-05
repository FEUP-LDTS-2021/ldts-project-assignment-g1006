import com.googlecode.lanterna.graphics.TextGraphics;

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

    @Override
    public void draw(TextGraphics screen) {
        screen.setCharacter(getPosition().getX(), getPosition().getY(), getCharacter());
    }
}
