import com.googlecode.lanterna.graphics.TextGraphics;

public class Ammo extends Element {
    private enum directions{UP, DOWN}
    private int direction;
    private int damage;

    public Ammo(int x, int y, char character, int direction, int damage) {
        super(x, y, character);
        this.direction = direction;
        this.damage = damage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void moveUp(){
        //setPosition(new Position(getPosition().getX(), getPosition().getY() - 1));
    }

    public void moveDown(){
        //setPosition(new Position(getPosition().getX(), getPosition().getY() + 1));
    }

    public void shoot(){

    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setCharacter(getPosition().getX(), getPosition().getY(), getCharacter());
    }
}
