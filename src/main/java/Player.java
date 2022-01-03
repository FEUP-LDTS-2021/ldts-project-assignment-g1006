public class Player extends Element{

    public Player(int x, int y){
        super(x,y);
    }

    public Position moveLeft(){
        return new Position(0,0);
    }

    public Position moveRight(){
        return new Position(0,0);
    }
}