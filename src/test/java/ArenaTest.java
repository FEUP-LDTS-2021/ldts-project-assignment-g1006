import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ArenaTest {
    private Arena arena;
    private Screen screen;
    private Ammo ammo;
    private Player player;
    private Alien alien;

    @BeforeEach
    public void setup(){
        screen = Mockito.mock(Screen.class);
        arena = new Arena(10,10);
        ammo = Mockito.mock(Ammo.class);
        arena.setProjectiles(List.of(ammo));
        alien = Mockito.mock(Alien.class);
        arena.setAliens(List.of(alien));
        player = Mockito.mock(Player.class);
        arena.setPlayer(player);
    }

    @Test
    public void drawAmmo(){
        arena.draw(screen.newTextGraphics());
        Mockito.verify(ammo, Mockito.times(1)).draw(screen.newTextGraphics());
    }

    @Test
    public void drawPlayer(){
        arena.draw(screen.newTextGraphics());
        Mockito.verify(player, Mockito.times(1)).draw(screen.newTextGraphics());
    }

    @Test
    public void drawAlien(){
        arena.draw(screen.newTextGraphics());
        Mockito.verify(player, Mockito.times(1)).draw(screen.newTextGraphics());
    }

    @Test
    public void processKeyRight(){
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowRight);
        Mockito.when(player.getPosition()).thenReturn(new Position(1,1));

        arena.processKey(key);
        Mockito.verify(player, Mockito.times(1)).moveRight();

    }

    @Test
    public void processKeyLeft(){
        KeyStroke key = Mockito.mock(KeyStroke.class);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.ArrowLeft);
        Mockito.when(player.getPosition()).thenReturn(new Position(1,1));

        arena.processKey(key);
        Mockito.verify(player, Mockito.times(1)).moveLeft();

    }
}
