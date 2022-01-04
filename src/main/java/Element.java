import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected char character;
    protected Position position;

    public Element(int x, int y, char character) {
        position = new Position(x,y);
        this.character = character;
    }

    public Position getPosition(){
       return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public abstract void draw(TextGraphics screen);
}