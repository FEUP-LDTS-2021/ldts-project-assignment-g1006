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
import com.spaceinvaders.Position;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

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
        else if (keyPressed.getKeyType() == KeyType.ArrowLeft)return Action.KEYLEFT;
        else if (keyPressed.getKeyType() == KeyType.ArrowRight)return Action.KEYRIGHT;
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
    public void drawBackground(TextGraphics textGraphics) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#3360FF"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    @Override
    public void drawPlayer(TextGraphics textGraphics, Position position) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "P");
    }

    @Override
    public void drawAmmo(TextGraphics textGraphics, Position position) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#E7D501"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "|");
    }

    @Override
    public void drawAlien(TextGraphics textGraphics, Position position) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#07C400"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(), position.getY(), "A");
    }
}