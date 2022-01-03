import java.util.Objects;

public class Alien extends Element{

    public Alien(int x, int y){
        super(x, y);
    }

    public Position moveLeft(){
        return new Position(getPosition().getX() - 1,getPosition().getY());
    }

    public Position moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }
}
