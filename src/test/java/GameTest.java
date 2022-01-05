import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameTest {
    private Game game;
    private Screen screen;
    private KeyStroke key;
    @BeforeEach
    public void setup() {
        game = new Game();
        screen = Mockito.mock(Screen.class);
        key = Mockito.mock(KeyStroke.class);
        game.setScreen(screen);
    }
    @Test
    void closeTest() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(key);
        Mockito.when(key.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(key.getCharacter()).thenReturn('q');

        game.run();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
