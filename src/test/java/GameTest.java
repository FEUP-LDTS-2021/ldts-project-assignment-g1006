import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.Assertions;
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
        try{
            TerminalSize terminalSize = new TerminalSize(20, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
        } catch (IOException e){
            e.printStackTrace();
        }

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

    @Test
    void instanceTest() {
        new Game();
        Game game1 = Game.getInstance();
        Assertions.assertNotNull(game1);
        new Game();
        Assertions.assertEquals(Game.getInstance(),game1);
    }
}
