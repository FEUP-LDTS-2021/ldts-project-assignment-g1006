import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private Screen screen;
    private Arena arena;
    private int width = 50;
    private int height = 25;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e){
            e.printStackTrace();
        }
        arena = new Arena(width,height);
        setupArena(arena);
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private List<Alien> createAliens(){
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien(5,5,'A'));
        return aliens;
    }

    private List<Ammo> createProjectiles(){
        List<Ammo> ammoList = new ArrayList<>();
        ammoList.add(new Ammo(5,5,'|',1,1));
        return ammoList;
    }

    private void setupArena(Arena arena){
        arena.setPlayer(new Player(5,15,'P'));
        arena.setProjectiles(createProjectiles());
        arena.setAliens(createAliens());
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.pollInput();
            if(key != null){
                if (key.getKeyType() == KeyType.EOF)
                    break;
                if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                    screen.close();
                    break;
                }
                else if(key.getKeyType() != KeyType.ArrowDown && key.getKeyType() != KeyType.ArrowUp && key.getKeyType() != KeyType.ArrowRight && key.getKeyType() != KeyType.ArrowLeft)
                    continue;
            }
            arena.processKey(key);

            for(Alien alien : arena.getAliens()) {
                alien.move(arena);
            }

            for(Ammo ammo : arena.getProjectiles()) {
                ammo.move();
            }

            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
