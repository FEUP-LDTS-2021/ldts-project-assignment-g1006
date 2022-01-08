import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element implements DrawCommand{
    protected char character;
    protected Position position;

    public Element(int x, int y, char character) {
        position = new Position(x,y);
        this.character = character;
    }

    protected Position getPosition(){
       return position;
    }

    protected void setPosition(Position position){
        this.position = position;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    @Override
    public abstract void draw(TextGraphics screen);

}