package com.spaceinvaders;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.gui.LanternaGUI;
import com.spaceinvaders.model.*;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.model.menu.StartMenu;
import com.spaceinvaders.state.GameState;
import com.spaceinvaders.state.MenuState;
import com.spaceinvaders.state.PlayingState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final GUI gui;
    private GameState gameState;
    private int width = 50;
    private int height = 25;

    private static Game singleton = null;

    private Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(width, height);
        ArenaBuilder builder = new ArenaBuilder();
        //this.gameState = new PlayingState(builder.createArena(width, height), gui);
        this.gameState = new MenuState(new StartMenu(this), gui);
    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if(singleton == null)
            singleton = new Game();
        return singleton;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GUI getGui() {
        return gui;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void run() throws IOException {
        int fps = 60;
        int frameTime = 1000 / fps;

        while (gameState != null){
            long startTime = System.currentTimeMillis();

            gameState.step(this, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ignored) {
                }
            }
        }
        gui.close();
    }
}
