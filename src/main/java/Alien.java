import java.util.Objects;

public abstract class Alien extends Element{

    public Alien(int x, int y){
        super(x, y);
    }

    public Position moveLeft(){
        return position;
    }

    public Position moveRight(){
        return position;
    }
}
