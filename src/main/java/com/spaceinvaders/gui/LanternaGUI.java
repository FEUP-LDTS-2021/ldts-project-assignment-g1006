package com.spaceinvaders.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.lang.Math.round;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private final int width;
    private final int height;

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        Terminal terminal = createTerminal(width, height, loadGameFont());
        this.screen = createScreen(terminal);
        this.width = width;
        this.height = height;
    }

    public LanternaGUI(TerminalScreen screen){
        this.screen = screen;
        this.width = 100;
        this.height = 80;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(width, height));
        return factory.createTerminal();
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        TerminalScreen terminalScreen = new TerminalScreen(terminal);
        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }

    public AWTTerminalFontConfiguration loadGameFont() throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadFont);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Action getAction() throws IOException {
        KeyStroke keyPressed = screen.pollInput();
        if (keyPressed == null) return Action.NONE;
        else if (keyPressed.getKeyType() == KeyType.ArrowUp)return Action.KEYUP;
        else if (keyPressed.getKeyType() == KeyType.ArrowDown)return Action.KEYDOWN;
        else if (keyPressed.getKeyType() == KeyType.ArrowLeft)return Action.KEYLEFT;
        else if (keyPressed.getKeyType() == KeyType.ArrowRight)return Action.KEYRIGHT;
        else if (keyPressed.getKeyType() == KeyType.Enter)return Action.ENTER;
        else if (keyPressed.getKeyType() == KeyType.EOF) return Action.EXIT;
        else if (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'q') return Action.EXIT;
        else return Action.NONE;
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public void drawBackground() {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    @Override
    public void drawPlayer(Position position) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "P");
    }

    @Override
    public void drawNormalAmmo(Position position) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#E7D501"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "|");
    }

    @Override
    public void drawSuperAmmo(Position position) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#802A00"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "|");
    }

    @Override
    public void drawNormalAlien(Position position) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#07C400"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "A");
    }

    @Override
    public void drawArmoredAlien(Position position){
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#E50000"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "A");}

    @Override
    public void drawWall(Position position) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#666666"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "O");
    }

    @Override
    public void drawHealth(int health) {
        TextGraphics textGraphics = createTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(47, 23, String.valueOf(health) + "h");
    }

    @Override
    public void drawButton(Button button) {
        TextGraphics textGraphics = createTextGraphics();
        if (button.isHighlighted())
            textGraphics.setBackgroundColor(TextColor.Factory.fromString("#666666"));
        else
            textGraphics.setBackgroundColor(TextColor.Factory.fromString(button.getColor()));

        drawRectangle(textGraphics, button.getTopleft(), button.getBottomright());

        textGraphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        textGraphics.enableModifiers(SGR.BOLD);

        double offsety = (button.getBottomright().getY() - button.getTopleft().getY())/2.0;
        int textY = (int)round(offsety) + button.getTopleft().getY();
        double offsetx = (button.getBottomright().getX()-button.getTopleft().getX()-button.getText().length())/2.0;
        int textX = (int)round(offsetx) + button.getTopleft().getX();
        textGraphics.putString(textX, textY, button.getText());
    }

    private void drawRectangle(TextGraphics textGraphics, Position topLeft, Position bottomRight){
        for(int i = topLeft.getX(); i <= bottomRight.getX(); i++ )
            for(int j = topLeft.getY(); j <= bottomRight.getY(); j++)
                textGraphics.putString(new TerminalPosition(i, j), " ");
    }
}
