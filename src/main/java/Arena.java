import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import javax.swing.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Player player;
    private List<List<Alien>> aliens;
    private List<Ammo> projectiles;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<List<Alien>> getAliens() {
        return aliens;
    }

    public void setAliens(List<List<Alien>> aliens) {
        this.aliens = aliens;
    }

    public List<Ammo> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Ammo> projectiles) {
        this.projectiles = projectiles;
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Ammo ammo : projectiles)
            ammo.draw(screen);
        for (List<Alien> row : aliens) {
            for(Alien alien : row)
                alien.draw(screen);
        }
        player.draw(screen);
    }

    public boolean checkProjectilesCollision(){
        return false;
    }

    public void processKey(KeyStroke key){
        if(key != null){
            switch (key.getKeyType()) {
                case ArrowLeft -> player.moveLeft(this);
                case ArrowRight -> player.moveRight(this);
                case ArrowUp -> player.shoot(this);
            }
        }
    }

    public void checkAlienProjectilesCollisions(){
        for(List<Alien> row : aliens) {
            Iterator<Alien> it1 = row.iterator();
            while (it1.hasNext()) {
                Alien alien = it1.next();
                Iterator<Ammo> it2 = projectiles.iterator();
                while (it2.hasNext()) {
                    Ammo ammo = it2.next();
                    if (alien.getPosition().getX() == ammo.getPosition().getX() && alien.getPosition().getY() == ammo.getPosition().getY()) {
                        it1.remove();
                        it2.remove();
                        break;
                    }
                }
            }
        }
    }
}
