import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e){
            e.printStackTrace();
        }
        arena = new Arena(40,20);
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private void draw() throws IOException {
        screen.clear();
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.pollInput();

            if(key.getKeyType() == KeyType.EOF)
                break;
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
                break;
            }
            else if(key.getKeyType() != KeyType.ArrowDown && key.getKeyType() != KeyType.ArrowUp && key.getKeyType() != KeyType.ArrowRight && key.getKeyType() != KeyType.ArrowLeft)
                continue;
            arena.processKey(key);
        }
    }
}
