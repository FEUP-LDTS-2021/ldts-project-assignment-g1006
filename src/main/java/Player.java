import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element{

    public Player(int x, int y){
        super(x,y);
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