import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class ArenaTest {

    @Test
    public void drawAmmo(){
        Screen screen = Mockito.mock(Screen.class);
        Ammo ammo = Mockito.mock(Ammo.class);
        Arena arena = new Arena(10,10);
        arena.setProjectiles(List.of(ammo));

        Player player = Mockito.mock(Player.class);
        arena.setPlayer(player);
        Alien alien = Mockito.mock(Alien.class);
        arena.setAliens(List.of(alien));


        arena.draw(screen.newTextGraphics());

        Mockito.verify(ammo, Mockito.times(1)).draw(screen.newTextGraphics());
    }

    @Test
    public void drawPlayer(){
        Screen screen = Mockito.mock(Screen.class);
        Player player = Mockito.mock(Player.class);
        Arena arena = new Arena(10,10);
        arena.setPlayer(player);

        Ammo ammo = Mockito.mock(Ammo.class);
        arena.setProjectiles(List.of(ammo));
        Alien alien = Mockito.mock(Alien.class);
        arena.setAliens(List.of(alien));

        arena.draw(screen.newTextGraphics());

        Mockito.verify(player, Mockito.times(1)).draw(screen.newTextGraphics());
    }

    @Test
    public void drawAlien(){
        Screen screen = Mockito.mock(Screen.class);
        Player player = Mockito.mock(Player.class);
        Arena arena = new Arena(10,10);
        arena.setPlayer(player);

        Ammo ammo = Mockito.mock(Ammo.class);
        arena.setProjectiles(List.of(ammo));
        Alien alien = Mockito.mock(Alien.class);
        arena.setAliens(List.of(alien));



        arena.draw(screen.newTextGraphics());

        Mockito.verify(player, Mockito.times(1)).draw(screen.newTextGraphics());
    }

}
