import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element{

    public Player(int x, int y, char character){
        super(x,y,character);
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void moveLeft(Arena arena){
        if (getPosition().getX() > 0)
            setPosition(new Position(getPosition().getX() - 1, getPosition().getY()));
    }

    public void moveRight(Arena arena) {
        if (getPosition().getX() < arena.getWidth()-1)
            setPosition(new Position(getPosition().getX() + 1, getPosition().getY()));
    }

    public void shoot(Arena arena){
        Ammo ammo = new Ammo(getPosition().getX(), getPosition().getY() - 1, '|', -1, 1);
        arena.getProjectiles().add(ammo);
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "P");
    }
}