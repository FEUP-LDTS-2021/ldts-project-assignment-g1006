public abstract class Element {

    public Element(int x, int y) {
        x = 0;
        y = 0;
    }

    public Position getPosition(){
       return new Position(0,0);
    }

    public void setPosition(Position position){

    }

}