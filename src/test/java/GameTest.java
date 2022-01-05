import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameTest {

    @Test
    void closeTest() throws IOException {
        Game game = new Game();
        Screen screen = Mockito.mock(Screen.class);
        game.setScreen(screen);

        com.googlecode.lanterna.input.KeyStroke key = Mockito.mock(com.googlecode.lanterna.input.KeyStroke.class);
        Mockito.when(screen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('q');
        Mockito.when(screen.readInput()).thenReturn(key);

        game.run();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
