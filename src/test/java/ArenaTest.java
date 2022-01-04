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

        arena.draw(screen.newTextGraphics());

        Mockito.verify(ammo, Mockito.times(1)).draw(screen.newTextGraphics());
    }
}
