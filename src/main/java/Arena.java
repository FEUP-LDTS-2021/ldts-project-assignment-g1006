import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.security.Key;
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

    }

    public boolean checkAlienLimitsCollisions(){
    }
}
