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
    private List<Alien> aliens;
    private List<Ammo> projectiles;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public List<Ammo> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Ammo> projectiles) {
        this.projectiles = projectiles;
    }

    public void draw(TextGraphics screen){
        for (Ammo ammo : projectiles)
            ammo.draw(screen);
        for (Alien alien : aliens)
            alien.draw(screen);
        player.draw(screen);
    }

    public boolean checkProjectilesCollision(){
        return false;
    }

    public void processKey(KeyStroke key){
        if(key != null){
            switch (key.getKeyType()) {
                case ArrowLeft -> player.moveLeft();
                case ArrowRight -> player.moveRight();
            }
        }
    }

    public boolean checkAlienLimitsCollisions(){
        for(Alien alien : aliens){
            if(alien.getPosition().getX() == 0 || alien.getPosition().getX() == 40){
                return true;
            }
        }
        return false;
    }

    public void checkAlienProjectilesCollisions(){
        Iterator<Alien> it1 = aliens.iterator();
        while(it1.hasNext()){
            Alien alien = it1.next();
            Iterator<Ammo> it2 = projectiles.iterator();
            while(it2.hasNext()){
                Ammo ammo = it2.next();
                if(alien.getPosition().getX() == ammo.getPosition().getX() && alien.getPosition().getY() == ammo.getPosition().getY()){
                    it1.remove();
                    it2.remove();
                    break;
                }
            }
        }
    }
}
