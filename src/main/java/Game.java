import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private Screen screen;
    private Arena arena;
    private int width = 50;
    private int height = 25;

    private static Game singleton = null;

    private Game() {
        try {
            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadFont());
            DefaultTerminalFactory factory = new DefaultTerminalFactory();
            factory.setTerminalEmulatorFontConfiguration(fontConfig);
            factory.setForceAWTOverSwing(true);
            factory.setInitialTerminalSize(new TerminalSize(width, height));

            Terminal terminal = factory.createTerminal();

            ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
            });

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException | FontFormatException | URISyntaxException e){
            e.printStackTrace();
        }
        arena = new Arena(width,height);
        setupArena(arena);
    }

    public static Game getInstance(){
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    public Font loadFont() throws URISyntaxException, IOException, FontFormatException {
        int FONT_SIZE = 20;
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();ge.registerFont(font);

        return font.deriveFont(Font.PLAIN, FONT_SIZE);
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }



    private List<List<Alien>> createAliens(){
        List<List<Alien>> aliens = new ArrayList<>();
        //aliens.add(new Alien(5,5,'A'));
        int numberOfRows = 3;
        int aliensPerRow = 6;
        for(int i = 0; i < numberOfRows; i++){
            List<Alien> row = new ArrayList<>();
            for(int j = 0; j < aliensPerRow; j++){
                row.add(new Alien(j, i, 'A'));
            }
            aliens.add(row);
        }
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

            for (List<Alien> row : arena.getAliens()) {
                for(Alien alien : row)
                    alien.move(arena);
            }

            for(Ammo ammo : arena.getProjectiles()) {
                ammo.move();
            }

            arena.checkAlienProjectilesCollisions();

            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
