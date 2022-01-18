package state;

import com.spaceinvaders.Game;
import com.spaceinvaders.controller.ArenaController;
import com.spaceinvaders.controller.Controller;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.state.GameState;
import com.spaceinvaders.state.PlayingState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameStateTest {
    private GameState gameState;
    private Arena arena;
    private Game game;
    private GUI gui;
    private ArenaController arenaController;

    @BeforeEach
    void setup(){
        this.arena = Mockito.mock(Arena.class);
        this.game = Mockito.mock(Game.class);
        this.gui = Mockito.mock(GUI.class);
        this.arenaController = Mockito.mock(ArenaController.class);
        this.gameState = new GameState(arena) {
            @Override
            public Controller getController() {
                return arenaController;
            }
        };
    }

    @Test
    void step() throws IOException {
        gameState.step(game, 0);
        Mockito.verify(arenaController, Mockito.times(1)).step(game, 0);
    }
}
