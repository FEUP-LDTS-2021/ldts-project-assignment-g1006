import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element{

    public Player(int x, int y, char character){
        super(x,y,character);
    }

    public Position moveLeft(){
        return new Position(getPosition().getX() - 1,getPosition().getY());
    }

    public Position moveRight(){
        return new Position(getPosition().getX() + 1,getPosition().getY());
    }

    @Override
    public void draw(TextGraphics screen) {

    }
}