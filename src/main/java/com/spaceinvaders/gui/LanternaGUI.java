package com.spaceinvaders.gui;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.spaceinvaders.Position;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private final int width;
    private final int height;

    public LanternaGUI(int width, int height){
        Terminal terminal = createTerminal(width, height, loadGameFont());
        this.screen = createScreen(terminal);
        this.width = width;
        this.height = height;
    }

    public LanternaGUI(TerminalScreen screen){
        this.screen = screen;
        this.width = 0;
        this.height = 0;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) {
        return null;
    }

    public TerminalScreen createScreen(Terminal terminal) {
        return null;
    }

    public AWTTerminalFontConfiguration loadGameFont(){
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void close() {

    }

    @Override
    public void drawBackground() {

    }

    @Override
    public void drawPlayer(Position position) {

    }

    @Override
    public void drawAmmo(Position position) {

    }

    @Override
    public void drawAlien(Position position) {

    }
}
