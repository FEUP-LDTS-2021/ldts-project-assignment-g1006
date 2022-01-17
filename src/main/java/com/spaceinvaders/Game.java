package com.spaceinvaders;

import com.spaceinvaders.controller.ArenaController;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.gui.LanternaGUI;
import com.spaceinvaders.model.*;
import com.spaceinvaders.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final ArenaController arenaController;
    private final GUI gui;
    private GameState gameState;
    private int width = 50;
    private int height = 25;

    private static Game singleton = null;

    private Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(width, height);
        ArenaBuilder builder = new ArenaBuilder();
        this.arenaController = new ArenaController(builder.createArena(width, height), gui);
    }

    public static Game getInstance() throws IOException, URISyntaxException, FontFormatException {
        if(singleton == null)
            singleton = new Game();
        return singleton;
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


        while (!arenaController.exit()){
            long startTime = System.currentTimeMillis();

            arenaController.step();

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
